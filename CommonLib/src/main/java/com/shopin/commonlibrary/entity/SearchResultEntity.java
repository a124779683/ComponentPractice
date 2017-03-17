package com.shopin.commonlibrary.entity;


import java.util.List;
import java.util.Map;

/**
 * @author 蒋洪波
 * @file SearchResultEntity.java
 * @brief 商品标签
 * @date 2017/1/8
 * Copyright (c) 2017
 * All rights reserved.
 */
public class SearchResultEntity {
    private Map<String,List<String>> attrs;
    private List<String> brands;
    private List<String> categorys;
    private List<String> prices;
    private List<String> shops;
    private List<SearchProductEntity> esProducts;
    private int pageNum;
    private int totalCount;
    private int totalPage;

    public List<String> getShops() {
        return shops;
    }

    public void setShops(List<String> shops) {
        this.shops = shops;
    }

    public Map<String, List<String>> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, List<String>> attrs) {
        this.attrs = attrs;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<String> categorys) {
        this.categorys = categorys;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }

    public List<SearchProductEntity> getEsProducts() {
        return esProducts;
    }

    public void setEsProducts(List<SearchProductEntity> esProducts) {
        this.esProducts = esProducts;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
