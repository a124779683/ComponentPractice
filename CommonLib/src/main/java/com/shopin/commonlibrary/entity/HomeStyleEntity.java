package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author jianghongbo
 * @version 1.0
 * @file HomeStyleEntity.java
 * @brief 首页样式实体
 * @date 2017/2/11
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class HomeStyleEntity {

    public HomeStyleEntity() {
    }

    public HomeStyleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
