package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ConfirmOrderSimpleEntity.java
 * @brief 确认订单简单的信息
 * @date 2017/1/23
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class ConfirmOrderSimpleEntity {

    private String merchantNo;
    private String merchantName;
    private String goodsNo;
    private String goodsName;
    //品牌
    private String brand;
    private String color;
    private String quantity;
    private String price;
    private String picUrl;
    private String size;
    //折扣信息集合
    private List<DiscountEntity> discountList;
    //是否失效的状态
    private String goodsStatus;
    //自提地址
    private String ziti;
    private boolean Selected;

    public String getZiti() {
        return ziti;
    }

    public void setZiti(String ziti) {
        this.ziti = ziti;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<DiscountEntity> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<DiscountEntity> discountList) {
        this.discountList = discountList;
    }
}
