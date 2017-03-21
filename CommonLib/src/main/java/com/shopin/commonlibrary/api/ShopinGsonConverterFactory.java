package com.shopin.commonlibrary.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.jhb.network.WrapGsonDeserializerInfo;
import com.shopin.commonlibrary.utils.dataprocess.DoubleMayBeEmptyStringDeserializer;
import com.shopin.commonlibrary.utils.dataprocess.IntegerMayBeEmptyStringDeserializer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ShopinGsonConverterFactory.java
 * @brief
 * @date 2017/1/8
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class ShopinGsonConverterFactory extends Converter.Factory {

    static IntegerMayBeEmptyStringDeserializer emptyStringDeserializer = new IntegerMayBeEmptyStringDeserializer();
    static DoubleMayBeEmptyStringDeserializer doubleEmptyStringDeserializer = new DoubleMayBeEmptyStringDeserializer();

    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static ShopinGsonConverterFactory create(List<WrapGsonDeserializerInfo> info) {
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        //默认注册两个
        gsonBuilder.registerTypeAdapter(int.class, emptyStringDeserializer);
        gsonBuilder.registerTypeAdapter(double.class, doubleEmptyStringDeserializer);

        if (info != null && info.size() > 0) {
            for (WrapGsonDeserializerInfo wrapGsonDeserializerInfo : info) {
                JsonDeserializer deserializer = wrapGsonDeserializerInfo.getDeserializer();
                Class cls = wrapGsonDeserializerInfo.getClazz();
                gsonBuilder.registerTypeAdapter(cls, deserializer);
            }
        }

        Gson gson = gsonBuilder.create();
        return new ShopinGsonConverterFactory(gson);
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static ShopinGsonConverterFactory create() {
        return ShopinGsonConverterFactory.create(null);
    }

    private final Gson gson;

    private ShopinGsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new ShopinGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        //在这里需要判断一下请求不同类型的数据了文件了，返回不同的转换
        return new ShopinGsonRequestBodyConverter<>(gson, adapter);
    }
}
