package com.jhb.home;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;
import com.shopin.commonlibrary.utils.LogUtil;

/**
 * @author jianghongbo
 * @version 1.0
 * @file com.jhb.home.application.TestApplication.java
 * @brief
 * @date 2017/3/15
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                LogUtil.i("home", throwable.getMessage());
            }
        });
        FreelineCore.init(this);
    }
}
