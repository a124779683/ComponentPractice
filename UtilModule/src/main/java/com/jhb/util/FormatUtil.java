package com.jhb.util;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author Administrator
 * @version 1.0
 * @file FormatUtil.java
 * @brief 用于格式化操作，数字转String,日期转String等等
 * @date 2017/6/11
 * Copyright (c) 2017
 * All rights reserved.
 */
public class FormatUtil {

    //千位分隔符加两位小数模板
    public static final String KILO_SPLIT_AND_DECIMAL = ",###,##0.00";

    /**
     * double格式化字符串，默认格式化为2位小数
     * @param d
     * @return
     */
    public static String doubleToString(double d) {
        return doubleToString(d, "0.00");
    }

    /**
     * exam : #,##0.00 千位分隔符加上保留两位小数  0.0 只保留一位
     * @param format
     * @return
     */
    public static String doubleToString(double d, String format) {
        String result = null;
        DecimalFormat df = null;
        try {
            df = new DecimalFormat(format);

        } catch (Exception e) {
            e.printStackTrace();
            df = new DecimalFormat(KILO_SPLIT_AND_DECIMAL);
        }

        result = df.format(d);
        return result;
    }

    /**
     * @param timeStamp 字符串类型的毫秒值
     * @return
     * @brief 格式毫秒值 成20XX-X-X格式
     */
    public static String formatData(String timeStamp) {
        if (TextUtils.isEmpty(timeStamp)) {
            return "";
        }
        long ms = Long.valueOf(timeStamp);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(ms);
    }

    public static String formatKb2MB(long size) {
        double i = Double.valueOf(size) / 1024;
        String s = doubleToString(i);
        return s;
    }

    /**
     * @param phone
     * @return
     * @brief 处理手机号 , 示例：134****234
     */
    public static String disposePhone(String phone) {
        return disposeStringByChar(phone, 11, 3, 3);
    }

    /**
     * @param phone
     * @return
     * @brief 处理身份证 , 示例：450****2134
     */
    public static String disposeIdentityCard(String phone) {
        return disposeStringByChar(phone, 18, 3, 4);
    }

    /**
     * 处理字符串，
     * @param phone
     * @param validateLength
     * @param beginIndex     距离前面索引
     * @param endIndex       距离后面个数
     * @return
     */
    public static String disposeStringByChar(String phone, int validateLength, int beginIndex, int endIndex) {
        String str = null;
        if (phone.length() == validateLength) {
            String preSuffix = phone.substring(0, beginIndex);
            String lastSuffix = phone.substring(phone.length() - endIndex, phone.length());
            str = preSuffix + "*****" + lastSuffix;
        }
        return str;
    }
}
