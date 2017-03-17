package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file WrapCartInfoEntity.java
 * @brief
 * @date 2017/2/22
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class WrapCartInfoEntity {

    private boolean selectAll;

    private String price;
    private int qty;

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
