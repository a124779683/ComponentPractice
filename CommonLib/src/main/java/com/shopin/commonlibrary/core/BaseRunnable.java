package com.shopin.commonlibrary.core;

import java.lang.ref.WeakReference;

/**
 * @author jianghongbo
 * @version 1.0
 * @file BaseRunnable.java
 * @brief runnable简单封装好使用
 * @date 2017/12/25
 * Copyright (c) 2017，上品折扣
 * All rights reserved.
 */
public abstract class BaseRunnable<T> implements Runnable {

    WeakReference<T> weakReference;

    public BaseRunnable() {

    }

    public BaseRunnable(T t) {
        weakReference = new WeakReference<>(t);
    }

    @Override
    public void run() {
        T t = null;
        if (weakReference != null && (t = weakReference.get()) != null) {
            handle(t);
        } else {
            handle(null);
        }
    }

    protected abstract void handle(T t);
}
