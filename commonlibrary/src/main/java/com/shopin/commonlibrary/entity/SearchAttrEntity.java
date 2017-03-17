package com.shopin.commonlibrary.entity;

import java.util.List;
import java.util.Map;

/**
 * @author jianghongbo
 * @version 1.0
 * @file SearchAttrEntity.java
 * @brief
 * @date 2017/2/27
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class SearchAttrEntity {
    private Map<String,List<String>> map;

    public Map<String, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<String>> map) {
        this.map = map;
    }
}
