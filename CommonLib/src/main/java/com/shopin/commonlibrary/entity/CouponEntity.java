package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CouponEntity.java
 * @brief
 * @date 2017/2/28
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class CouponEntity extends BaseWrapWheelString{

    /**
     * accountCode : 68577
     * endTime : 2017-06-01 00:00:00
     * maxOrderMoney : 0
     * minOrderMoney : 10.01
     * pageSize : 15
     * prefix : AH1
     * sid : 37454409
     * sn : AH114N2T0HM372087
     * start : 0
     * startTime : 2016-10-25 00:00:00
     * total : 0
     * type : 1
     * useStatus : 1
     * value : 10
     */
    private int id;
    private boolean isSelected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public CouponEntity() {
        super("");

    }
    public CouponEntity(String wheelName) {
        super(wheelName);
    }

    private String accountCode;
    private String endTime;
    private int maxOrderMoney;
    private double minOrderMoney;
    private int pageSize;
    private String prefix;
    private int sid;
    private String sn;
    private int start;
    private String startTime;
    private int total;
    private int type;
    private int useStatus;
    private double value;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getMaxOrderMoney() {
        return maxOrderMoney;
    }

    public void setMaxOrderMoney(int maxOrderMoney) {
        this.maxOrderMoney = maxOrderMoney;
    }

    public double getMinOrderMoney() {
        return minOrderMoney;
    }

    public void setMinOrderMoney(double minOrderMoney) {
        this.minOrderMoney = minOrderMoney;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(int useStatus) {
        this.useStatus = useStatus;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouponEntity that = (CouponEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
