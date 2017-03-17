package com.jhb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author 蒋洪波
 * @version 版本号
 * @file DateUtils.java
 * @brief 时间工具类
 * 详细说明,如果没有请删除
 * @date 2017/10/12
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class DateUtils {


    /**
     * 获得到分的时间
     * @brief 获得月份时间
     */
    public static String getTimeWithMin() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }

    /**
     * 获得到分的时间
     * @brief 获得月份时间
     */
    public static String getTimeWithDay() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date());
    }

    /**
     * 获得到秒的时间
     * @return yyyy-MM-dd HH:mm:ss 完整格式的时间
     */
    public static String getTimeWithSec() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    }

    /**
     * 获得到毫秒的时间
     * @return yyyy-MM-dd HH:mm:ss.SSS 带毫秒的完整格式的时间
     */
    public static String getTimeWithMs() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date());
    }

    /**
     * @return yyyy-MM 年月
     * @brief 获取年月
     */
    public static String getYearMonth() {
        int year, month;
        Calendar calendar = Calendar.getInstance();
        /**
         * 获取年份
         */
        year = calendar.get(Calendar.YEAR);
        /**
         * 获取月份
         */
        month = calendar.get(Calendar.MONTH) + 1;
        String data = year + "-" + (month < 10 ? "0" + month : month);
        return data;
    }


    /**
     * @param data
     * @return
     * @brief 毫秒值
     */
    public static Date stringToDate(String data) {
        Date parse = null;
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            parse = f.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static final String getData(Date mData, String format) {
        SimpleDateFormat mDateformat = new SimpleDateFormat(format);
        return mDateformat.format(mData);
    }

    private static String getWeek(Date date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss.SSS 带毫秒的完整格式的时间
     * @brief 获得包含年的完整时间
     */
    public static String getMillionTimeAll() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date());
    }

}
