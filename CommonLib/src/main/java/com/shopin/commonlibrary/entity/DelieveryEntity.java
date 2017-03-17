package com.shopin.commonlibrary.entity;

import com.baoyz.pg.Parcelable;

/**
 * @author 周竹
 * @version 3.0
 * @file DelieveryEntity.java
 * @brief
 * @date 2017/7/11 18:41
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
@Parcelable
public class DelieveryEntity {
    private String templateId;
    private String templateName;
    private String delieveryFee;
    private String isSeclect;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDelieveryFee() {
        return delieveryFee;
    }

    public void setDelieveryFee(String delieveryFee) {
        this.delieveryFee = delieveryFee;
    }

    public String getIsSeclect() {
        return isSeclect;
    }

    public void setIsSeclect(String isSeclect) {
        this.isSeclect = isSeclect;
    }
}
