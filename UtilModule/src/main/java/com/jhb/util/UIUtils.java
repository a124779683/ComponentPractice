package com.jhb.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;

/**
 * @author 蒋洪波
 * @file UIUtils.java
 * @brief 视图工具类
 * @date 2017-6-10
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class UIUtils {

    /**
     * @param window 需要关闭的window对象
     * @brief 关闭PopupWindow的方法
     */
    public static void closePopupWindow(PopupWindow window) {
        if (window != null && window.isShowing())
            window.dismiss();
    }

    /**
     * @param dialog 需要关闭的dialog的对象
     * @brief 关闭Dialog的方法
     */
    public static void closeDialog(Dialog dialog) {
        //关闭这个dialog还得看是否是当前的Activity
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    /**
     * 关闭软键盘
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(View mEditText, Context mContext) {
        if (mEditText != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
        }
    }
}
