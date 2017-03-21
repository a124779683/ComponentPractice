package com.jhb.util.regex;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file RegPattern.java
 * @brief 正则表达式模型
 * @date 2017/10/17
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class RegPattern {
    //邮箱
    public static final String EMAIL_PATTERN = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    //邮政编码
    public static final String POSTCODE_PATTERN = "^\\d{6}$";
    //手机电话，只允许11为
    public static final String PHONE_PATTERN = "^[1][34578]\\d{9}$";
    //手机格式电话
    public static final String PHONE_FORMAT_PATTERN = "^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$";
    //http地址
    public static final String INTERNET_URL_PATTERN = "^http://([/\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
    //身份证
    public static final String ID_PATTERN = "^\\d{15}|\\d{18}$";
    //全是数字
    public static final String ALL_NUM_PATTERN = "^\\d{0,}$";
    //全是汉字
    public static final String ALL_HANZI_PATTERN = "^[\\u4e00-\\u9fa5]{0,}$";
    //密码校验
    public static final String PASSWORD_PATTERN = "^[a-zA-Z0-9`~!@#$%^&*()-_+=\\\",./<>?:'{}]{6,26}$";
    //中英文校验，长度可能会变动，暂时写死1,1000
    public static final String CHINESE_ENGLISH_PATTERN = "[\\u4e00-\\u9fa5a-zA-Z]{1,1000}";
    //中英文加下划线校验，长度可能会变动，暂时写死1,1000
    public static final String CHINESE_ENGLISH_XIAHUA_PATTERN = "[\\u4e00-\\u9fa5a-zA-Z0-9-_]{1,1000}";
    //中英文加数字校验，长度可能会变动，暂时写死1,1000
    public static final String CHINESE_ENGLISH_SHUZI_PATTERN = "[A-Za-z0-9\\u4e00-\\u9fa5a-zA-Z0-9-_]{1,1000}";
    //微信账号
    public static final String WECHAT_PATTERN = "^[a-zA-Z0-9-_]{1,26}$";

    //数字和符号
    public static final String NUM_SYMBOL = "^[0-9`~!@#$%^&*()-_+=\\\",./<>?:'{}]{0,}$";
}
