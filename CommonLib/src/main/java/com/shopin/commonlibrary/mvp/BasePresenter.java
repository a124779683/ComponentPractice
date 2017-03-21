package com.shopin.commonlibrary.mvp;


import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author jianghongbo
 * @version 1.0
 * @file BasePresenter.java
 * @brief
 * @date 2017/6/4
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class BasePresenter<M extends IModel, V extends BaseView> implements presenter {
    protected final String TAG = this.getClass().getSimpleName();
    protected CompositeSubscription mCompositeSubscription;

    protected M mModel;
    protected V mRootView;

    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }


    /**
     * 控制器被初始化的时候自动调用
     */
    @Override
    public void onStart() {
    }

    @Override
    public void onDestroy() {
        unSubscribe();//解除订阅
        if (mModel != null) {
            mModel.onDestory();
            this.mModel = null;
        }
        mRootView.hideLoading();
        this.mRootView = null;
        this.mCompositeSubscription = null;
    }


    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);//将所有subscription放入,集中处理
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();//保证activity结束时取消所有正在执行的订阅
        }
    }

    @Override
    public void unSubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();//保证activity结束时取消所有正在执行的订阅
        }
    }

}