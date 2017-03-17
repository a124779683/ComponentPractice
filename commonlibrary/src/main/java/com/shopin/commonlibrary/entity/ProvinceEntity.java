package com.shopin.commonlibrary.entity;

import android.text.TextUtils;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ProvinceEntity.java
 * @brief
 * @date 2017/2/20
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class ProvinceEntity {

    private String province;
    private String sid;
    private List<CityEntity> cityList;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public List<CityEntity> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityEntity> cityList) {
        this.cityList = cityList;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProvinceEntity) {
            return TextUtils.equals(this.getProvince(), ((ProvinceEntity) o).getProvince());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return province.hashCode();
    }

    @Override
    public String toString() {
        return province;
    }
}
