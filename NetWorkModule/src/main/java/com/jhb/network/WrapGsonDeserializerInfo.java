package com.jhb.network;

import com.google.gson.JsonDeserializer;

/**
 * @author 蒋洪波
 * @file WrapGsonDeserializerInfo.java
 * @brief 包装Gson反序列化对象时需要处理的对象信息
 * @date 2017-6-7
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class WrapGsonDeserializerInfo {

    private JsonDeserializer deserializer;
    private Class clazz;

    public JsonDeserializer getDeserializer() {
        return deserializer;
    }

    public void setDeserializer(JsonDeserializer deserializer) {
        this.deserializer = deserializer;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
