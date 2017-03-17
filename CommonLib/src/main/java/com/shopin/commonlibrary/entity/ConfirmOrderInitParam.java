package com.shopin.commonlibrary.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 下单接口
 * @author sailfish
 * @create 2017-02-24-下午2:22
 */
public class ConfirmOrderInitParam implements Cloneable{
    //第一次必填参数start--
    private Long addressId;
    private Integer expressType;//1 快递 0 自取
    private Long memberSid;
    private String shopSid;//如果是自提的话好区分，如果是快递的话默认传递空
    //---end---
    //券信息
    private Double ticketSnMoney;//券金额
    private String ticketSn; //券码
    private Long couponSid;//券id
    //积分抵现活动信息
    private Double pointMoney;//积分抵现需要的现金
    private Long pointArrival;//积分抵现需要的积分
    private Integer sendCost; //邮费
    private String cashierNo;//导购号
    //请求信息
    private Integer firstRequest;//是否是第一次请求,1：第一次，0：不是第一次
    private List<ConfirmOrderProductParam> products;
    //所有金额
    private Double totalMoney;
    private String disountMoney;

    public Long getCouponSid() {
        return couponSid;
    }

    public void setCouponSid(Long couponSid) {
        this.couponSid = couponSid;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public String getCashierNo() {
        return cashierNo;
    }

    public void setCashierNo(String cashierNo) {
        this.cashierNo = cashierNo;
    }

    public Long getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(Long memberSid) {
        this.memberSid = memberSid;
    }

    public Double getTicketSnMoney() {
        return ticketSnMoney;
    }

    public void setTicketSnMoney(Double ticketSnMoney) {
        this.ticketSnMoney = ticketSnMoney;
    }

    public String getTicketSn() {
        return ticketSn;
    }

    public void setTicketSn(String ticketSn) {
        this.ticketSn = ticketSn;
    }

    public Double getPointMoney() {
        return pointMoney;
    }

    public void setPointMoney(Double pointMoney) {
        this.pointMoney = pointMoney;
    }

    public Long getPointArrival() {
        return pointArrival;
    }

    public void setPointArrival(Long pointArrival) {
        this.pointArrival = pointArrival;
    }

    public Integer getFirstRequest() {
        return firstRequest;
    }

    public void setFirstRequest(Integer firstRequest) {
        this.firstRequest = firstRequest;
    }

    public List<ConfirmOrderProductParam> getProducts() {
        return products;
    }

    public void setProducts(List<ConfirmOrderProductParam> products) {
        this.products = products;
    }

    public Integer getSendCost() {
        return sendCost;
    }

    public void setSendCost(Integer sendCost) {
        this.sendCost = sendCost;
    }

    public String getShopSid() {
        return shopSid;
    }

    public void setShopSid(String shopSid) {
        this.shopSid = shopSid;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setDisountMoney(String disountMoney) {
        this.disountMoney = disountMoney;
    }

    public String getDisountMoney() {
        return disountMoney;
    }



    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
            if (products != null) {
                ArrayList<ConfirmOrderProductParam> arrayList = new ArrayList();
                for (ConfirmOrderProductParam labelEntity : products) {
                    ConfirmOrderProductParam clone = (ConfirmOrderProductParam) labelEntity.clone();
                    arrayList.add(clone);
                }
                ((ConfirmOrderInitParam) obj).setProducts(arrayList);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
