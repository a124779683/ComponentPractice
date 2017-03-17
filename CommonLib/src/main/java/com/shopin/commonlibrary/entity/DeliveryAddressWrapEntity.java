package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @file DeliveryAddressWrapEntity.java
 * @brief 收货地址结果包装类
 * @date 2017/6/25
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class DeliveryAddressWrapEntity {

    private int totalCount;
    private List<DeliveryAddressEntity> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DeliveryAddressEntity> getList() {
        return list;
    }

    public void setList(List<DeliveryAddressEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DeliveryAddressWrapEntity{" +
                "totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
