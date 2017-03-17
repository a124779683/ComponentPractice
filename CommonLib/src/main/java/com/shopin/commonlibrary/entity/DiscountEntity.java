package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 蒋洪波
 * @version 1.0
 * @file ConfirmOrderEntity.java
 * @brief 折扣信息
 * @date 2017/2/9
 * Copyright (c) 2017
 * All rights reserved.
 */
@Parcelable
public class DiscountEntity extends BaseWrapWheelString {
    private int id;
    private boolean isSelected;
    private String discountInfo;

    private double totalReduceMoney;
    private int totalReducePoint;

    public DiscountEntity(String wheelName) {
        super(wheelName);
    }

    public DiscountEntity() {
        super(null);
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo;
        setWheelName(discountInfo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        DiscountEntity that = (DiscountEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public double getTotalReduceMoney() {
        return totalReduceMoney;
    }

    public void setTotalReduceMoney(double totalReduceMoney) {
        this.totalReduceMoney = totalReduceMoney;
    }

    public int getTotalReducePoint() {
        return totalReducePoint;
    }

    public void setTotalReducePoint(int totalReducePoint) {
        this.totalReducePoint = totalReducePoint;
    }
}
