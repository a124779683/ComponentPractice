package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * Created by zq on 2017/1/26.
 */
public class TalentListData {

    /**
     * account : 1112
     * commentCount : 0
     * commentList : []
     * createTime : 2017-02-20 19:45:10.0
     * isAttention : 0
     * isPraise : 0
     * isRecommend : 0
     * memberSid : 15737980909
     * nickName : 达人
     * picture : /bj_community/20170220/userfile.png
     * praiseCount : 0
     * sid : 15
     * status : 1
     * content : 123123123
     * delTime : 2017-02-18 11:01:37.0
     * opt : zhangsan
     */

    private String account;
    private int commentCount;
    private String createTime;
    private String isAttention;
    private String isPraise;
    private String isRecommend;
    private String memberSid;
    private String nickName;
    private String picture;
    private int praiseCount;
    private int sid;
    private int status;
    private String content;
    private String delTime;
    private String opt;
    private List<NoteReplyList> commentList;
    private boolean camera;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(String isAttention) {
        this.isAttention = isAttention;
    }

    public String getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(String isPraise) {
        this.isPraise = isPraise;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public List<NoteReplyList> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<NoteReplyList> commentList) {
        this.commentList = commentList;
    }


    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public boolean isCamera() {
        return camera;
    }
}
