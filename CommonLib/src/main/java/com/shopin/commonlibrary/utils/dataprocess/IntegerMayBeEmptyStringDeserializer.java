package com.shopin.commonlibrary.utils.dataprocess;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file ReplenishDeserializer.java
 * @brief 补货商品反序列化对象，样板对象有可能为空
 * @date 2017/11/5
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class IntegerMayBeEmptyStringDeserializer implements JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        int defValue = 0;
        try {
            if (json.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = json.getAsJsonPrimitive();
                defValue = asJsonPrimitive.getAsInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defValue;
    }
}
