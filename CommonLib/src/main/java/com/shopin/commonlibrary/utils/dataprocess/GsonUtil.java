package com.shopin.commonlibrary.utils.dataprocess;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.shopin.commonlibrary.entity.WrapGsonDeserializerInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 蒋洪波
 * @file GsonUtil.java
 * @brief Gson工具类
 * @date 2017-10-10
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class GsonUtil {
    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @brief 将JSON转为实体
     */
    public static <T> T json2Bean(String json, Class<T> clazz) {

        return json2Bean(json, clazz, null);
    }

    static IntegerMayBeEmptyStringDeserializer emptyStringDeserializer = new IntegerMayBeEmptyStringDeserializer();
    static DoubleMayBeEmptyStringDeserializer doubleEmptyStringDeserializer = new DoubleMayBeEmptyStringDeserializer();

    /**
     * @param json
     * @param clazz
     * @param info  反序列化处理封装集合
     * @param <T>
     * @return
     * @brief 带有反序列化器的GSON
     */
    public static <T> T json2Bean(String json, Class<T> clazz, List<WrapGsonDeserializerInfo> info) {
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
        try {
            T t = gson.fromJson(json, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GSON EX ++++++++++++" + e.toString());
            return null;
        }
    }

    /**
     * @param obj
     * @return
     * @brief 将一个对象装为Json格式的字符串
     */

    public static String bean2json(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * @param obj
     * @return
     * @brief 对JSONOBJECT内部进行排序
     */
    public static String sortJSONObject(JSONObject obj) {
        try {
            if (obj == null)
                return null;

            Iterator<String> keys = obj.keys();
            String[] keySort = new String[obj.length()];

            //把KEY取出来
            for (int i = 0; i < keySort.length; i++) {
                keySort[i] = keys.next();
            }
            //对Key进行排序
            Arrays.sort(keySort);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < keySort.length; i++) {
                sb.append(keySort[i]);
                sb.append("=");
                //先取值的类型
                Object opt = obj.opt(keySort[i]);
                if (opt instanceof Number) {
                    //对于数字类型的数据要用JSONObject处理数字方式重新处理，否则会与传递给服务器的不一样，因为在put参数的时候会按这样的方式做检查处理，会导致舍弃精度的操作。
                    String num = JSONObject.numberToString((Number) opt);
                    sb.append(num);
                } else if (opt instanceof JSONArray) {//判断是否是JSONArray
                    //提供一个方法用于返回JSONArray的值，此处按理来说应该递归sortJSONArray，但是后台为了简单点处理，直接把第二层做字符串拼接起来
                    String result = sortJSONArray((JSONArray) opt);
                    sb.append(result);
                } else {
                    sb.append(obj.optString(keySort[i]));
                }
            }
            return sb.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sortJSONArray(JSONArray value) {
        StringBuilder jsonString = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            String s = sortJSONObject(value.optJSONObject(i));
            //如果为空，取字符串
            if (TextUtils.isEmpty(s)) {
                s = value.optString(i);
            }
            jsonString.append(s);
        }
        return jsonString.toString();
    }
}
