package com.shopin.commonlibrary.entity;

/**
 * 滚轮选择器条目实体基类
 * Created by Administrator on 2017/5/20.
 */
public class BaseWrapWheelString {

    public BaseWrapWheelString(String wheelName) {
        this.wheelName = wheelName;
    }

    //滚轮显示的名称
    private String wheelName;

    public String getWheelName() {
        return wheelName;
    }

    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }
}
