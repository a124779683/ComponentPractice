package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundServerInfoEntity.java
 * @brief
 * @date 2017/3/4
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class RefundServerInfoEntity {

    /**
     * cancelReasonDesc : 没有选择开发票
     * cancelReasonSid : 4
     * cancelTime : 2017-02-28 05:28:54
     * customerMemo : 无法合并
     * refundName : 伍女士
     * refundNo : RA20170228362043
     * refundPhone : 18142515787
     * refundSid : 51362043
     * serviceMemo :
     * sid : 87422
     */

    private String cancelReasonDesc;
    private int cancelReasonSid;
    private String cancelTime;
    private String customerMemo;
    private String refundName;
    private String refundNo;
    private String refundPhone;
    private int refundSid;
    private String serviceMemo;
    private int sid;

    public String getCancelReasonDesc() {
        return cancelReasonDesc;
    }

    public void setCancelReasonDesc(String cancelReasonDesc) {
        this.cancelReasonDesc = cancelReasonDesc;
    }

    public int getCancelReasonSid() {
        return cancelReasonSid;
    }

    public void setCancelReasonSid(int cancelReasonSid) {
        this.cancelReasonSid = cancelReasonSid;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCustomerMemo() {
        return customerMemo;
    }

    public void setCustomerMemo(String customerMemo) {
        this.customerMemo = customerMemo;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getRefundPhone() {
        return refundPhone;
    }

    public void setRefundPhone(String refundPhone) {
        this.refundPhone = refundPhone;
    }

    public int getRefundSid() {
        return refundSid;
    }

    public void setRefundSid(int refundSid) {
        this.refundSid = refundSid;
    }

    public String getServiceMemo() {
        return serviceMemo;
    }

    public void setServiceMemo(String serviceMemo) {
        this.serviceMemo = serviceMemo;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
