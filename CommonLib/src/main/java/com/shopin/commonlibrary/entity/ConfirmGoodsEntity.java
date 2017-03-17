package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ConfirmGoodsEntity.java
 * @brief
 * @date 2017/2/11 18:39
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class ConfirmGoodsEntity {
    private String type;
    //运费
    private String fee;

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    private List<ConfirmOrderSimpleEntity> goodsList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ConfirmOrderSimpleEntity> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ConfirmOrderSimpleEntity> goodsList) {
        this.goodsList = goodsList;
    }
}
