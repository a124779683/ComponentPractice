package com.jhb.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shopin.commonlibrary.api.ShopinRequestParams;
import com.shopin.commonlibrary.api.service.ServiceManager;
import com.shopin.commonlibrary.core.CommonAppLike;
import com.shopin.commonlibrary.core.di.AppComponent;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.entity.LoginResultEntity;
import com.shopin.commonlibrary.mvp.BaseView;
import com.shopin.commonlibrary.utils.LogUtil;

import butterknife.ButterKnife;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author jianghongbo
 * @version 1.0
 * @file HomeActivity.java
 * @brief
 * @date 2017/3/15
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class HomeActivity extends AppCompatActivity implements BaseView {


    private View viewById;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);
        ButterKnife.bind(this);

        viewById = findViewById(R.id.tv_haha);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.tv_haha) {
                    LogUtil.i("hahah", "freeline");
                    AppComponent appComponent = CommonAppLike.getInstance().getAppComponent();
                    ServiceManager serviceManager = appComponent.serviceManager();
                    RequestBody body = ShopinRequestParams.build().add("account", "18688997120").add("code", "1234").body();

                    serviceManager.getUserService().login(body)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new ErrorHandleSubscriber<BaseEntity<LoginResultEntity>>(appComponent.rxErrorHandler()) {


                                @Override
                                public void onNext(BaseEntity<LoginResultEntity> user) {
                                    //获取到sid  在获取用户资料
                                }
                            });


                }
            }
        });


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
