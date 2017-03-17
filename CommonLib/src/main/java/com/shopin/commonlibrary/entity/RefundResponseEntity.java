package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundResponseEntity.java
 * @brief 退换货详情返回的实体
 * @date 2017/3/4
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class RefundResponseEntity {


    private RefundEntity refund;

    private List<RefundDetailEntity> refundDetails;

    private RefundServerInfoEntity refundInfo;

    private String sendType;

    public RefundEntity getRefund() {
        return refund;
    }

    public void setRefund(RefundEntity refund) {
        this.refund = refund;
    }

    public List<RefundDetailEntity> getRefundDetails() {
        return refundDetails;
    }

    public void setRefundDetails(List<RefundDetailEntity> refundDetails) {
        this.refundDetails = refundDetails;
    }


    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public RefundServerInfoEntity getRefundInfo() {
        return refundInfo;
    }

    public void setRefundInfo(RefundServerInfoEntity refundInfo) {
        this.refundInfo = refundInfo;
    }
}
