package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * Created by zq on 2017/3/1.
 */
public class SignBaseBody {

    public SignBody body;
    public String code;
    public String desc;
    public boolean success;


    public class SignBody {
        public SignDateEntity entity; //签到返回的数据的实体类
        public SignPage page;// 获取本月签单返回的数据的实体类
    }

    public class SignPage {
        public String limit;//暂时没用
        public List<SignDateEntity> list;
        public SignParams params;
    }

    public class SignParams {
        public String yearmonth;//当前的年月
    }

}
