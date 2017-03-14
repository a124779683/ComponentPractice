package com.shopin.commonlibrary.utils.dataprocess;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file DoubleMayBeEmptyStringDeserializer.java
 * @brief 双精度类型有可能为空字符串的问题
 * @date 2017/11/5
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class DoubleMayBeEmptyStringDeserializer implements JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        double defValue = 0;
        try {
            if (json.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = json.getAsJsonPrimitive();
                defValue = asJsonPrimitive.getAsDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defValue;
    }
}
