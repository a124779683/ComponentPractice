package com.shopin.commonlibrary.entity;


public class UploadIdEntity extends BaseWrapWheelString {

    public UploadIdEntity(String wheelName) {
        super(wheelName);
    }
    public UploadIdEntity(String wheelName, int id) {
        super(wheelName);
        setId(id);
    }

    //对应的id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
