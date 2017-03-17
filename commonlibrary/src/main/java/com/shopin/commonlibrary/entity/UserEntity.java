package com.shopin.commonlibrary.entity;

/**
 * @author Administrator
 * @version 1.0
 * @file UserEntity.java
 * @brief 用户实体类
 * @date 2017/1/8
 * Copyright (c) 2017
 * All rights reserved.
 */
public class UserEntity implements Cloneable {

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

    //用户头像，暂时没有
    public String userPic; // //暂时没有返回

    //用户会员等级 1:v1会员，2：v2会员，3：v3会员
    public String mType;
    //用户积分
    public long nowPoint;

    public String memberSid;//用户id

    public String answer;
    public String nickName;
    public String question;
    public String realName;
    public String registFrom;
    public String registTime;
    public String sid;
    public String idCard;
    public String profession;
    public String memberAddress;
    public String completeDate;
    public String income;
    public String birthdate;
    public String gender;
    public String optUid;
    public String ipAddress;
    public String mobile;




    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }


    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public long getNowPoint() {
        return nowPoint;
    }

    public void setNowPoint(long nowPoint) {
        this.nowPoint = nowPoint;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRegistFrom() {
        return registFrom;
    }

    public void setRegistFrom(String registFrom) {
        this.registFrom = registFrom;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOptUid() {
        return optUid;
    }

    public void setOptUid(String optUid) {
        this.optUid = optUid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
