package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file WrapAddressEntity.java
 * @brief
 * @date 2017/2/20
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class WrapAddressEntity {



    private List<ProvinceEntity> provinceList;

    public List<ProvinceEntity> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceEntity> provinceList) {
        this.provinceList = provinceList;
    }
}
