package com.jhb.ui.loading;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jhb.ui.R;
import com.pitt.loadingview.library.LoadingView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author 蒋洪波
 * @file LoadingDialogUtils.java
 * @brief 获得加载进行中的工具类
 * @date 2017-6-10
 * Copyright (c) 2017
 * All rights reserved.
 */
public class LoadingDialogUtils {

    /**
     * 这里使用强引用是因为我们必须通过他找到关联的view，最后一定要保证从该MAP中都被移除掉，否则还会泄漏
     */
    private static HashMap<Context, List<WeakReference<View>>> loadingViewMap = new HashMap<>();

    public static void clearAllContext() {
        Iterator<Map.Entry<Context, List<WeakReference<View>>>> iterator = loadingViewMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Context, List<WeakReference<View>>> next = iterator.next();
            List<WeakReference<View>> value = next.getValue();
            for (WeakReference<View> avLoadingIndicatorView : value) {
                View loadingIndicatorView = avLoadingIndicatorView.get();
//                if (loadingIndicatorView != null)
//                    loadingIndicatorView.clearContext();
            }
        }
        loadingViewMap.clear();
    }

    public static void clearContext(Context ctx) {
        List<WeakReference<View>> avLoadingIndicatorViews = loadingViewMap.get(ctx);
        if (avLoadingIndicatorViews != null) {
            for (WeakReference<View> avLoadingIndicatorView : avLoadingIndicatorViews) {
                View loadingIndicatorView = avLoadingIndicatorView.get();
//                if (loadingIndicatorView != null)
//                    loadingIndicatorView.clearContext();
            }
            loadingViewMap.remove(ctx);
        }
    }

    /**
     * @param context
     * @param msg
     * @return
     * @brief 等待对话框
     */
    public static Dialog createLoadingDialog(Context context, String msg) {
        return createLoadingDialog(context, msg, null);
    }

    /**
     * @param listener 消失回调
     * @param context
     * @param msg
     * @return
     * @brief 一个有消失回调的等待对话框
     */
    public static Dialog createLoadingDialog(Context context, String msg, OnDismissListener listener) {

        if (context == null)
            return null;

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.ui_dialog_loadingview, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        final LoadingView loadingView = (LoadingView) v.findViewById(R.id.loading_view);// 提示文字

        if (!TextUtils.isEmpty(msg)) {
            tipTextView.setText(msg);// 设置加载信息
            tipTextView.setVisibility(View.VISIBLE);
        }

//        List<WeakReference<View>> list = null;
//        if ((list = loadingViewMap.get(context)) == null) {
//            list = new ArrayList<>();
//            loadingViewMap.put(context, list);
//        }
//        list.add(new WeakReference<>(loadingView));


        Dialog loadingDialog = new Dialog(context, R.style.ui_loading_style);// 创建自定义样式dialog
        // 设置取消监听
        if (listener != null)
            loadingDialog.setOnDismissListener(listener);

        loadingDialog.setCanceledOnTouchOutside(false);// 设置外部不可点击
        loadingDialog.setCancelable(true);// 不可以用“返回键”取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        return loadingDialog;
    }
}
