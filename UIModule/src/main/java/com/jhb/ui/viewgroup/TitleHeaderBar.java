package com.jhb.ui.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jhb.ui.R;


/**
 * @author 蒋洪波
 * @version 1.0
 * @file TitleHeaderBar.java
 * @brief 标题栏
 * @date 2017/10/13
 * Copyright (c) 2017
 * All rights reserved.
 */
public class TitleHeaderBar extends RelativeLayout {

    private View mDivider;
    private TextView mRightTextVeiw;

    private TextView mCenterTitleTextView;
    private ImageView mLeftReturnImageView;
    private ImageView mRightImageView;
    private RelativeLayout mLeftViewContainer;
    private RelativeLayout mRightViewContainer;
    private RelativeLayout mCenterViewContainer;
    private String mTitle;
    private int mCustomBackGroundColorId = -1;
    private boolean enableShowDivider = false;

    public TitleHeaderBar(Context context) {
        this(context, null);
    }

    public TitleHeaderBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleHeaderBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(this.getHeaderViewLayoutId(), this);
        this.mLeftViewContainer = (RelativeLayout) this.findViewById(R.id.rl_title_bar_left);
        this.mCenterViewContainer = (RelativeLayout) this.findViewById(R.id.rl_title_bar_center);
        this.mRightViewContainer = (RelativeLayout) this.findViewById(R.id.rl_title_bar_right);
        this.mLeftReturnImageView = (ImageView) this.findViewById(R.id.iv_title_bar_left);
        this.mRightImageView = (ImageView) this.findViewById(R.id.iv_title_bar_right);
        this.mCenterTitleTextView = (TextView) this.findViewById(R.id.tv_title_bar_title);
        this.mRightTextVeiw = (TextView) this.findViewById(R.id.tv_title_bar_right);
        this.mDivider = this.findViewById(R.id.title_header_divider);
        initStyle();
    }

    private void initStyle() {
        //设置默认颜色
//        if (mCustomBackGroundColorId == -1)
//            setBackgroundResource(R.color.titlebar_background_dark_theme);
        //设置分割线是否显示
        if (enableShowDivider)
            mDivider.setVisibility(View.VISIBLE);
        else
            mDivider.setVisibility(View.GONE);
    }

    protected int getHeaderViewLayoutId() {
        return R.layout.ui_title_header_bar;
    }

    public ImageView getLeftImageView() {
        return this.mLeftReturnImageView;
    }

    public TextView getTitleTextView() {
        return this.mCenterTitleTextView;
    }

    public void setTitle(String title) {
        this.mTitle = title;
        this.mCenterTitleTextView.setText(title);
    }

    public void setTitleColor(int color) {
        this.mCenterTitleTextView.setTextColor(color);
    }

    public String getTitle() {
        return this.mTitle;
    }

    private LayoutParams makeLayoutParams(View view) {
        ViewGroup.LayoutParams lpOld = view.getLayoutParams();
        LayoutParams lp = null;
        if (lpOld == null) {
            lp = new LayoutParams(-2, -1);
        } else {
            lp = new LayoutParams(lpOld.width, lpOld.height);
        }
        return lp;
    }

    public void setCustomizedLeftView(View view) {
        this.mLeftReturnImageView.setVisibility(View.GONE);
        this.getLeftViewContainer().setVisibility(View.VISIBLE);
        LayoutParams lp = this.makeLayoutParams(view);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.getLeftViewContainer().addView(view, lp);
    }

    /**
     * @param view
     * @brief 移除左边客制化的View
     */
    public void removeCustomizedView(View view) {
        if (view != null && this.mLeftReturnImageView != view) {
            this.getLeftViewContainer().removeView(view);
            this.mLeftReturnImageView.setVisibility(View.VISIBLE);
        }
    }

    public void setCustomizedLeftView(int layoutId) {
        View view = inflate(this.getContext(), layoutId, null);
        this.setCustomizedLeftView(view);
    }

    public void setLeftImageViewResouceId(int resouceId) {
        mLeftReturnImageView.setBackgroundResource(resouceId);
    }

    public void setCustomizedCenterView(View view) {
        this.mCenterTitleTextView.setVisibility(View.GONE);
        LayoutParams lp = this.makeLayoutParams(view);
        lp.addRule(13);
        this.getCenterViewContainer().addView(view, lp);
    }

    public void setCustomizedCenterView(int layoutId) {
        View view = inflate(this.getContext(), layoutId, null);
        this.setCustomizedCenterView(view);
    }

    public void setCustomizedRightView(View view) {
        LayoutParams lp = this.makeLayoutParams(view);
        lp.addRule(15);
        lp.addRule(11);
        this.getRightViewContainer().addView(view, lp);
    }

    /**
     * @param str
     * @brief 设置右边字符串
     */
    public void setCustomizedRightString(String str) {
        this.mRightTextVeiw.setVisibility(View.VISIBLE);
        this.mRightTextVeiw.setText(str);
        this.mRightImageView.setVisibility(View.GONE);
    }

    /**
     * @param color
     * @brief 设置右边字符串颜色
     */
    public void setCustomizedRightStringColor(int color) {
        this.mRightTextVeiw.setTextColor(color);
    }

    /**
     * @param resId 图片资源ID
     * @brief 通过resID直接设置图片
     */
    public void setCustomizedRightView(int resId) {
        this.mRightTextVeiw.setVisibility(View.GONE);
        this.mRightImageView.setVisibility(View.VISIBLE);
        this.mRightImageView.setImageResource(resId);
    }

    public void removeCustomizedRightView() {
        this.mRightTextVeiw.setVisibility(View.GONE);
        this.mRightImageView.setVisibility(View.GONE);
    }

    public RelativeLayout getLeftViewContainer() {
        return this.mLeftViewContainer;
    }

    public RelativeLayout getCenterViewContainer() {
        return this.mCenterViewContainer;
    }

    public RelativeLayout getRightViewContainer() {
        return this.mRightViewContainer;
    }

    public void setLeftOnClickListener(OnClickListener l) {
        this.mLeftViewContainer.setOnClickListener(l);
    }

    public void setCenterOnClickListener(OnClickListener l) {
        this.mCenterViewContainer.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l) {
        this.mRightViewContainer.setOnClickListener(l);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * @param resId
     * @brief 设置自定义背景
     */
    public void setCustomBackgroundResource(int resId) {
        this.mCustomBackGroundColorId = resId;
        setBackgroundResource(resId);
    }

    /**
     * @param b 是否显示分割线
     * @brief 是否显示分割线, 参考注册登录页面
     */
    public void enableShowDivider(boolean b) {
        this.enableShowDivider = b;
        if (enableShowDivider) {
            mDivider.setVisibility(VISIBLE);
        } else {
            mDivider.setVisibility(GONE);
        }
    }

    public ImageView getRightImageView() {
        return mRightImageView;
    }

    public TextView getRightTextVeiw() {
        return mRightTextVeiw;
    }

    public View getDivider(){
        return mDivider;
    }
}
