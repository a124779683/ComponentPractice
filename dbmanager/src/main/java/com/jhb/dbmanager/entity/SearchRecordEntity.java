package com.jhb.dbmanager.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author jianghongbo
 * @version 1.0
 * @file SearchRecordEntity.java
 * @brief 搜索记录的实体
 * @date 2017/12/19
 * Copyright (c) 2017
 * All rights reserved.
 */
@Entity(
        // Whether getters and setters for properties should be generated if missing.
        generateGettersSetters = true)
public class SearchRecordEntity {

    //主键
    @NotNull
    @Unique
    @Id
    private String keyword;
    @NotNull
    private String occurDate;
    @Transient
    private String pinyin;
    @Transient
    private String pinyinHead;

    @Generated(hash = 850496359)
    public SearchRecordEntity(@NotNull String keyword, @NotNull String occurDate) {
        this.keyword = keyword;
        this.occurDate = occurDate;
    }

    @Generated(hash = 170449564)
    public SearchRecordEntity() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(String occurDate) {
        this.occurDate = occurDate;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinHead() {
        return pinyinHead;
    }

    public void setPinyinHead(String pinyinHead) {
        this.pinyinHead = pinyinHead;
    }
}
