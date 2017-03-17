package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author jianghongbo
 * @version 1.0
 * @file OrderActivityEntity.java
 * @brief
 * @date 2017/2/28
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class OrderActivityEntity extends BaseWrapWheelString{


    /**
     * sid : 11301
     * campaignSid : 17251
     * name : 积分换资格
     * campaignStartDate : 2016-07-26 11:43:36
     * campaignEndDate : 2016-08-06 11:43:38
     * goodMsg : 积分换资格
     * campaignType : 7
     * channelInfo : 0,
     * memberInfo : 202
     * channelMap : {"0":"网站"}
     * productName : 1
     * needPoint : 10
     * useCount : 10
     * reduceMoney : 9.0
     * isOverlying : 0
     * maxReduceMoney : 0
     */

    private int sid;
    private int campaignSid;
    private String name;
    private String campaignStartDate;
    private String campaignEndDate;
    private String goodMsg;
    private int campaignType;
    private String channelInfo;
    private String memberInfo;
    private String productName;
    private int needPoint;
    private int useCount;
    private double reduceMoney;
    private int isOverlying;
    private int maxReduceMoney;
    private boolean selected;
    //用来标识哪个对应SID的商品
    private String productSid;

    public OrderActivityEntity() {
        super("");
    }
    public OrderActivityEntity(String wheelName) {
        super(wheelName);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCampaignSid() {
        return campaignSid;
    }

    public void setCampaignSid(int campaignSid) {
        this.campaignSid = campaignSid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setWheelName(name);
        this.name = name;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public void setCampaignStartDate(String campaignStartDate) {
        this.campaignStartDate = campaignStartDate;
    }

    public String getCampaignEndDate() {
        return campaignEndDate;
    }

    public void setCampaignEndDate(String campaignEndDate) {
        this.campaignEndDate = campaignEndDate;
    }

    public String getGoodMsg() {
        return goodMsg;
    }

    public void setGoodMsg(String goodMsg) {
        this.goodMsg = goodMsg;
    }

    public int getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(int campaignType) {
        this.campaignType = campaignType;
    }

    public String getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(String channelInfo) {
        this.channelInfo = channelInfo;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNeedPoint() {
        return needPoint;
    }

    public void setNeedPoint(int needPoint) {
        this.needPoint = needPoint;
    }

    public int getUseCount() {
        return useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public double getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(double reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public int getIsOverlying() {
        return isOverlying;
    }

    public void setIsOverlying(int isOverlying) {
        this.isOverlying = isOverlying;
    }

    public int getMaxReduceMoney() {
        return maxReduceMoney;
    }

    public void setMaxReduceMoney(int maxReduceMoney) {


        this.maxReduceMoney = maxReduceMoney;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderActivityEntity that = (OrderActivityEntity) o;

        return sid == that.sid;

    }

    @Override
    public int hashCode() {
        return sid;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setProductSid(String productSid) {
        this.productSid = productSid;
    }

    public String getProductSid() {
        return productSid;
    }
}
