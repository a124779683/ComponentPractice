package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.io.Serializable;

/**
 * @author Administrator
 * @version 1.0
 * @file DeliveryAddressEntity.java
 * @brief
 * @date 2017/1/18
 * Copyright (c) 2017,上品折扣
 * All rights reserved.
 */
@Parcelable
public class DeliveryAddressEntity implements Serializable, Comparable<DeliveryAddressEntity> {
    //! 是否编辑状态
    public boolean isEdit;
    //! 默认标记，是否为默认收货地址,"0"是默认地址
    public String defaultFlag = "1";
    public String area;
    public String provinceSid;
    public String address;
    public String city;
    public String countySid;

    public String mobile;
    public String county;
    public String telephone;
    public String delFlag;
    public String sid;
    public String citySid;
    public String memberSid;
    public String province;
    public String realcircleAddress;
    public String recipientName;
    public String realcircleSid;
    public String mailCode;
    public String status;


    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvinceSid() {
        return provinceSid;
    }

    public void setProvinceSid(String provinceSid) {
        this.provinceSid = provinceSid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountySid() {
        return countySid;
    }

    public void setCountySid(String countySid) {
        this.countySid = countySid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCitySid() {
        return citySid;
    }

    public void setCitySid(String citySid) {
        this.citySid = citySid;
    }

    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRealcircleAddress() {
        return realcircleAddress;
    }

    public void setRealcircleAddress(String realcircleAddress) {
        this.realcircleAddress = realcircleAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRealcircleSid() {
        return realcircleSid;
    }

    public void setRealcircleSid(String realcircleSid) {
        this.realcircleSid = realcircleSid;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DeliveryAddressEntity)
            return this.sid.equals(((DeliveryAddressEntity) o).sid);
        else
            return false;
    }

    @Override
    public int compareTo(DeliveryAddressEntity another) {
        return this.defaultFlag.compareTo(another.defaultFlag);
    }
}
