package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file ConfirmOrderEntity.java
 * @brief 预下单返回实体
 * @date 2017/2/9
 * Copyright (c) 2017
 * All rights reserved.
 */
@Parcelable
public class AdvanceConfirmOrderEntity {

    private String discountMoney;
    private String sendCost;
    private double totalMoney;

    public String getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(String discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getSendCost() {
        return sendCost;
    }

    public void setSendCost(String sendCost) {
        this.sendCost = sendCost;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
