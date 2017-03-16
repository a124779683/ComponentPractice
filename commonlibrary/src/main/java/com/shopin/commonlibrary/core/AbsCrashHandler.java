package com.shopin.commonlibrary.core;

/**
 * @author jianghongbo
 * @version 1.0
 * @file AbsCrashHandler.java
 * @brief
 * @date 2017/12/19
 * Copyright (c) 2017
 * All rights reserved.
 */
public abstract class AbsCrashHandler implements Thread.UncaughtExceptionHandler {

    public void init() {
        Thread.currentThread().setUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(final Thread thread, final Throwable throwable) {
        handleException(throwable);
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     * @param throwable
     */
    private void handleException(final Throwable throwable) {
        if (!AppConfig.LOCAL_FILE_DIR.exists())
            AppConfig.LOCAL_FILE_DIR.mkdirs();
        saveCrash(throwable);
    }

    /**
     * 保存崩溃的信息
     */
    abstract void saveCrash(Throwable throwable);
}
