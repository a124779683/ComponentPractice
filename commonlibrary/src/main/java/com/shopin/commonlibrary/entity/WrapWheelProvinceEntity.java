package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file WrapWheelProvinceEntity.java
 * @brief
 * @date 2017/2/21
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class WrapWheelProvinceEntity extends BaseWrapWheelString {
    public WrapWheelProvinceEntity(String wheelName) {
        super(wheelName);
    }

    private ProvinceEntity province;

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    private CityEntity entity;

    public CityEntity getCityEntity() {
        return entity;
    }

    public void setCityEntity(CityEntity entity) {
        this.entity = entity;
    }
}
