package com.shopin.commonlibrary.entity;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file SearchProductEntity.java
 * @brief
 * @date 2017/2/27
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class SearchProductEntity {

    /**
     * attrIdNames : ["12121@@@颜色"]
     * attrValues : ["12121@@@12222"]
     * brandErpSid : B502
     * brandIdNames : B502@@@富熙
     * brandName : 富熙
     * categoryErpSid : 710813
     * categoryIdNames : 710813@@@内衣-女功能内衣-棉短筒袜
     * categoryName : 内衣-女功能内衣-棉短筒袜
     * createdTime : 1439359164000
     * cuPrice : 20
     * dispIdNames : ["001@@@女装"]
     * dispIds : ["001"]
     * ifImg : 0
     * offValue : 0.41
     * proPictDir : /5001/2016/04/26/
     * proPictName : Pic12971035_3832407_0.jpg
     * proSelling : 0
     * productName : 富熙090407
     * productSid : 10838921
     * productSku : 090407
     * season : 春夏
     * shopIdNames : ["1002@@@亚运村店","1003@@@来广营店"]
     * shopIds : [1002,1003]
     * shopNames : ["亚运村店","来广营店"]
     * supplySid : 100984
     * valueIdNames : ["12222@@@蓝色"]
     * year : 2015
     */

    private String brandErpSid;
    private String brandIdNames;
    private String brandName;
    private int categoryErpSid;
    private String categoryIdNames;
    private String categoryName;
    private long createdTime;
    private int cuPrice;
    private int ifImg;
    private double offValue;
    private String proPictDir;
    private String proPictName;
    private int proSelling;
    private String productName;
    private int productSid;
    private String productSku;
    private String season;
    private int supplySid;
    private int year;
    private List<String> attrIdNames;
    private List<String> attrValues;
    private List<String> dispIdNames;
    private List<String> dispIds;
    private List<String> shopIdNames;
    private List<Integer> shopIds;
    private List<String> shopNames;
    private List<String> valueIdNames;

    public String getBrandErpSid() {
        return brandErpSid;
    }

    public void setBrandErpSid(String brandErpSid) {
        this.brandErpSid = brandErpSid;
    }

    public String getBrandIdNames() {
        return brandIdNames;
    }

    public void setBrandIdNames(String brandIdNames) {
        this.brandIdNames = brandIdNames;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategoryErpSid() {
        return categoryErpSid;
    }

    public void setCategoryErpSid(int categoryErpSid) {
        this.categoryErpSid = categoryErpSid;
    }

    public String getCategoryIdNames() {
        return categoryIdNames;
    }

    public void setCategoryIdNames(String categoryIdNames) {
        this.categoryIdNames = categoryIdNames;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public int getCuPrice() {
        return cuPrice;
    }

    public void setCuPrice(int cuPrice) {
        this.cuPrice = cuPrice;
    }

    public int getIfImg() {
        return ifImg;
    }

    public void setIfImg(int ifImg) {
        this.ifImg = ifImg;
    }

    public double getOffValue() {
        return offValue;
    }

    public void setOffValue(double offValue) {
        this.offValue = offValue;
    }

    public String getProPictDir() {
        return proPictDir;
    }

    public void setProPictDir(String proPictDir) {
        this.proPictDir = proPictDir;
    }

    public String getProPictName() {
        return proPictName;
    }

    public void setProPictName(String proPictName) {
        this.proPictName = proPictName;
    }

    public int getProSelling() {
        return proSelling;
    }

    public void setProSelling(int proSelling) {
        this.proSelling = proSelling;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductSid() {
        return productSid;
    }

    public void setProductSid(int productSid) {
        this.productSid = productSid;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getSupplySid() {
        return supplySid;
    }

    public void setSupplySid(int supplySid) {
        this.supplySid = supplySid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAttrIdNames() {
        return attrIdNames;
    }

    public void setAttrIdNames(List<String> attrIdNames) {
        this.attrIdNames = attrIdNames;
    }

    public List<String> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<String> attrValues) {
        this.attrValues = attrValues;
    }

    public List<String> getDispIdNames() {
        return dispIdNames;
    }

    public void setDispIdNames(List<String> dispIdNames) {
        this.dispIdNames = dispIdNames;
    }

    public List<String> getDispIds() {
        return dispIds;
    }

    public void setDispIds(List<String> dispIds) {
        this.dispIds = dispIds;
    }

    public List<String> getShopIdNames() {
        return shopIdNames;
    }

    public void setShopIdNames(List<String> shopIdNames) {
        this.shopIdNames = shopIdNames;
    }

    public List<Integer> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<Integer> shopIds) {
        this.shopIds = shopIds;
    }

    public List<String> getShopNames() {
        return shopNames;
    }

    public void setShopNames(List<String> shopNames) {
        this.shopNames = shopNames;
    }

    public List<String> getValueIdNames() {
        return valueIdNames;
    }

    public void setValueIdNames(List<String> valueIdNames) {
        this.valueIdNames = valueIdNames;
    }
}
