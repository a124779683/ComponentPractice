package com.shopin.commonlibrary.entity;

/**
 * @author Administrator
 * @version 1.0
 * @file LabelEntity.java
 * @brief 标签实体
 * @date 2017/6/24
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class LabelEntity implements Cloneable {
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private int id;
    private String labelName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
