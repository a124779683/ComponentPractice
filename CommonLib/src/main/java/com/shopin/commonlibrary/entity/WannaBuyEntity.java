package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import org.json.JSONArray;

import java.util.List;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file WannaBuyEntity.java
 * @brief 要加入购物车封装实体类
 * @date 2017/2/9
 * Copyright (c) 2017，上品折扣
 * All rights reserved.
 */
@Parcelable
public class WannaBuyEntity {


    public WannaBuyEntity() {
    }

    public WannaBuyEntity(String merchantNo, String goodsNo, double price, int totalQuantity, String shareCode, List<WannaBuySkuEntity> skuList) {
        this.merchantNo = merchantNo;
        this.goodsNo = goodsNo;
        this.price = price;
        this.totalQuantity = totalQuantity;
        this.skuList = skuList;
        this.shareCode = shareCode;
    }

    public WannaBuyEntity(String merchantNo, String goodsNo, String cartType, double price, int totalQuantity, List<WannaBuySkuEntity> skuList) {
        this.merchantNo = merchantNo;
        this.goodsNo = goodsNo;
        this.cartType = cartType;
        this.price = price;
        this.totalQuantity = totalQuantity;
        this.skuList = skuList;
    }

    //分享编码
    private String shareCode;
    private String merchantNo;
    private String goodsNo;
    private String cartType;
    private double price;
    private int totalQuantity;
    private List<WannaBuySkuEntity> skuList;

    //省份编码，用于下面直接购买
    private String provinceNo;
    //运费模板
    private JSONArray templateIds;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getCartType() {
        return cartType;
    }

    public void setCartType(String cartType) {
        this.cartType = cartType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<WannaBuySkuEntity> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<WannaBuySkuEntity> skuList) {
        this.skuList = skuList;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    @Override
    public String toString() {
        return "WannaBuyEntity{" +
                "shareCode='" + shareCode + '\'' +
                ", merchantNo='" + merchantNo + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", cartType='" + cartType + '\'' +
                ", price=" + price +
                ", totalQuantity=" + totalQuantity +
                ", skuList=" + skuList +
                '}';
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setTemplateIds(JSONArray templateIds) {
        this.templateIds = templateIds;
    }

    public JSONArray getTemplateIds() {
        return templateIds;
    }
}
