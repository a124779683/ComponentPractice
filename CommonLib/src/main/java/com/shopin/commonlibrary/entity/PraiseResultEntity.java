package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/21.
 */
public class PraiseResultEntity {

    public boolean success;
    public String desc;
    public  PraiseBody body;

    public class PraiseBody{
        public PraiseEntity entity;
    }

}
