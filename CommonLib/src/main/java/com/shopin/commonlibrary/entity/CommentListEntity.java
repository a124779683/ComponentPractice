package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * Created by zq on 2017/2/21.
 */
public class CommentListEntity {

    /**
     * body : {"page":{"limit":10,"list":[{"commentSid":"0","content":"11111","createTime":"2017-02-21 17:32:19.0","invitationSid":"15","memberSid":"1002","nickName":"评论的：","sid":14,"status":1},{"commentSid":"0","content":"11111","createTime":"2017-02-21 14:46:09.0","invitationSid":"15","memberSid":"1001","nickName":"评论的：","sid":7,"status":1}],"params":{"start":1,"limit":10},"start":1,"total":2}}
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
         * page : {"limit":10,"list":[{"commentSid":"0","content":"11111","createTime":"2017-02-21 17:32:19.0","invitationSid":"15","memberSid":"1002","nickName":"评论的：","sid":14,"status":1},{"commentSid":"0","content":"11111","createTime":"2017-02-21 14:46:09.0","invitationSid":"15","memberSid":"1001","nickName":"评论的：","sid":7,"status":1}],"params":{"start":1,"limit":10},"start":1,"total":2}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean {
            /**
             * limit : 10
             * list : [{"commentSid":"0","content":"11111","createTime":"2017-02-21 17:32:19.0","invitationSid":"15","memberSid":"1002","nickName":"评论的：","sid":14,"status":1},{"commentSid":"0","content":"11111","createTime":"2017-02-21 14:46:09.0","invitationSid":"15","memberSid":"1001","nickName":"评论的：","sid":7,"status":1}]
             * params : {"start":1,"limit":10}
             * start : 1
             * total : 2
             */

            private int limit;
            private ParamsBean params;
            private int start;
            private int total;
            private List<NoteReplyList> list;

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<NoteReplyList> getList() {
                return list;
            }

            public void setList(List<NoteReplyList> list) {
                this.list = list;
            }

            public static class ParamsBean {
                /**
                 * start : 1
                 * limit : 10
                 */

                private int start;
                private int limit;

                public int getStart() {
                    return start;
                }

                public void setStart(int start) {
                    this.start = start;
                }

                public int getLimit() {
                    return limit;
                }

                public void setLimit(int limit) {
                    this.limit = limit;
                }
            }

        }
    }
}
