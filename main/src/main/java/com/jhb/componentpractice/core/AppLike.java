package com.jhb.componentpractice.core;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.antfortune.freeline.FreelineCore;
import com.jhb.componentpractice.BuildConfig;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;


/**
 * @author jianghongbo
 * @version 1.0
 * @file AppLike.java
 * @brief 替代APPLICATION的实现
 * @date 2017/12/16
 * Copyright (c) 2017
 * All rights reserved.
 */
public class AppLike extends DefaultApplicationLike {

    private static boolean isDebug = BuildConfig.DEBUG ? true : false;
    private static AppLike appLike;
    //单位，小时
    private int tinkerUpdateInterval = 3;
    private String versionName;

    public AppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
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
        //you must install multiDex whatever tinker is installed!
        initMultiDex(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initTinker();
        FreelineCore.init(getApplication());
    }

    private void initTinker() {
        if (BuildConfig.TINKER_ENABLE) {
            TinkerPatch.init(this)
                    .reflectPatchLibrary()
                    .setPatchRollbackOnScreenOff(true)
                    .setPatchRestartOnSrceenOff(true);

            // 每隔3个小时去访问后台时候有更新,通过handler实现轮训的效果
            new FetchPatchHandler().fetchPatchWithInterval(3);
        }
    }

    private void initMultiDex(Context base) {
        MultiDex.install(base);
    }

    public static AppLike getInstance() {
        return appLike;
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
