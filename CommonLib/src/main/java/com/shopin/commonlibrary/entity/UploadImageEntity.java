package com.shopin.commonlibrary.entity;

/**
 * Created by zq on 2017/2/20.
 */
public class UploadImageEntity {

    /**
     * success : true
     * body : {"entity":{"pictureName":"/bj_community/20170220/image_1487569029350.jpg"}}
     */

    private boolean success;
    private BodyBean body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * entity : {"pictureName":"/bj_community/20170220/image_1487569029350.jpg"}
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
             * pictureName : /bj_community/20170220/image_1487569029350.jpg
             */

            private String smallPicture;
            private String pictureName;

            public String getPictureName() {
                return pictureName;
            }

            public void setPictureName(String pictureName) {
                this.pictureName = pictureName;
            }

            public String getSmallPicture() {
                return smallPicture;
            }

            public void setSmallPicture(String smallPicture) {
                this.smallPicture = smallPicture;
            }
        }
    }
}
