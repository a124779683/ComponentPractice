package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/21.
 */
public class PublishTalentEntity {

    /**
     * body : {"entity":{"account":"15737980909","content":"天气真好","isRecommend":"0","memberSid":"1112","nickName":"king","picture":"111","sid":4,"status":1}}
     * success : true
     */

    private BodyBean body;
    private boolean success;
    public String desc;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class BodyBean {
        /**
         * entity : {"account":"15737980909","content":"天气真好","isRecommend":"0","memberSid":"1112","nickName":"king","picture":"111","sid":4,"status":1}
         */

        private EntityBean entity;

        public EntityBean getEntity() {
            return entity;
        }

        public void setEntity(EntityBean entity) {
            this.entity = entity;
        }

        public static class EntityBean {
            /**
             * account : 15737980909
             * content : 天气真好
             * isRecommend : 0
             * memberSid : 1112
             * nickName : king
             * picture : 111
             * sid : 4
             * status : 1
             */

            private String account;
            private String content;
            private String isRecommend;
            private String memberSid;
            private String nickName;
            private String picture;
            private int sid;
            private int status;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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
        }
    }
}
