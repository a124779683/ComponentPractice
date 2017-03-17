package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * Created by zq on 2017/1/16.
 */
public class TalentListEntity {


    /**
     * body : {"page":{"limit":10,"list":[{"account":"1112","commentCount":0,"commentList":[],"createTime":"2017-02-20 19:45:10.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/userfile.png","praiseCount":0,"sid":15,"status":1,"content":"123123123","delTime":"2017-02-18 11:01:37.0","opt":"zhangsan"},{"account":"1112","commentCount":0,"commentList":[],"content":"123123123","createTime":"2017-02-20 17:03:29.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/image","praiseCount":0,"sid":10,"status":1},{"account":"1111","commentCount":6,"commentList":[{"content":"32","createTime":"2017-02-20 18:18:49.0","invitationSid":"1","memberSid":"2323","nickName":"","sid":6,"status":1},{"content":"fsdf","createTime":"2017-02-20 18:17:55.0","invitationSid":"1","memberSid":"333","nickName":"22","sid":5,"status":1},{"content":"hahah","createTime":"2017-02-18 11:32:58.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":4,"status":1},{"cancelTime":"2017-02-18 11:01:37.0","content":"hahah","createTime":"2017-02-14 18:13:56.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":3,"status":1},{"cancelTime":"2017-02-18 11:44:21.0","commentName":"yy","commentSid":"1","content":"什么不错啊","createTime":"2017-02-13 15:08:44.0","invitationSid":"1","memberSid":"333","nickName":"","opt":"zhangsan","sid":2,"status":1}],"content":"真好看","createTime":"2017-02-09 19:04:36.0","delTime":"2017-02-18 11:01:37.0","isAttention":"0","isPraise":"1","isRecommend":"0","memberSid":"11111","nickName":"达人","opt":"zhangsan","picture":"/bj_community/20170216/1487214289175.jpg","praiseCount":2,"sid":1,"status":1}],"params":{"start":1,"limit":10},"start":1,"total":3}}
     * success : true
     */

    private BodyBean body;
    private boolean success;

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
         * page : {"limit":10,"list":[{"account":"1112","commentCount":0,"commentList":[],"createTime":"2017-02-20 19:45:10.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/userfile.png","praiseCount":0,"sid":15,"status":1,"content":"123123123","delTime":"2017-02-18 11:01:37.0","opt":"zhangsan"},{"account":"1112","commentCount":0,"commentList":[],"content":"123123123","createTime":"2017-02-20 17:03:29.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/image","praiseCount":0,"sid":10,"status":1},{"account":"1111","commentCount":6,"commentList":[{"content":"32","createTime":"2017-02-20 18:18:49.0","invitationSid":"1","memberSid":"2323","nickName":"","sid":6,"status":1},{"content":"fsdf","createTime":"2017-02-20 18:17:55.0","invitationSid":"1","memberSid":"333","nickName":"22","sid":5,"status":1},{"content":"hahah","createTime":"2017-02-18 11:32:58.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":4,"status":1},{"cancelTime":"2017-02-18 11:01:37.0","content":"hahah","createTime":"2017-02-14 18:13:56.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":3,"status":1},{"cancelTime":"2017-02-18 11:44:21.0","commentName":"yy","commentSid":"1","content":"什么不错啊","createTime":"2017-02-13 15:08:44.0","invitationSid":"1","memberSid":"333","nickName":"","opt":"zhangsan","sid":2,"status":1}],"content":"真好看","createTime":"2017-02-09 19:04:36.0","delTime":"2017-02-18 11:01:37.0","isAttention":"0","isPraise":"1","isRecommend":"0","memberSid":"11111","nickName":"达人","opt":"zhangsan","picture":"/bj_community/20170216/1487214289175.jpg","praiseCount":2,"sid":1,"status":1}],"params":{"start":1,"limit":10},"start":1,"total":3}
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
             * list : [{"account":"1112","commentCount":0,"commentList":[],"createTime":"2017-02-20 19:45:10.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/userfile.png","praiseCount":0,"sid":15,"status":1},{"account":"1112","commentCount":0,"commentList":[],"content":"123123123","createTime":"2017-02-20 17:03:29.0","isAttention":"0","isPraise":"0","isRecommend":"0","memberSid":"15737980909","nickName":"达人","picture":"/bj_community/20170220/image","praiseCount":0,"sid":10,"status":1},{"account":"1111","commentCount":6,"commentList":[{"content":"32","createTime":"2017-02-20 18:18:49.0","invitationSid":"1","memberSid":"2323","nickName":"","sid":6,"status":1},{"content":"fsdf","createTime":"2017-02-20 18:17:55.0","invitationSid":"1","memberSid":"333","nickName":"22","sid":5,"status":1},{"content":"hahah","createTime":"2017-02-18 11:32:58.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":4,"status":1},{"cancelTime":"2017-02-18 11:01:37.0","content":"hahah","createTime":"2017-02-14 18:13:56.0","invitationSid":"1","memberSid":"555","nickName":"ss","opt":"zhangsan","sid":3,"status":1},{"cancelTime":"2017-02-18 11:44:21.0","commentName":"yy","commentSid":"1","content":"什么不错啊","createTime":"2017-02-13 15:08:44.0","invitationSid":"1","memberSid":"333","nickName":"","opt":"zhangsan","sid":2,"status":1}],"content":"真好看","createTime":"2017-02-09 19:04:36.0","delTime":"2017-02-18 11:01:37.0","isAttention":"0","isPraise":"1","isRecommend":"0","memberSid":"11111","nickName":"达人","opt":"zhangsan","picture":"/bj_community/20170216/1487214289175.jpg","praiseCount":2,"sid":1,"status":1}]
             * params : {"start":1,"limit":10}
             * start : 1
             * total : 3
             */

            private int limit;
            private ParamsBean params;
            private int start;
            private int total;
            private List<TalentListData> list;

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

            public List<TalentListData> getList() {
                return list;
            }

            public void setList(List<TalentListData> list) {
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

            public static class ListBean {

            }
        }
    }
}
