package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundInfoEntity.java
 * @brief
 * @date 2017/3/14
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class RefundInfoEntity {

    private String logisticsStatus;
    private RefundResponseEntity refundOrder;

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public RefundResponseEntity getRefundOrder() {
        return refundOrder;
    }

    public void setRefundOrder(RefundResponseEntity refundOrder) {
        this.refundOrder = refundOrder;
    }
}
