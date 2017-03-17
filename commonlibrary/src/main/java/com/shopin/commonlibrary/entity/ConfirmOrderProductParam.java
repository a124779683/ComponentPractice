package com.shopin.commonlibrary.entity;

/**
 * 下单参数实体
 * @author sailfish
 * @create 2017-02-24-下午2:24
 */
public class ConfirmOrderProductParam implements Cloneable {
    //第一次必填参数 ,proDetailSid就是商品sid
    private Long proDetailSid;
    private String proSku;//款号
    private Long supplySid;
    private Long shopSid;
    private String erpBrandSid; // erp 品牌sid
    private String categorySid; //品类sid
    private Integer num;//购买商品数量
    //---end--
    private String activitySid;//活动信息
    private Long productSid;
    private Integer channelMark;//商品来源，1是线下，2是线上


    public Integer getChannelMark() {
        return channelMark;
    }

    public void setChannelMark(Integer channelMark) {
        this.channelMark = channelMark;
    }

    public String getProSku() {
        return proSku;
    }

    public void setProSku(String proSku) {
        this.proSku = proSku;
    }

    public Long getProductSid() {
        return productSid;
    }

    public void setProductSid(Long productSid) {
        this.productSid = productSid;
    }

    public Long getProDetailSid() {
        return proDetailSid;
    }

    public void setProDetailSid(Long proDetailSid) {
        this.proDetailSid = proDetailSid;
    }

    public Long getSupplySid() {
        return supplySid;
    }

    public void setSupplySid(Long supplySid) {
        this.supplySid = supplySid;
    }

    public Long getShopSid() {
        return shopSid;
    }

    public void setShopSid(Long shopSid) {
        this.shopSid = shopSid;
    }

    public String getActivitySid() {
        return activitySid;
    }

    public void setActivitySid(String activitySid) {
        this.activitySid = activitySid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    public String getErpBrandSid() {
        return erpBrandSid;
    }

    public void setErpBrandSid(String erpBrandSid) {
        this.erpBrandSid = erpBrandSid;
    }

    public String getCategorySid() {
        return categorySid;
    }

    public void setCategorySid(String categorySid) {
        this.categorySid = categorySid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        ConfirmOrderProductParam that = (ConfirmOrderProductParam) o;

        return proDetailSid != null ? proDetailSid.equals(that.getProDetailSid()) : that.getProductSid() == null;

    }

    @Override
    public int hashCode() {
        return proDetailSid != null ? proDetailSid.hashCode() : 0;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
