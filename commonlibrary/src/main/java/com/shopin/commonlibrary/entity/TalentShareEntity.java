package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/24.
 */
public class TalentShareEntity {

    public ShareBody body;
    public String desc;
    public boolean success;

    public class ShareBody{
        public ShareEntity entity;
    }

    public class ShareEntity{
        public String rarPicture;//压缩图片的名称
        public String title;
        public String url;
    }
}
