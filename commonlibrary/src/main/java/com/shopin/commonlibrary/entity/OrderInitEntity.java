package com.shopin.commonlibrary.entity;

import java.util.List;
import java.util.Map;

/**
 * @author jianghongbo
 * @version 1.0
 * @file OrderInitEntity.java
 * @brief
 * @date 2017/2/28
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class OrderInitEntity {
    /**
     * activitys : []
     * coupons : [{"accountCode":"68577","endTime":"2017-06-01 00:00:00","maxOrderMoney":0,"minOrderMoney":10.01,"pageSize":15,"prefix":"AH1","sid":37454409,"sn":"AH114N2T0HM372087","start":0,"startTime":"2016-10-25 00:00:00","total":0,"type":1,"useStatus":1,"value":10},{"accountCode":"53940","endTime":"2017-04-26 23:59:59","maxOrderMoney":0,"minOrderMoney":200,"pageSize":15,"prefix":"4GW","sid":37797912,"sn":"4GW2K3AKJ3HP3Z5064","start":0,"startTime":"2017-04-13 00:00:00","total":0,"type":1,"useStatus":1,"value":20}]
     * discountMoney : 0
     * point : 151
     * pointActivity : {"totalReduceMoney":0,"totalReducePoint":0}
     * sendCost : 0
     */

    private String discountMoney;
    private int point;
    private DiscountEntity pointActivity;
    private String sendCost;
    private Map<String, List<OrderActivityEntity>> activitys;
    private List<CouponEntity> coupons;
    private double totalMoney;

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(String discountMoney) {
        this.discountMoney = discountMoney;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public DiscountEntity getPointActivity() {
        return pointActivity;
    }

    public void setPointActivity(DiscountEntity pointActivity) {
        this.pointActivity = pointActivity;
    }

    public String getSendCost() {
        return sendCost;
    }

    public void setSendCost(String sendCost) {
        this.sendCost = sendCost;
    }

    public Map<String, List<OrderActivityEntity>> getActivitys() {
        return activitys;
    }

    public void setActivitys(Map<String, List<OrderActivityEntity>> activitys) {
        this.activitys = activitys;
    }

    public List<CouponEntity> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponEntity> coupons) {
        this.coupons = coupons;
    }
}
