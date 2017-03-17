package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file BrandInfoEntity.java
 * @brief 品牌信息实体
 * @date 2017/2/21
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class BrandInfoEntity {

    private boolean isFocus;
    /**
     * brandPict : /brand/Pic285_0.jpg
     * brandName : ELLE
     * logoPict : /brand/Pic285_1.jpg
     * brandErpSid : B017
     * brandSid : 9151
     */

    //品牌图片
    private String brandPict;
    private String brandName;
    private String logoPict;
    private String brandErpSid;
    private int brandSid;

    public boolean isFocus() {
        return isFocus;
    }

    public void setFocus(boolean focus) {
        isFocus = focus;
    }


    public String getBrandPict() {
        return brandPict;
    }

    public void setBrandPict(String brandPict) {
        this.brandPict = brandPict;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogoPict() {
        return logoPict;
    }

    public void setLogoPict(String logoPict) {
        this.logoPict = logoPict;
    }

    public String getBrandErpSid() {
        return brandErpSid;
    }

    public void setBrandErpSid(String brandErpSid) {
        this.brandErpSid = brandErpSid;
    }

    public int getBrandSid() {
        return brandSid;
    }

    public void setBrandSid(int brandSid) {
        this.brandSid = brandSid;
    }
}
