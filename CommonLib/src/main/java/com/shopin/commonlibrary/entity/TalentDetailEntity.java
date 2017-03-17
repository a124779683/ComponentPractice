package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/22.
 */
public class TalentDetailEntity {
    public boolean success;
    public String desc;

    public DetailBody body;

    public class DetailBody{
        public TalentListData entity;
    }
}
