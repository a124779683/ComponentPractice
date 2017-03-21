package com.shopin.commonlibrary.core;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.flyco.systembar.SystemBarHelper;
import com.jhb.ui.loading.LoadingDialogUtils;
import com.jhb.util.ActivityUtil;
import com.jhb.util.ResUtil;
import com.jhb.util.ToastUtil;
import com.jhb.util.UIUtils;
import com.shopin.commonlibrary.core.di.AppComponent;
import com.shopin.commonlibrary.mvp.BasePresenter;
import com.shopin.commonlibrary.mvp.BaseView;

import javax.inject.Inject;


/**
 * @author jianghongbo
 * @version 1.0
 * @file AppBaseActivity.java
 * @brief Activity业务基类
 * @date 2017/12/25
 * Copyright (c) 2017，上品折扣
 * All rights reserved.
 */
public abstract class AppBaseActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    protected CommonAppLike mApplication;

    @Inject
    protected P mPresenter;
    //状态深色样式
    public static final int TITLE_STYLE_DARK = 0x0;
    //浅色样式
    public static final int TITLE_STYLE_LIGHT = 0x1;
    //男士标题
    public static final int TITLE_STYLE_MALE = 0x2;
    //女士标题
    public static final int TITLE_STYLE_FEMAL = 0x3;
    //儿童标题
    public static final int TITLE_STYLE_CHILD = 0x4;

    //透明
    protected static final int TITLE_STYLE_TRANSPARENT = 0x2;

    //是否活动的标记
    private boolean isActive;
    //加载进度条
    private Dialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isActive = true;
        // 添加Activity到堆栈
        ActivityUtil.getInstance().addActivity(this);
        getIntentParams();
        initBaseLayout();
        setStatusBarStyle();//不能加到前面
        bindView();
        initViews(savedInstanceState);
        initComponent();
        initData();
    }

    private void initComponent() {
        AppComponent appComponent = CommonAppLike.getInstance().getAppComponent();
        setupActivityComponent(appComponent);//依赖注入
    }

    private void bindView() {
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);

    /**
     * 获得整个布局ID
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        this.mApplication = null;
        isActive = false;
        ActivityUtil.getInstance().finishActivity(this);
        super.onDestroy();

    }

    /**
     * 提供给子类初始化基类布局使用
     */
    protected void initBaseLayout() {
    }

    /**
     * 获取标题栏样式
     * @return
     */
    protected int getTitleBarStyle() {
        return TITLE_STYLE_DARK;
    }

    private void setStatusBarStyle() {
        //此项目只根据主题类型设置
        int titleBarStyle = getTitleBarStyle();
        switch (titleBarStyle) {
            case TITLE_STYLE_TRANSPARENT:
                SystemBarHelper.immersiveStatusBar(this, 0f);
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {
        if (loadingDialog != null && loadingDialog.isShowing())
            return;
        if (loadingDialog == null)
            loadingDialog = LoadingDialogUtils.createLoadingDialog(this, null);
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        UIUtils.closeDialog(loadingDialog);
    }

    @Override
    public void showMessage(String message) {
        ToastUtil.showToast(getBaseContext(),message);
    }

    public void showMessage(@StringRes int res) {
        showMessage(ResUtil.get().getString(res));
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}
