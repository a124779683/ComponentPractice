package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CartItemsEntity.java
 * @brief
 * @date 2017/2/22
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class CartItemsEntity {

   private List<CartItemEntity> cartItems;
    private String expressType;
    private String shopSid;
    private String shopName;
    private boolean edit;
    private boolean select;

    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isEdit() {
        return edit;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
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
