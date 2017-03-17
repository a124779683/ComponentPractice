package com.shopin.commonlibrary.entity;

/**
 * Created by yiwei on 16/3/2.
 */
public class CommentConfig {
    public enum Type{
        PUBLIC("public"), REPLY("reply");

        private String value;
        Type(String value){
            this.value = value;
        }

    }

    public int circlePosition;
    public int commentPosition;
    public Type commentType;
    public NoteReplyList replyUser;

    @Override
    public String toString() {
        String replyUserStr = "";
        if(replyUser != null){
            replyUserStr = replyUser.toString();
        }
        return "circlePosition = " + circlePosition
                + "; commentPosition = " + commentPosition
                + "; commentType ＝ " + commentType
                + "; replyUser = " + replyUserStr;
    }
}
