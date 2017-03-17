package com.jhb.dbmanager.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CrashExceptionEntity.java
 * @brief 崩溃异常的实体
 * @date 2017/12/19
 * Copyright (c) 2017
 * All rights reserved.
 */
@Entity(
        // Whether getters and setters for properties should be generated if missing.
        generateGettersSetters = true)
public class CrashExceptionEntity {

    //主键
    @NotNull
    @Unique
    @Id
    private String md5Summary;
    @NotNull
    private String iphoneModel;
    @NotNull
    private String model;
    @NotNull
    private String errorMsg;
    private String occurDate;
    private Boolean uploadFlag;
    private String ReservedField1;
    private String ReservedField2;
    private String ReservedField3;


    @Generated(hash = 1266713787)
    public CrashExceptionEntity(@NotNull String md5Summary, @NotNull String iphoneModel,
                                @NotNull String model, @NotNull String errorMsg, String occurDate,
                                Boolean uploadFlag, String ReservedField1, String ReservedField2,
                                String ReservedField3) {
        this.md5Summary = md5Summary;
        this.iphoneModel = iphoneModel;
        this.model = model;
        this.errorMsg = errorMsg;
        this.occurDate = occurDate;
        this.uploadFlag = uploadFlag;
        this.ReservedField1 = ReservedField1;
        this.ReservedField2 = ReservedField2;
        this.ReservedField3 = ReservedField3;
    }

    @Generated(hash = 1937612897)
    public CrashExceptionEntity() {
    }


    public String getMd5Summary() {
        return md5Summary;
    }

    public void setMd5Summary(String md5Summary) {
        this.md5Summary = md5Summary;
    }

    public String getIphoneModel() {
        return iphoneModel;
    }

    public void setIphoneModel(String iphoneModel) {
        this.iphoneModel = iphoneModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(String occurDate) {
        this.occurDate = occurDate;
    }

    public Boolean getUploadFlag() {
        return uploadFlag;
    }

    public void setUploadFlag(Boolean uploadFlag) {
        this.uploadFlag = uploadFlag;
    }

    public String getReservedField1() {
        return ReservedField1;
    }

    public void setReservedField1(String reservedField1) {
        ReservedField1 = reservedField1;
    }

    public String getReservedField2() {
        return ReservedField2;
    }

    public void setReservedField2(String reservedField2) {
        ReservedField2 = reservedField2;
    }

    public String getReservedField3() {
        return ReservedField3;
    }

    public void setReservedField3(String reservedField3) {
        ReservedField3 = reservedField3;
    }
}
