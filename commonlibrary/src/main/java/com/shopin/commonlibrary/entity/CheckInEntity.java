package com.shopin.commonlibrary.entity;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CheckInEntity.java
 * @brief 签到的实体，主键通过 memberSid 与 签到时间共同生成一个唯一值做为主键
 * @date 2017/12/19
 * Copyright (c) 2017
 * All rights reserved.
 */
//@Entity(
//        // Whether getters and setters for properties should be generated if missing.
//        generateGettersSetters = true)
public class CheckInEntity {

    //主键
//    @NotNull
//    @Unique
//    @Id
    private String onlyPK;
//    @NotNull
    private String memberSid;
//    @NotNull
    private String occurDate;
//    @NotNull
    private String year;
//    @NotNull
    private String month;
//    @NotNull
    private String day;

    private String ReservedField1;
    private String ReservedField2;

//    @Generated(hash = 2007881948)
//    public CheckInEntity(@NotNull String onlyPK, @NotNull String memberSid, @NotNull String occurDate,
//            @NotNull String year, @NotNull String month, @NotNull String day, String ReservedField1,
//            String ReservedField2) {
//        this.onlyPK = onlyPK;
//        this.memberSid = memberSid;
//        this.occurDate = occurDate;
//        this.year = year;
//        this.month = month;
//        this.day = day;
//        this.ReservedField1 = ReservedField1;
//        this.ReservedField2 = ReservedField2;
//    }
//
//    @Generated(hash = 1775985584)
//    public CheckInEntity() {
//    }
//
//    public String getOnlyPK() {
//        return this.onlyPK;
//    }
//
//    public void setOnlyPK(String onlyPK) {
//        this.onlyPK = onlyPK;
//    }
//
//    public String getMemberSid() {
//        return this.memberSid;
//    }
//
//    public void setMemberSid(String memberSid) {
//        this.memberSid = memberSid;
//    }
//
//    public String getOccurDate() {
//        return this.occurDate;
//    }
//
//    public void setOccurDate(String occurDate) {
//        this.occurDate = occurDate;
//    }
//
//    public String getReservedField1() {
//        return this.ReservedField1;
//    }
//
//    public void setReservedField1(String ReservedField1) {
//        this.ReservedField1 = ReservedField1;
//    }
//
//    public String getReservedField2() {
//        return this.ReservedField2;
//    }
//
//    public void setReservedField2(String ReservedField2) {
//        this.ReservedField2 = ReservedField2;
//    }
//
//    public String createPK(String memberSid, String occurDate) {
//        return EncryptUtil.MD5Encode(StringUtils.concat(memberSid, occurDate));
//    }
//
//    public String getYear() {
//        return this.year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public String getMonth() {
//        return this.month;
//    }
//
//    public void setMonth(String month) {
//        this.month = month;
//    }
//
//    public String getDay() {
//        return this.day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CheckInEntity that = (CheckInEntity) o;
//
//        if (!year.equals(that.year)) return false;
//        if (!month.equals(that.month)) return false;
//        return day.equals(that.day);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = year.hashCode();
//        result = 31 * result + month.hashCode();
//        result = 31 * result + day.hashCode();
//        return result;
//    }
}
