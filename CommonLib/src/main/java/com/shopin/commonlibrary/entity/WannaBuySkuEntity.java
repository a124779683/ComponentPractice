package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file WannaBuySkuEntity.java
 * @brief 要加入购物车是商品具体参数封装实体类
 * @date 2017/2/9
 * Copyright (c) 2017,上品折扣
 * All rights reserved.
 */
@Parcelable
public class WannaBuySkuEntity {

    public WannaBuySkuEntity() {
    }

    public WannaBuySkuEntity(String skuNo, String skuName, int spotQuantity) {
        this.skuNo = skuNo;
        this.skuName = skuName;
        this.spotQuantity = spotQuantity;
    }

    private String skuNo;
    private String skuName;
    private int spotQuantity;
    private int futureQuantity;

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getSpotQuantity() {
        return spotQuantity;
    }

    public void setSpotQuantity(int spotQuantity) {
        this.spotQuantity = spotQuantity;
    }

    public int getFutureQuantity() {
        return futureQuantity;
    }

    public void setFutureQuantity(int futureQuantity) {
        this.futureQuantity = futureQuantity;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WannaBuySkuEntity)
            return this.skuNo.equals(((WannaBuySkuEntity) o).getSkuNo());
        else
            return false;
    }

    @Override
    public String toString() {
        return "WannaBuySkuBean{" +
                "skuNo='" + skuNo + '\'' +
                ", skuName='" + skuName + '\'' +
                ", spotQuantity=" + spotQuantity +
                ", futureQuantity=" + futureQuantity +
                '}';
    }
}
