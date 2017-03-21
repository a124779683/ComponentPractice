package com.shopin.commonlibrary.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.jhb.ui.viewgroup.MultipleStatusView;
import com.jhb.ui.viewgroup.TitleHeaderBar;
import com.shopin.commonlibrary.R;
import com.shopin.commonlibrary.mvp.BasePresenter;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * @author Administrator
 * @version 1.0
 * @file TitleBaseActivity.java
 * @brief 带头的ACTIVITY
 * @date 2017/6/7
 * Copyright (c) 2017
 * All rights reserved.
 */
public abstract class TitleBaseActivity<P extends BasePresenter> extends AppBaseActivity<P> {

    protected TitleHeaderBar mTitleHeaderBar;
    protected FrameLayout mContentContainer;
    MultipleStatusView mBaseMultiple;
    private boolean layoutIsAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public TitleHeaderBar getTitleHeaderBar() {
        return (TitleHeaderBar) findViewById(R.id.content_frame_title_header);
    }

    protected FrameLayout getContentContainer() {
        return (FrameLayout) findViewById(R.id.content_view);
    }

    public MultipleStatusView getMultipleStatusView() {
        return (MultipleStatusView) findViewById(R.id.base_multiplestatusview);
    }

    @Override
    protected void initBaseLayout() {
        //用基类布局
        super.setContentView(R.layout.ui_base_activity_with_title_header);
        mTitleHeaderBar = getTitleHeaderBar();
        mContentContainer = getContentContainer();
        mBaseMultiple = getMultipleStatusView();
        if (enableDefaultBack()) {
            mTitleHeaderBar.setLeftOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onBackPressedSupport();
                }
            });
        } else {
            mTitleHeaderBar.getLeftViewContainer().setVisibility(View.INVISIBLE);
        }
        if (getLayoutId() != 0 && !layoutIsAdded) {
            setContentView(getLayoutId());
            layoutIsAdded = true;
        }

        mBaseMultiple.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mBaseMultiple.getViewStatus()) {
                    case MultipleStatusView.STATUS_EMPTY:
                    case MultipleStatusView.STATUS_ERROR:
                    case MultipleStatusView.STATUS_NO_NETWORK:
                        retry();
                        break;
                }
            }
        });
    }

    protected boolean enableDefaultBack() {
        return true;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        mContentContainer.addView(view);
    }

    public void setContentViewSupper(int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected void setHeaderTitle(int id) {
        mTitleHeaderBar.getTitleTextView().setText(id);
    }

    protected void setHeaderTitle(String title) {
        mTitleHeaderBar.setTitle(title);
    }

    /**
     * 加载fragment，具体更多方法参考fragmentation
     * @param toFragment
     */
    public void loadRootFragment(SupportFragment toFragment) {
        SupportFragment fragment = findFragment(toFragment.getClass());

        if (fragment == null)
            super.loadRootFragment(getContentContainer().getId(), toFragment);
    }

    public void loadMultipleRootFragment(int showPosition, SupportFragment... toFragments) {
        super.loadMultipleRootFragment(getContentContainer().getId(), showPosition, toFragments);
    }

    /**
     * 展示空数据Activity
     */
    protected void showActEmpty() {
        mBaseMultiple.showEmpty();
    }

    /**
     * 展示错误Activity界面
     */
    protected void showActError() {
        mBaseMultiple.showError();
    }

    /**
     * 展示没有网络状态Activity
     */
    protected void showActNoNetwork() {
        mBaseMultiple.showNoNetwork();
    }

    /**
     * 展示正常Activity的进度条
     */
    protected void showActLoading() {
        mBaseMultiple.showLoading();
    }

    /**
     * 展示正常Activity的内容
     */
    protected void showActContent() {
        mBaseMultiple.showContent();
    }

    /**
     * 出现错误的时候重试点击事件
     */
    protected void retry() {
        showMessage("重试");
    }

}
