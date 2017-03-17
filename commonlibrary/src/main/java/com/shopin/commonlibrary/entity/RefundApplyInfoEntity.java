package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundApplyInfoEntity.java
 * @brief 退货申请自己的封装类
 * @date 2017/2/24
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class RefundApplyInfoEntity {

    private RefundDetailEntity entity;
    //订单编号
    private String orderCode;
    //退换货号
    private String refundNo;
    private int service;
    private UploadIdEntity refundReason;
    //退换货的数量
    private int refundAmount;
    //退货数量
    private int qty;
    //退货数量最大值
    private double amountLimit;
    //退货说明
    private String comment;
    //图片地址
    private List<String> imgUrls;
    //订单状态，是否是未发货
    private boolean isUndeliver;
    //更新标记位
    private boolean updateFlag;
    //联系人
    private String contact;
    //联系方式
    private String contactWay;
    //阿里账号
    private String aliAccount;


    public RefundDetailEntity getEntity() {
        return entity;
    }

    public void setEntity(RefundDetailEntity entity) {
        this.entity = entity;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public UploadIdEntity getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(UploadIdEntity refundReason) {
        this.refundReason = refundReason;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(double amountLimit) {
        this.amountLimit = amountLimit;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public boolean isUndeliver() {
        return isUndeliver;
    }

    public void setUndeliver(boolean undeliver) {
        isUndeliver = undeliver;
    }

    public boolean isUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(boolean updateFlag) {
        this.updateFlag = updateFlag;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public void setAliAccount(String aliAccount) {
        this.aliAccount = aliAccount;
    }

    public String getAliAccount() {
        return aliAccount;
    }
}
