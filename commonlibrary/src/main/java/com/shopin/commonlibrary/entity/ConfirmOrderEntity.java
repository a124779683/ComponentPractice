package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file ConfirmOrderEntity.java
 * @brief 确认订单返回实体
 * @date 2017/2/9
 * Copyright (c) 2017
 * All rights reserved.
 */
@Parcelable
public class ConfirmOrderEntity {
    private String memberNo;
    private String totalPrice;
    private String totalQuantity;
    private String totalDelieveryFee;
    private boolean isUseIntegral = false;
    private String useIntegralNum;
    private String integralAmount;
    //直接购买标记
    private boolean isDirectBuy;

    public boolean isDirectBuy() {
        return isDirectBuy;
    }

    public void setDirectBuy(boolean directBuy) {
        isDirectBuy = directBuy;
    }

    public String getUseIntegralNum() {
        return useIntegralNum;
    }

    public void setUseIntegralNum(String useIntegralNum) {
        this.useIntegralNum = useIntegralNum;
    }

    public String getIntegralAmount() {
        return integralAmount;
    }

    public void setIntegralAmount(String integralAmount) {
        this.integralAmount = integralAmount;
    }

    public boolean isUseIntegral() {
        return isUseIntegral;
    }

    public void setUseIntegral(boolean useIntegral) {
        isUseIntegral = useIntegral;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTotalDelieveryFee() {
        return totalDelieveryFee;
    }

    public void setTotalDelieveryFee(String totalDelieveryFee) {
        this.totalDelieveryFee = totalDelieveryFee;
    }

}
