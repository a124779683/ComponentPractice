package com.shopin.commonlibrary.core;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.shopin.commonlibrary.BuildConfig;
import com.shopin.commonlibrary.R;
import com.shopin.commonlibrary.permission.DialogText;
import com.shopin.commonlibrary.permission.PermissifyConfig;
import com.shopin.commonlibrary.utils.LogUtil;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.zhy.changeskin.SkinManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;


/**
 * @author jianghongbo
 * @version 1.0
 * @file AppLike.java
 * @brief 不要在这里初始化组件里的任何东西
 * @date 2017/12/16
 * Copyright (c) 2017
 * All rights reserved.
 */
public class CommonAppLike extends DefaultApplicationLike {

    private static Boolean isDebug;
    private static CommonAppLike appLike;

    //单位，小时
    private int tinkerUpdateInterval = 3;
    private String versionName;

    public CommonAppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                         long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
        appLike = this;
    }

    /**
     * install multiDex before install tinker
     * so we don't need to put the tinker lib classes in the main dex
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init();
        LogUtil.init(isDebug());
        initPermission();
        initSkin();
    }

    private void initSkin() {
        SkinManager.getInstance().init(getApplication());
    }

    private void initPermission() {
        PermissifyConfig permissifyConfig = new PermissifyConfig.Builder()
                .withDefaultTextForPermissions(new HashMap<String, DialogText>() {{
                    put(Manifest.permission_group.STORAGE, new DialogText(R.string.storage_rational, R.string.storage_deny_dialog));
                    put(Manifest.permission_group.CONTACTS, new DialogText(R.string.contact_rational, R.string.contact_deny_dialog));
                    put(Manifest.permission_group.PHONE, new DialogText(R.string.phone_rational, R.string.phone_deny_dialog));
                    put(Manifest.permission_group.SMS, new DialogText(R.string.sms_rational, R.string.sms_deny_dialog));
                    put(Manifest.permission_group.CAMERA, new DialogText(R.string.camera_rational, R.string.camera_deny_dialog));
                    put(Manifest.permission_group.LOCATION, new DialogText(R.string.location_rational, R.string.location_deny_dialog));
                }})
                .build();

        PermissifyConfig.initDefault(permissifyConfig);
    }


    public static CommonAppLike getInstance() {
        return appLike;
    }

    public static boolean isDebug() {
        if (isDebug == null) {
            try {
                final Class<?> activityThread = Class.forName("android.app.ActivityThread");
                final Method currentPackage = activityThread.getMethod("currentPackageName");
                final String packageName = (String) currentPackage.invoke(null, (Object[]) null);
                final Class<?> buildConfig = Class.forName(packageName + ".BuildConfig");
                final Field DEBUG = buildConfig.getField("DEBUG");
                DEBUG.setAccessible(true);
                isDebug = DEBUG.getBoolean(null);
            } catch (final Throwable t) {
                final String message = t.getMessage();
                if (message != null && message.contains("BuildConfig")) {
                    // Proguard obfuscated build. Most likely a production build.
                    isDebug = false;
                } else {
                    isDebug = BuildConfig.DEBUG;
                }
            }
        }
        return isDebug;
    }
}
