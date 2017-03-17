package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CartToConfirmEntity.java
 * @brief
 * @date 2017/2/23
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class CartToConfirmEntity {
    private List<CartItemEntity> list;
    private String expressType;
    private String shopSid;
    private String shopName;

    public List<CartItemEntity> getList() {
        return list;
    }

    public void setList(List<CartItemEntity> list) {
        this.list = list;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getShopSid() {
        return shopSid;
    }

    public void setShopSid(String shopSid) {
        this.shopSid = shopSid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
