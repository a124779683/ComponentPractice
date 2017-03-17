package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file CartItemEntity.java
 * @brief 购物车列表项
 * @date 2017/2/22
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
@Parcelable
public class CartItemEntity {


    /**
     * brandName : 皮尔卡丹pierre cardin
     * brandSid : 9721
     * cartType : 3
     * categoryName : 棉服
     * categorySid : 1234
     * color : 953
     * currentPrice : 600.00
     * erpBrandSid : B083
     * erpCategorySid : 720407
     * expressType : 1
     * name : 皮尔卡丹pierre cardin 女装  秋冬 棉服 4452M4072953
     * originalPrice : 3680.00
     * proPicture : /1004/2016/11/10/c774a2f06b06a9dc3d9ae9b244054c36_0.jpg
     * proSku : 4452M4072953
     * proSum : 0
     * productSid : 12122103
     * promotionPrice : 600.00
     * qty : 1
     * shopPrice : 3680.00
     * shopSid : 1004
     * sid : 2973714003
     * size : 170/92A
     * storeCount : 1
     * supplySid : 100090
     * wsgItemCreateTime : 2017-01-19 06:47:36
     */
    //折扣信息集合
    private List<OrderActivityEntity> discountList;
    private String fee;

    private String brandName;
    private String brandSid;
    private String cartType;
    private String categoryName;
    private String categorySid;
    private String color;
    private String currentPrice;
    private String erpBrandSid;
    private String erpCategorySid;
    private String expressType;
    private String name;
    private String originalPrice;
    private String proPicture;
    private String proSku;
    private int proSum;
    private String productSid;
    private String promotionPrice;
    private int qty;
    private String shopPrice;
    private String shopSid;
    //proDetailSid
    private String sid;
    private String size;
    private String storeCount;
    private String supplySid;
    private String wsgItemCreateTime;
    private boolean selected;
    private boolean edit;
    private int parentPosition;
    //商品来源，从扫一扫过来，channelMark 为1，线上方式传递2
    private int channelMark = 2;

    public int getChannelMark() {
        return channelMark;
    }

    public void setChannelMark(int channelMark) {
        this.channelMark = channelMark;
    }

    public void setProDetailSid(String detailSid) {
        this.sid = detailSid;
    }

    public String getProDetailSid() {
        return sid;
    }


    public List<OrderActivityEntity> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<OrderActivityEntity> discountList) {
        this.discountList = discountList;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSid() {
        return brandSid;
    }

    public void setBrandSid(String brandSid) {
        this.brandSid = brandSid;
    }

    public String getCartType() {
        return cartType;
    }

    public void setCartType(String cartType) {
        this.cartType = cartType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySid() {
        return categorySid;
    }

    public void setCategorySid(String categorySid) {
        this.categorySid = categorySid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getErpBrandSid() {
        return erpBrandSid;
    }

    public void setErpBrandSid(String erpBrandSid) {
        this.erpBrandSid = erpBrandSid;
    }

    public String getErpCategorySid() {
        return erpCategorySid;
    }

    public void setErpCategorySid(String erpCategorySid) {
        this.erpCategorySid = erpCategorySid;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getProPicture() {
        return proPicture;
    }

    public void setProPicture(String proPicture) {
        this.proPicture = proPicture;
    }

    public String getProSku() {
        return proSku;
    }

    public void setProSku(String proSku) {
        this.proSku = proSku;
    }

    public int getProSum() {
        return proSum;
    }

    public void setProSum(int proSum) {
        this.proSum = proSum;
    }

    public String getProductSid() {
        return productSid;
    }

    public void setProductSid(String productSid) {
        this.productSid = productSid;
    }

    public String getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(String promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopSid() {
        return shopSid;
    }

    public void setShopSid(String shopSid) {
        this.shopSid = shopSid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(String storeCount) {
        this.storeCount = storeCount;
    }

    public String getSupplySid() {
        return supplySid;
    }

    public void setSupplySid(String supplySid) {
        this.supplySid = supplySid;
    }

    public String getWsgItemCreateTime() {
        return wsgItemCreateTime;
    }

    public void setWsgItemCreateTime(String wsgItemCreateTime) {
        this.wsgItemCreateTime = wsgItemCreateTime;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setParentPosition(int parentPosition) {
        this.parentPosition = parentPosition;
    }

    public int getParentPosition() {
        return parentPosition;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        CartItemEntity entity = (CartItemEntity) o;

        return sid != null ? sid.equals(entity.getSid()) : entity.getSid() == null;
    }

    @Override
    public int hashCode() {
        return sid != null ? sid.hashCode() : 0;
    }
}
