package com.shopin.commonlibrary.entity;

import android.text.TextUtils;

import com.baoyz.pg.Parcelable;
import com.shopin.commonlibrary.utils.Constants;

/**
 * @author jianghongbo
 * @version 1.0
 * @file RefundDetailEntity.java
 * @brief 退货详情
 * @date 2017/2/24
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class RefundDetailEntity {
    //订单状态是否在收货后
    private boolean afterReceive;
    //sendType
    private String sendType;
    // (实体门店销售) 2
    private String sourceSid;
    //payType 支付类型
    private String payType;
    //退货数量限制
    private int refundLimit;
    //退货单号
    private String refundNo;

    //退款单号
    private String refundNum;
    //退款金额
    private String refundPrice;
    //申请时间
    private String applyTime;
    //审核结果
    private String justiceResult;
    //当前状态
    private String status;
    //备注
    private String remark;
    /**
     * balanceMoney : 0
     * brandName : 樱歌玛
     * brandSid : D851
     * cashierNumber : 4100450423947
     * categoryName : 大衣
     * categorySid : 720410
     * confirmStatus : 1
     * confirmTime : 2017-02-28 05:28:55
     * detailNo : RA20170228362043-1
     * extractFlag : 1
     * imagePath :
     * orderDetailNo : 20170227361960-1
     * pointMultiple : 1
     * posPaymentMode : 0703
     * posPaymentMoney : 508.00
     * proColor : 红色
     * proDetailSid : 2932627003
     * proImagePath : http://images.shopin.net/images/1004/2014/12/16/Pic12091921_2932627_0.resize_to.400x400.jpg
     * proSid : 12091921
     * proSize : XL(170/92A)
     * proSku : D8856
     * productName : 樱歌玛女款个性毛呢大衣
     * refundPrice : 508
     * refundReasonDesc : 取消订单
     * refundReasonSid : 7
     * refundSid : 51362043
     * refundSum : 1
     * saleSum : 1
     * sapSaleLineNo : 000001
     * sellprice : 508
     * shopSid : 1004
     * sid : 50423947
     * stockTypeSid : 1001
     * supplyInfoSid : 102692
     */

    private int balanceMoney;
    private String brandName;
    private String brandSid;
    private String cashierNumber;
    private String categoryName;
    private String categorySid;
    private int confirmStatus;
    private String confirmTime;
    private String detailNo;
    private int extractFlag;
    private String imagePath;
    private String orderDetailNo;
    private int pointMultiple;
    private String posPaymentMode;
    private String posPaymentMoney;
    private String proColor;
    private long proDetailSid;
    private String proImagePath;
    private int proSid;
    private String proSize;
    private String proSku;
    private String productName;
    private String refundReasonDesc;
    private int refundReasonSid;
    private int refundSid;
    private int refundSum;
    private int saleSum;
    private String sapSaleLineNo;
    private int sellprice;
    private int shopSid;
    private int sid;
    private int stockTypeSid;
    private int supplyInfoSid;

    public int getRefundLimit() {
        return refundLimit;
    }

    public void setRefundLimit(int refundLimit) {
        this.refundLimit = refundLimit;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getJusticeResult() {
        return justiceResult;
    }

    public void setJusticeResult(String justiceResult) {
        this.justiceResult = justiceResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getSourceSid() {
        return sourceSid;
    }

    public void setSourceSid(String sourceSid) {
        this.sourceSid = sourceSid;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 是否显示支付宝信息,要满足自提并且是实体，
     * <p>
     * 并且支付方式为28,49,50的订单在退货时候也不显示退款去向。
     * @return
     */
    public boolean isShowAliPay() {
        if (!TextUtils.isEmpty(payType) && !TextUtils.isEmpty(sendType) && !TextUtils.isEmpty(sourceSid)) {

            if (TextUtils.equals(payType, "28") ||
                    TextUtils.equals(payType, "49") ||
                    TextUtils.equals(payType, "50")) {
                return false;
            }

            if (TextUtils.equals(sendType, Constants.EXPRESS_TYPE_SELF_GET)
                    && TextUtils.equals(sourceSid, "2")) {
                return true;
            }
        }
        return false;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public boolean isAfterReceive() {
        return afterReceive;
    }

    public void setAfterReceive(boolean afterReceive) {
        this.afterReceive = afterReceive;
    }

    //服务器返回的数据

    public int getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(int balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSid() {
        return brandSid;
    }

    public void setBrandSid(String brandSid) {
        this.brandSid = brandSid;
    }

    public String getCashierNumber() {
        return cashierNumber;
    }

    public void setCashierNumber(String cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySid() {
        return categorySid;
    }

    public void setCategorySid(String categorySid) {
        this.categorySid = categorySid;
    }

    public int getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(int confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    public int getExtractFlag() {
        return extractFlag;
    }

    public void setExtractFlag(int extractFlag) {
        this.extractFlag = extractFlag;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOrderDetailNo() {
        return orderDetailNo;
    }

    public void setOrderDetailNo(String orderDetailNo) {
        this.orderDetailNo = orderDetailNo;
    }

    public int getPointMultiple() {
        return pointMultiple;
    }

    public void setPointMultiple(int pointMultiple) {
        this.pointMultiple = pointMultiple;
    }

    public String getPosPaymentMode() {
        return posPaymentMode;
    }

    public void setPosPaymentMode(String posPaymentMode) {
        this.posPaymentMode = posPaymentMode;
    }

    public String getPosPaymentMoney() {
        return posPaymentMoney;
    }

    public void setPosPaymentMoney(String posPaymentMoney) {
        this.posPaymentMoney = posPaymentMoney;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public long getProDetailSid() {
        return proDetailSid;
    }

    public void setProDetailSid(long proDetailSid) {
        this.proDetailSid = proDetailSid;
    }

    public String getProImagePath() {
        return proImagePath;
    }

    public void setProImagePath(String proImagePath) {
        this.proImagePath = proImagePath;
    }

    public int getProSid() {
        return proSid;
    }

    public void setProSid(int proSid) {
        this.proSid = proSid;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getProSku() {
        return proSku;
    }

    public void setProSku(String proSku) {
        this.proSku = proSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRefundReasonDesc() {
        return refundReasonDesc;
    }

    public void setRefundReasonDesc(String refundReasonDesc) {
        this.refundReasonDesc = refundReasonDesc;
    }

    public int getRefundReasonSid() {
        return refundReasonSid;
    }

    public void setRefundReasonSid(int refundReasonSid) {
        this.refundReasonSid = refundReasonSid;
    }

    public int getRefundSid() {
        return refundSid;
    }

    public void setRefundSid(int refundSid) {
        this.refundSid = refundSid;
    }

    public int getRefundSum() {
        return refundSum;
    }

    public void setRefundSum(int refundSum) {
        this.refundSum = refundSum;
    }

    public int getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(int saleSum) {
        this.saleSum = saleSum;
    }

    public String getSapSaleLineNo() {
        return sapSaleLineNo;
    }

    public void setSapSaleLineNo(String sapSaleLineNo) {
        this.sapSaleLineNo = sapSaleLineNo;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getShopSid() {
        return shopSid;
    }

    public void setShopSid(int shopSid) {
        this.shopSid = shopSid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getStockTypeSid() {
        return stockTypeSid;
    }

    public void setStockTypeSid(int stockTypeSid) {
        this.stockTypeSid = stockTypeSid;
    }

    public int getSupplyInfoSid() {
        return supplyInfoSid;
    }

    public void setSupplyInfoSid(int supplyInfoSid) {
        this.supplyInfoSid = supplyInfoSid;
    }
}
