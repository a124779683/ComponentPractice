package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/21.
 */
public class CommentResultEntity {


    /**
     * body : {"entity":{"commentSid":"0","content":"11111","createTime":"2017-02-21 17:32:19","invitationSid":"15","memberSid":"1002","sid":14,"status":1}}
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
         * entity : {"commentSid":"0","content":"11111","createTime":"2017-02-21 17:32:19","invitationSid":"15","memberSid":"1002","sid":14,"status":1}
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
             * commentSid : 0
             * content : 11111
             * createTime : 2017-02-21 17:32:19
             * invitationSid : 15
             * memberSid : 1002
             * sid : 14
             * status : 1
             */

            private String commentSid;
            private String content;
            private String createTime;
            private String invitationSid;
            private String memberSid;
            private int sid;
            private int status;

            public String getCommentSid() {
                return commentSid;
            }

            public void setCommentSid(String commentSid) {
                this.commentSid = commentSid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getInvitationSid() {
                return invitationSid;
            }

            public void setInvitationSid(String invitationSid) {
                this.invitationSid = invitationSid;
            }

            public String getMemberSid() {
                return memberSid;
            }

            public void setMemberSid(String memberSid) {
                this.memberSid = memberSid;
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
