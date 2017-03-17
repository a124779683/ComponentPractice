package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file TestGoods.java
 * @brief
 * @date 2017/2/17
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class TestGoods {


    /**
     * body : {"list":[{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":7108,"categoryErpSid":710820,"categoryName":"内衣-女功能内衣-中长丝袜","cuPrice":10,"ifImg":1,"offValue":0.34,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511221_3024220_0.jpg","proSelling":0,"productName":"富熙BS090402","productSid":9511221,"productSku":"BS090402","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012","createdTime":1433751837000},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":7108,"categoryErpSid":710821,"categoryName":"内衣-女功能内衣-连裤丝袜","cuPrice":20,"ifImg":0,"offValue":0.22,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511251_3024221_0.jpg","proSelling":0,"productName":"富熙BS260113","productSid":9511251,"productSku":"BS260113","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":8104,"categoryErpSid":810401,"categoryName":"内衣多品-女士袜子-船袜","createdTime":1433751837000,"cuPrice":9,"ifImg":0,"offValue":0.6,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511321_1980299_0.jpg","proSelling":0,"productName":"富熙CR2211","productSid":9511321,"productSku":"CR2211-1","season":"春夏","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2014"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":710403,"categoryErpSid":71040301,"categoryName":"船袜","createdTime":1433751839000,"cuPrice":9,"ifImg":0,"offValue":0.6,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511331_1980300_0.jpg","proSelling":0,"productName":"富熙CR2211","productSid":9511331,"productSku":"CR2211-2","season":"春夏","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2014"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":710403,"categoryErpSid":71040306,"categoryName":"连裤袜","cuPrice":53,"ifImg":0,"offValue":0.6,"proSelling":0,"productName":"富熙DS090407","productSid":9512861,"productSku":"DS090407","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012"}],"total":145}
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
         * list : [{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":7108,"categoryErpSid":710820,"categoryName":"内衣-女功能内衣-中长丝袜","cuPrice":10,"ifImg":1,"offValue":0.34,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511221_3024220_0.jpg","proSelling":0,"productName":"富熙BS090402","productSid":9511221,"productSku":"BS090402","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":7108,"categoryErpSid":710821,"categoryName":"内衣-女功能内衣-连裤丝袜","cuPrice":20,"ifImg":0,"offValue":0.22,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511251_3024221_0.jpg","proSelling":0,"productName":"富熙BS260113","productSid":9511251,"productSku":"BS260113","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":8104,"categoryErpSid":810401,"categoryName":"内衣多品-女士袜子-船袜","createdTime":1433751837000,"cuPrice":9,"ifImg":0,"offValue":0.6,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511321_1980299_0.jpg","proSelling":0,"productName":"富熙CR2211","productSid":9511321,"productSku":"CR2211-1","season":"春夏","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2014"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":710403,"categoryErpSid":71040301,"categoryName":"船袜","createdTime":1433751839000,"cuPrice":9,"ifImg":0,"offValue":0.6,"proPictDir":"/1011/2015/04/03/","proPictName":"Pic9511331_1980300_0.jpg","proSelling":0,"productName":"富熙CR2211","productSid":9511331,"productSku":"CR2211-2","season":"春夏","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2014"},{"brandErpSid":"B502","brandName":"富熙","categoryErpParentSid":710403,"categoryErpSid":71040306,"categoryName":"连裤袜","cuPrice":53,"ifImg":0,"offValue":0.6,"proSelling":0,"productName":"富熙DS090407","productSid":9512861,"productSku":"DS090407","season":"秋冬","shopName":"来广营店","shopSid":1008,"supplySid":102345,"year":"2012"}]
         * total : 145
         */

        private int total;
        private List<SearchResultEntity> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<SearchResultEntity> getList() {
            return list;
        }

        public void setList(List<SearchResultEntity> list) {
            this.list = list;
        }

    }
}
