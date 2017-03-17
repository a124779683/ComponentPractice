package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 张志强
 * @date 2017/6/28.
 * 邮箱：zhangzhiqiang@zjsj1492.com
 * Copyright (c) 2017 上品折扣[]
 */
@Parcelable
public class NoteReplyList {


/*    "cancelTime": "2017-02-18 11:44:21.0",
            "commentName": "yy",
            "commentSid": "1",
            "content": "什么不错啊",
            "createTime": "2017-02-13 15:08:44.0",
            "invitationSid": "1",
            "memberSid": "333",
            "nickName": "",
            "opt": "zhangsan",
            "sid": 2,
            "status": 1*/


    public String commentSid;     //被评论的id 
    public String commentName;   //被评论人的昵称

    public String nickName;  //评论人的昵称
    public String memberSid;//评论人的id

    public String createTime;  //回复时间   格式yyyy-MM-dd hh:mm:ss

    public String cancelTime;//取消的时间

    public String content; //回复内容

    public String invitationSid;  //帖子的id

    public String opt;     //

    public String sid; //

    public int status;//评论的状态（0已删除 1已评论
}
