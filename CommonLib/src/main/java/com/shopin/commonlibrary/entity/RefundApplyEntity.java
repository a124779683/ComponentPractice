package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundApplyEntity.java
 * @brief 退换货申请的实体
 * @date 2017/3/4
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class RefundApplyEntity {

    /**
     "detailNo" : "20170223322402-1",//订单明细号！！！
     "orderNo" : "20170223322402",//订单号！！！
     "refundNum" : "1",//退货数量  （要最大退货数量）！！
     "sendType" : "0",//快递方式：0-自提；1-快递  ！！！！！
     "memberSid" : "16752939",//会员sid
     "refundPrice" : "108.00",//单件退货价格  ！！！！

     "refundName" : "宣云云",//联系人信息
     "refundPhone" : "18810337595",//联系人电话
     "refundReasonSid" : "6",//退货原因sid
     "refundReasonDesc" : "商品不适合",   （用户选择的退货原因）
     "customerMemo" : "不合适",//退货说明

     //上面所有参数必填。
     “imagePath”:多个以逗号分隔


     "deliveryNO" : "1111111",//快递单号
     "deliveryCompany" : "顺丰",//快递公司
     "refundFlag" : "1",//退款去向标记：1-支付宝；2-银行  ？？？还有微信
     "alipayNum" : "1357898344@qq.com",//1-支付宝账号 （如果填写退款去向，这个必填）
     "alipayName" : "宣云云",//1-支付姓名  （如果填写退款去向，这个必填）




     "bankNumber":"",//2-银行账号   ！！！
     "bankName":"",//2-银行名称  ！！！！
     "bankAddress":"",//2-银行开户行地址  ！！！
     "bankUser":""//银行持卡人姓名  ！！！！！
     */

    private String detailNo;
    private String orderNo;
    private String refundNum;
    private String refundPrice;
    private String sendType;
    private String memberSid;
    private String refundName;
    private String refundPhone;
    private String refundReasonSid;
    private String refundReasonDesc;
    private String customerMemo;
    private String deliveryNO;
    private String deliveryCompany;
    private String refundFlag;
    private String alipayNum;
    private String alipayName;
    private String bankNumber;
    private String bankName;
    private String bankAddress;
    private String bankUser;
    private String imagePath;

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public String getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(String refundPrice) {
        this.refundPrice = refundPrice;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public String getRefundPhone() {
        return refundPhone;
    }

    public void setRefundPhone(String refundPhone) {
        this.refundPhone = refundPhone;
    }

    public String getRefundReasonSid() {
        return refundReasonSid;
    }

    public void setRefundReasonSid(String refundReasonSid) {
        this.refundReasonSid = refundReasonSid;
    }

    public String getRefundReasonDesc() {
        return refundReasonDesc;
    }

    public void setRefundReasonDesc(String refundReasonDesc) {
        this.refundReasonDesc = refundReasonDesc;
    }

    public String getCustomerMemo() {
        return customerMemo;
    }

    public void setCustomerMemo(String customerMemo) {
        this.customerMemo = customerMemo;
    }

    public String getDeliveryNO() {
        return deliveryNO;
    }

    public void setDeliveryNO(String deliveryNO) {
        this.deliveryNO = deliveryNO;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag;
    }

    public String getAlipayNum() {
        return alipayNum;
    }

    public void setAlipayNum(String alipayNum) {
        this.alipayNum = alipayNum;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
