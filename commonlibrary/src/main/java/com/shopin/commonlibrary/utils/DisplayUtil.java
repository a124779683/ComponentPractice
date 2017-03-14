package com.shopin.commonlibrary.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file DisplayUtil.java
 * @brief 获得当前手机一些屏幕信息
 * @date 2017/9/22
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class DisplayUtil {

    /**
     * 获得不同手机状态栏高度
     * @param ctx
     * @return
     */
    public static int getStatusBarHeight(Context ctx) {

        Class<?> c = null;

        Object obj = null;

        Field field = null;

        int x = 0, statusBarHeight = 0;

        try {

            c = Class.forName("com.android.internal.R$dimen");

            obj = c.newInstance();

            field = c.getField("status_bar_height");

            x = Integer.parseInt(field.get(obj).toString());

            statusBarHeight = ctx.getResources().getDimensionPixelOffset(x);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 魅族手机判断是否有SmartBar 并隐藏SmartBar
     * @return
     */
    @SuppressWarnings("unused")
    public static boolean judgeBar() {
        boolean isHasBar = false;
        try {
            try {
                Method method = Class.forName("android.os.Build").getMethod(
                        "hasSmartBar");
                isHasBar = ((Boolean) method.invoke(null)).booleanValue();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isHasBar;
    }

    /**
     * 全屏显示。。
     */
    @SuppressLint("NewApi")
    public static void getFullScrean(Activity ctx) {
        Window mWindow = ctx.getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        mWindow.setAttributes(params);
    }

    /**
     * @param ctx
     * @brief 获得屏幕像素密度
     */
    public static float getScreenDensity(Context ctx) {
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /**
     * @param context
     * @param dipValue
     * @return
     * @brief DP转像素
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * @param context
     * @param
     * @return
     * @brief 像素转DP
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 是否有导航栏
     * @param context
     * @return
     */
    private static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasNavigationBar;
    }

    /**
     * @param context
     * @return
     * @brief 获取导航栏（虚拟按键高度）
     */
    public static int getNavigationBarHeight(Context context) {
        int navigationBarHeight = 0;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("navigation_bar_height", "dimen", "android");
        if (id > 0 && checkDeviceHasNavigationBar(context)) {
            navigationBarHeight = rs.getDimensionPixelSize(id);
        }
        return navigationBarHeight;
    }

    private static DisplayMetrics dm = null;

    public static int getScreenWidth(Context context) {
        return getScreenWidthInPx(context);
    }

    public static int getScreenHeight(Context context) {
        return getScreenHeightInPx(context);
    }


    static public DisplayMetrics getDisplayMetrics(Context context) {
        if (dm == null) {
            dm = context.getResources().getDisplayMetrics();
        }
        return dm;
    }

    static public int px2dp(Context context, int px) {
        if (context == null) {
            return px;
        }
        getDisplayMetrics(context);
        final float density = dm.density;
        return (int) (px / density + 0.5f);
    }

    static public int dp2px(Context context, float dp) {
        if (context == null) {
            return (int) dp;
        }
        getDisplayMetrics(context);
        final float density = dm.density;
        return (int) (dp * density + 0.5f);
    }

    static public int px2sp(Context context, float px) {
        if (context == null) {
            return (int) px;
        }
        getDisplayMetrics(context);
        return (int) (px / dm.scaledDensity + 0.5f);
    }

    static public int sp2px(Context context, float sp) {
        if (context == null) {
            return (int) sp;
        }
        getDisplayMetrics(context);
        return (int) (sp * dm.scaledDensity + 0.5f);
    }

    static public int getScreenWidthInPx(Context context) {
        getDisplayMetrics(context);
        return dm.widthPixels;
    }

    static public int getScreenHeightInPx(Context context) {
        getDisplayMetrics(context);
        return dm.heightPixels;
    }

    static public int getScreenWidthInDp(Context context) {
        getDisplayMetrics(context);
        return (int) ((float) dm.widthPixels * (160 / dm.xdpi));
    }

    static public int getScreenHeightInDp(Context context) {
        getDisplayMetrics(context);
        int screenHeight = dm.heightPixels;
        return (int) ((float) screenHeight / dm.density);
    }

    static public float getDensity(Context context) {
        getDisplayMetrics(context);
        return dm.density;
    }

    public static int getScreenTitleBarHeight(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView()
                .getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
