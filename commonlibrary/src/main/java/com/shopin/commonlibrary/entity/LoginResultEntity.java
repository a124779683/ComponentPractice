package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/15.
 */
public class LoginResultEntity {

    public String sid;//用户id

    public String mType;

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNowPoint(String nowPoint) {
        this.nowPoint = nowPoint;
    }

    public String userPic;

    public String getSid() {
        return sid;
    }

    public String getmType() {
        return mType;
    }

    public String getUserPic() {
        return userPic;
    }

    public String getAccount() {
        return account;
    }

    public String getNowPoint() {
        return nowPoint;
    }

    public String account;

    public String nowPoint;


}
