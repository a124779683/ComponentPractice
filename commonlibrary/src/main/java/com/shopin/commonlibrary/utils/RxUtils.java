package com.shopin.commonlibrary.utils;

import android.text.TextUtils;

import com.shopin.commonlibrary.core.BaseActivity;
import com.shopin.commonlibrary.core.BaseFragment;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.exception.ResultException;
import com.shopin.commonlibrary.mvp.BaseView;
import com.trello.rxlifecycle.LifecycleTransformer;

import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jess on 11/10/2017 16:39
 * Contact with jess.yan.effort@gmail.com
 */

public class RxUtils {

    public static <T> Observable.Transformer<BaseEntity<T>, T> applySchedulers(final BaseView view) {
        return applySchedulers(view, true);
    }

    public static <T> LifecycleTransformer<T> bindToLifecycle(BaseView view) {
        if (view instanceof BaseActivity) {
            return ((BaseActivity) view).<T>bindToLifecycle();
        } else if (view instanceof BaseFragment) {
            return ((BaseFragment) view).<T>bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }

    }


    /**
     * @param view
     * @param hide 是否請求完畢后隱藏進度條
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseEntity<T>, T> applySchedulers(final BaseView view, final boolean hide) {
        return new Observable.Transformer<BaseEntity<T>, T>() {
            @Override
            public Observable<T> call(final Observable<BaseEntity<T>> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .retryWhen(new RetryWithDelay(3, 4))
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {//显示进度条
                                if (view != null)
                                    view.showLoading();
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doAfterTerminate(new Action0() {
                            @Override
                            public void call() {
                                if (hide && view != null)
                                    view.hideLoading();//隐藏进度条
                            }
                        })
                        .map(new Func1<BaseEntity<T>, T>() {
                            @Override
                            public T call(BaseEntity<T> httpResult) {
                                if (hide && view != null)
                                    view.hideLoading();//隐藏进度条
                                if (httpResult.success || TextUtils.equals(httpResult.code, BaseEntity.CODE_RESULT_OK)) {
                                    httpResult.success = true;
                                    return httpResult.data;
                                }
                                ResultException resultException = new ResultException(httpResult.errorMessage);
                                resultException.setResultCode(httpResult.code);
                                throw resultException;
                            }
                        })
                        .compose(RxUtils.<T>bindToLifecycle(view));
            }
        };
    }
}
