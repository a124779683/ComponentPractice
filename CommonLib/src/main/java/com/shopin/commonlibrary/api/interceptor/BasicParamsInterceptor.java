package com.shopin.commonlibrary.api.interceptor;

import android.text.TextUtils;

import com.jhb.util.AppUtil;
import com.jhb.util.StringUtils;
import com.shopin.commonlibrary.core.CommonAppLike;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;


/**
 * Created by jk.yeo on 16/3/4 15:28.
 * Mail to ykooze@gmail.com
 */
public class BasicParamsInterceptor implements Interceptor {

    Map<String, String> queryParamsMap = new HashMap<>();
    Map<String, String> paramsMap = new HashMap<>();
    Map<String, String> headerParamsMap = new HashMap<>();
    List<String> headerLinesList = new ArrayList<>();

    private BasicParamsInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        /*
         * process header params inject ,
         * 支持完整的请求头参数和name value两种形式
         * 如 可以通过headerLineList 直接加入 content-type:application/json
         * 也可以通过headerParamsMap加入name为content-type value为applicaiton/json的头
         *
        */
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerParamsMap.size() > 0) {
            Iterator iterator = headerParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headerBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }

        if (headerLinesList.size() > 0) {
            for (String line : headerLinesList) {
                headerBuilder.add(line);
            }
            requestBuilder.headers(headerBuilder.build());
        }
        // process header params end


        /*
        process queryParams inject whatever it's GET ,如果POST也要加到URL中把第二个判断条件去掉即可
        是否在query参数中加入公共参数，稍微改一下只加入到URL上面
         */
        if (queryParamsMap.size() > 0 && canInjectIntoUrl(request)) {
            //根据需要加入设备ID
            addDeviceId(queryParamsMap);
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }

        // process post body inject
        if (paramsMap.size() > 0) {
            //根据需要加入设备ID
            addDeviceId(paramsMap);

            if (canInjectIntoFormBody(request)) {

                //表单提交公共参数
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                    formBodyBuilder.add((String) entry.getKey(), (String) entry.getValue());
                }

                RequestBody formBody = formBodyBuilder.build();
                String postBodyString = bodyToString(request.body());
                postBodyString += StringUtils.concat(postBodyString.length() > 0 ? "&" : "", bodyToString(formBody));
                requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
            } else if (canInjectIntoJsonBody(request)) {
                String postBodyString = bodyToString(request.body());
                if (!TextUtils.isEmpty(postBodyString)) {
                    int i = postBodyString.lastIndexOf('}');
                    if (i != -1) {
                        try {
                            JSONObject object = new JSONObject(postBodyString);
                            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                                object.put(entry.getKey(), entry.getValue());
                            }

                            postBodyString = object.toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                requestBuilder.post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), postBodyString));
            }
        }

        request = requestBuilder.build();
        return chain.proceed(request);
    }

    private void addDeviceId(Map<String, String> map) {
        boolean hasDeviceId = !TextUtils.isEmpty(map.get("deviceSn"));
        if (!hasDeviceId) {
            String deviceId = AppUtil.getDeviceId(CommonAppLike.getContext());
            map.put("deviceSn", deviceId);
        }
    }

    /**
     * 是否能加入到BODY中，必须是POST FORM表单提交参数才能添加
     * @param request
     * @return
     */
    private boolean canInjectIntoFormBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }

        if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            return false;
        }
        return true;
    }

    /**
     * 是否能加入到请求地址中
     * @param request
     * @return
     */
    private boolean canInjectIntoUrl(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "GET")) {
            return false;
        }
        return true;
    }

    /**
     * 是否能加入到JSON格式中，必须是POST JSON提交参数才能添加
     * @param request
     * @return
     */
    private boolean canInjectIntoJsonBody(Request request) {
//        if (paramsMap.size() == 0) {
//            return false;
//        }

        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }

        //判断子类型是不是json格式 格式为  [type]/[subType]
        if (!TextUtils.equals(mediaType.subtype(), "json")) {
            return false;
        }
        return true;
    }

    // func to inject params into url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                httpUrlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }

        return null;
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Builder {

        BasicParamsInterceptor interceptor;

        public Builder() {
            interceptor = new BasicParamsInterceptor();
        }

        public Builder addParam(String key, String value) {
            interceptor.paramsMap.put(key, value);
            return this;
        }

        public Builder addParamsMap(Map<String, String> paramsMap) {
            interceptor.paramsMap.putAll(paramsMap);
            return this;
        }

        public Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine : headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            interceptor.queryParamsMap.put(key, value);
            return this;
        }

        public Builder addQueryParamsMap(Map<String, String> queryParamsMap) {
            interceptor.queryParamsMap.putAll(queryParamsMap);
            return this;
        }

        public BasicParamsInterceptor build() {
            return interceptor;
        }

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