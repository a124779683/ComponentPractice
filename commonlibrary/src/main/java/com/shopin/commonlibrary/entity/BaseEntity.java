package com.shopin.commonlibrary.entity;


/**
 * @author 蒋洪波
 * @file BaseBean.java
 * @brief 新接口实体封装对象的基类
 * @date 2017/1/8
 * Copyright (c) 2017
 * All rights reserved.
 */
public class BaseEntity<T> {

    //结果是否正常
    public boolean success;
    //返回码
    public String code;
    //返回信息
    public String errorMessage;
    //具体数据类型
    public T data;

    //强制更新标记
    public static String FORCE_UPGRADE = "128";
    //! 不合法token 标记
    public static String INVALID_TOKENID = "004";
    //! 停机维护时间
    public static String FIX_TIME = "006";
    //! 服务器返回 JSON结果正确标记
    public static boolean RESULT_OK = true;
    public static String CODE_RESULT_OK = "A00000";
    //! JSON结果不正确标记
    public static boolean RESULT_ERROR = false;
    //! 缺少必要参数
    public static String LACK_PARAMS = "003";
    //! 服务器返回错误信息字段
    public static String ERROR_MESSAGE = "errorMessage";
    //! 服务器返回的code字段
    public static String CODE = "code";
    //网络请求的TOKEN KEY
    public static String TOKEN = "tokenId";




}
