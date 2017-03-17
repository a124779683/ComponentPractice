package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file OwnerEntity.java
 * @brief
 * @date 2017/3/8
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class OwnerEntity {

    /**
     * deliveringCount : 1
     * waitPickCount : 0
     * waitPayCount : 0
     */

    //配送中
    private int deliveringCount;
    //待提货
    private int waitPickCount;
    private int waitPayCount;

    public int getDeliveringCount() {
        return deliveringCount;
    }

    public void setDeliveringCount(int deliveringCount) {
        this.deliveringCount = deliveringCount;
    }

    public int getWaitPickCount() {
        return waitPickCount;
    }

    public void setWaitPickCount(int waitPickCount) {
        this.waitPickCount = waitPickCount;
    }

    public int getWaitPayCount() {
        return waitPayCount;
    }

    public void setWaitPayCount(int waitPayCount) {
        this.waitPayCount = waitPayCount;
    }
}
