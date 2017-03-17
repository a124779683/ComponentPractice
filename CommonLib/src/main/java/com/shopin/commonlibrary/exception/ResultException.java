package com.shopin.commonlibrary.exception;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ResultException.java
 * @brief 服务器返回结果异常
 * @date 2017/12/21
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class ResultException extends RuntimeException {

    private String resultCode;
    private String errorMessage;

    public ResultException(String message) {
        super(message);
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
