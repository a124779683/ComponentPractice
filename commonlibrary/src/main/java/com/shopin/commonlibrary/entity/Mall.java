package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author jianghongbo
 * @version 1.0
 * @file Mall.java
 * @brief 门店信息
 * @date 2017/2/18
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class Mall {

    /**
     * city : 北京市
     * contactPerson :
     * country : CN
     * district : 010
     * houseNumber :
     * lastOptDate : 2013-09-13 16:09:04
     * lastOptUser : SAP_WCM
     * mailbox :
     * phone : 010-65288866
     * postcode : 100000
     * shopName : 王府井店
     * sid : 1001
     * street : 东城区王府井大街300号工美大厦5层
     */
    private String city;
    private String contactPerson;
    private String country;
    private String district;
    private String houseNumber;
    private String lastOptDate;
    private String lastOptUser;
    private String mailbox;
    private String phone;
    private String postcode;
    private String shopName;
    private String shopUrl;
    private int sid;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLastOptDate() {
        return lastOptDate;
    }

    public void setLastOptDate(String lastOptDate) {
        this.lastOptDate = lastOptDate;
    }

    public String getLastOptUser() {
        return lastOptUser;
    }

    public void setLastOptUser(String lastOptUser) {
        this.lastOptUser = lastOptUser;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }
}
