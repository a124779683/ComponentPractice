package com.jhb.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @author jianghongbo
 * @version 1.0
 * @file ResUtil.java
 * @brief 封装了获取资源的一些方法，方便的获得字符串，颜色等资源
 * @date 2017/6/4
 * Copyright (c) 2017
 * All rights reserved.
 */
public class ResUtil {

    private static Context ctx;

    private ResUtil() {
    }

    public static void init(Context cc) {
        ctx = cc;
    }

    public static ResUtil get() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ResUtil INSTANCE = new ResUtil();
    }

    /**
     * @return Resources
     * @brief 获得当前APP的Resource的方法
     */
    private Resources getResource() {
        return ctx.getResources();
    }

    /**
     * 获取字符串
     * @param stringId
     * @return
     */
    public String getString(@StringRes int stringId) {
        return getResource().getString(stringId);
    }

    /**
     * 获取字符串，带格式化方法
     * @param stringId
     * @param formatArgs
     * @return
     */
    public String getString(int stringId, Object... formatArgs) {
        return getResource().getString(stringId, formatArgs);
    }

    /**
     * 获取Dimen值对应的像素值
     * @param dimenId
     * @return
     */
    public int getDimenPixel(int dimenId) {
        return getResource().getDimensionPixelOffset(dimenId);
    }

    /**
     * 获取颜色
     * @param colorId
     * @return
     */
    public int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    /**
     * 获取资产中的字符串
     * @param fileName
     * @return
     */
    public String getStringFromAssert(String fileName) {
        InputStream in = null;
        try {
            in = getResource().getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuilder sb = new StringBuilder();
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                }
            } while (line != null);
            bufferedReader.close();
            in.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }
}
