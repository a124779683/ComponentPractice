package com.shopin.commonlibrary.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhb.ui.viewgroup.CodeMultipleStatusView;
import com.jhb.util.ResUtil;
import com.shopin.commonlibrary.core.di.AppComponent;
import com.shopin.commonlibrary.mvp.BasePresenter;
import com.shopin.commonlibrary.mvp.BaseView;

import javax.inject.Inject;


/**
 * @author jianghongbo
 * @version 1.0
 * @file AppBaseFragment.java
 * @brief
 * @date 2017/12/25
 * Copyright (c) 2017
 * All rights reserved.
 */
public abstract class AppBaseFragment<P extends BasePresenter> extends BaseFragment implements BaseView{

    protected BaseActivity mActivity;
    protected CodeMultipleStatusView mRootView;
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    protected P mPresenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        this.mActivity = null;
        this.mRootView = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = new CodeMultipleStatusView(getContext());
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mActivity = (BaseActivity) getActivity();
        initComponent();
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        //加载我们自己的布局
        View view = View.inflate(getContext(), this.getLayoutId(), null);
        mRootView.setContentView(view);
        mRootView.showContent();
        mRootView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retry();
            }
        });
        initView(view, savedInstanceState);
        initData();
    }

    private void initComponent() {
        AppComponent appComponent = CommonAppLike.getInstance().getAppComponent();
        setupFragmentComponent(appComponent);
    }

    protected void setHeaderTitle(String title) {
        if (getBaseActivity() instanceof TitleBaseActivity) {
            ((TitleBaseActivity) getBaseActivity()).setHeaderTitle(title);
        }
    }

    protected void setHeaderTitle(@StringRes int res) {
        if (getBaseActivity() instanceof TitleBaseActivity) {
            ((TitleBaseActivity) getBaseActivity()).setHeaderTitle(res);
        }
    }

    /**
     * 注入Fragment的组件
     * @param appComponent
     */
    protected abstract void setupFragmentComponent(AppComponent appComponent);

    /**
     * 初始化控件
     */
    protected abstract void initView(View v, Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 获得Fragment布局ID，除了TitleBaseFragment。
     * @return
     */
    @NonNull
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 获得所属Activity，有可能为空
     * @return
     */
    protected AppBaseActivity getBaseActivity() {
        if (getActivity() instanceof AppBaseActivity)
            return (AppBaseActivity) getActivity();
        return null;
    }


    @Override
    public void showLoading() {
        AppBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && baseActivity.isActive())
            baseActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        AppBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && baseActivity.isActive())
            baseActivity.hideLoading();
    }

    @Override
    public void showMessage(String message) {
        if (getBaseActivity() != null) {
            getBaseActivity().showMessage(message);
        }
    }

    public void showMessage(@StringRes int res) {
        showMessage(ResUtil.get().getString(res));
    }

    @Override
    public boolean isActive() {
        return this.isAdded();
    }

    protected void showFragmentEmpty() {
        mRootView.showEmpty();
    }

    protected void showFragmentError() {
        mRootView.showError();
    }

    protected void showFragmentNoNetwork() {
        mRootView.showNoNetwork();
    }

    protected void showFragmentLoading() {
        mRootView.showLoading();
    }

    protected void showFragmentContent() {
        mRootView.showContent();
    }

    /**
     * 状态不为正常内容处理点击需要重写的方法
     */
    protected void retry() {
    }
}
