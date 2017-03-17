package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file AddressEntity.java
 * @brief
 * @date 2017/2/20
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class AddressEntity {


    /**
     * code : A00000
     * data : {"provinceList":[{"cityList":[{"city":"东城区","sid":"1000"},{"city":"西城区","sid":"1001"}],"province":"北京","sid":"10"}]}
     * errorMessage : 成功
     */

    private String code;
    private DataBean data;
    private String errorMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static class DataBean {
        private List<ProvinceEntity> provinceList;

        public List<ProvinceEntity> getProvinceList() {
            return provinceList;
        }

        public void setProvinceList(List<ProvinceEntity> provinceList) {
            this.provinceList = provinceList;
        }
    }
}
