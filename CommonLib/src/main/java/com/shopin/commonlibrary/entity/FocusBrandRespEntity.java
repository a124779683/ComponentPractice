package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file FocusBrandRespEntity.java
 * @brief
 * @date 2017/3/8
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class FocusBrandRespEntity {


    /**
     * brandName : ceshi固定值
     * memberSid : 100
     * createTime : 1488179092000
     * brandSid : 51
     * brandPictUrl : /brand/Pic2591_1.jpg
     * delFlag : 1
     * optTime : 1488179092000
     * sid : 18
     */

    private String brandName;
    private int memberSid;
    private long createTime;
    private int brandSid;
    private String brandPictUrl;
    private int delFlag;
    private long optTime;
    private int sid;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(int memberSid) {
        this.memberSid = memberSid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getBrandSid() {
        return brandSid;
    }

    public void setBrandSid(int brandSid) {
        this.brandSid = brandSid;
    }

    public String getBrandPictUrl() {
        return brandPictUrl;
    }

    public void setBrandPictUrl(String brandPictUrl) {
        this.brandPictUrl = brandPictUrl;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public long getOptTime() {
        return optTime;
    }

    public void setOptTime(long optTime) {
        this.optTime = optTime;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
