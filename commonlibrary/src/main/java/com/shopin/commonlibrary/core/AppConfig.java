package com.shopin.commonlibrary.core;


import android.os.Environment;

import java.io.File;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file AppConfig.java
 * @brief 配置应用关键参数
 * @date 2017/10/17
 * Copyright (c) 2017
 * All rights reserved.
 */
public class AppConfig {

    //应用编码方式
    public static final String ENCODING = "utf-8";
    //本地数据库名称
    public static final String DATABASE_NAME = "database";

    //! 设备类型 1.IPHONE 2.IPAD 3.ANDROID
    public static final String IPHONE = "1";
    public static final String IPAD = "2";
    public static final String ANDROID = "3";
    public static final String ANDROID_UPGRADE = "2";
    //! 屏幕类型 1  小屏 2 大屏
    public static final String HD = "1";
    public static final String FULLHD = "2";
    //! APP_KEY
    public static final String APP_KEY = "123456";
    //! APPSecret
    public static final String APP_SECRET = "1dfa5cd879df472484138b41dbb6197e";


    //SD卡 统一文件夹名称
    public static final String SHOPIN_DIR = "shopin";
    //本地文件夹位置
    public static final File LOCAL_FILE_DIR = new File(Environment.getExternalStorageDirectory(), SHOPIN_DIR);

    //辨识系统常量，在某些页面需要针对
    public static final CharSequence SAMSUNG_BRAND = "samsung";
    public static final CharSequence K_TOUCH_BRAND = "K-Touch";
    public static final CharSequence HUAWEI = "huawei";
    public static final CharSequence HONOR = "honor";
    //不适配机型集合
    public static final CharSequence[] INCOMPATIBILITY_PHONE = {SAMSUNG_BRAND, K_TOUCH_BRAND, HUAWEI, HONOR};
}
