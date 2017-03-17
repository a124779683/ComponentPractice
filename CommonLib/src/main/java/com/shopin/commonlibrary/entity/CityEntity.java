package com.shopin.commonlibrary.entity;

import android.text.TextUtils;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CityEntity.java
 * @brief
 * @date 2017/2/20
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class CityEntity {

    /**
     * city : 东城区
     * sid : 1000
     */
    private String city;
    private String sid;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CityEntity) {
            return TextUtils.equals(this.getCity(), ((CityEntity) o).getCity());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }

    @Override
    public String toString() {
        return city;
    }

}
