package com.shopin.commonlibrary.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jhb.util.DisplayUtil;


/**
 * @author 蒋洪波
 * @version 1.0
 * @file AutoAdaptHeaderViewGroup.java
 * @brief 自适应状态栏的ViewGroup
 * @date 2017/10/13
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class AutoAdaptHeaderViewGroup extends RelativeLayout {

    private int statusBarHeight;

    public AutoAdaptHeaderViewGroup(Context context) {
        this(context, null);
    }

    public AutoAdaptHeaderViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoAdaptHeaderViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        statusBarHeight = DisplayUtil.getStatusBarHeight(getContext());
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置headerbar高度
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //加上状态栏的高度

            int paddingBottom = getPaddingBottom();
            int paddingRight = getPaddingRight();
            int paddingLeft= getPaddingLeft();
            setPadding(paddingLeft, statusBarHeight, paddingRight, paddingBottom);
        }
    }
}
