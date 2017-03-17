package com.jhb.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author 蒋洪波
 * @file SharedPreferencesUtil.java
 * @brief SP工具
 * @date 2015-6-10
 * Copyright (c) 2015, 左键视觉[电子商务视觉完整解决方案服务商]
 * All rights reserved.
 */
public class SharedPreferencesUtil {
    private static String CONFIG = "config";
    private static SharedPreferences sharedPreferences;
    public static final String USERTOKEN = "usertoken";
    public static final String USERID = "userId";
    public static final String USERICON = "usericon";
    public static final String USERNAME = "username";
    public static final String USERINFO = "userInfo";

    /**
     * 删除key键的值
     *
     * @param context
     * @param key
     */
    public static void removeStringData(Context context, String key) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }

        sharedPreferences.edit().remove(key).commit();
    }

    // 存
    public static synchronized void saveStringData(Context context, String key,
                                                   String value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }

        sharedPreferences.edit().putString(key, value).commit();
    }



    // 存boolean
    public static void saveBooleanData(Context context, String key,
                                       boolean value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }

        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    // 取boolean
    public static boolean getBooleanData(Context context, String key,
                                         boolean defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key, defValue);
    }

    // 取
    public static synchronized String getStringData(Context context,
                                                    String key, String defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key, defValue);
    }

    // 删
    public static boolean deleteStringData(Context context, String key) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences.edit().remove(key).commit();
    }

    /**
     * 删除boolean值
     *
     * @param applicationContext
     * @param string
     */
    public static void removeBooleanData(Context applicationContext,
                                         String string) {
        if (sharedPreferences == null) {
            sharedPreferences = applicationContext.getSharedPreferences(CONFIG,
                    Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().remove(string).commit();
    }



}
