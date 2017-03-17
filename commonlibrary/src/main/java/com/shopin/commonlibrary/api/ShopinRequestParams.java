package com.shopin.commonlibrary.api;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.shopin.commonlibrary.core.CommonAppLike;
import com.shopin.commonlibrary.utils.AppUtil;
import com.shopin.commonlibrary.utils.dataprocess.GsonUtil;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ShopinRequestParams.java
 * @brief 封装请求参数
 * @date 2017/1/8
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class ShopinRequestParams {

    private ShopinRequestParams() {
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        public Builder() {
        }

        Map<String, Object> map = new TreeMap<>();

        public Builder add(String key, Object value) {
            if (!TextUtils.isEmpty(key) && value != null) {
                map.put(key, value);
            }
            return this;
        }

        /**
         * 用于content type为json的post请求，service方法为@Body类型的参数
         * @return
         */
        public RequestBody body() {
            //添加公共参数
            addCommonParams();
            String body = GsonUtil.bean2json(map);
            return RequestBody.create(MediaType.parse(Api.CONTENT_TYPE_FORM), body);
        }

        /**
         * 返回一个map用于QueryMap注解的参数类型
         * @return
         */
        public Map<String, Object> paramsMap() {
            //添加公共参数
            addCommonParams();
            return map;
        }

        public MultipartBody.Builder filesToMultipartBody(@NonNull List<File> files) {
            MultipartBody.Builder builder = new MultipartBody.Builder();

            for (int i = 0; i < files.size(); i++) {
                File file = files.get(i);
                // 这里为了简单起见，没有判断file的类型，并且按照本项目只能上传一个文件 并且name为file修改
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
                //文件以file0,1,2这样命名
                builder.addFormDataPart("file", file.getName(), requestBody);
            }
            builder.setType(MultipartBody.FORM);
            return builder;
        }

        private void addCommonParams() {
            add("deviceType", "1")
                    .add("deviceSn", AppUtil.getDeviceId(CommonAppLike.getContext()))
                    .add("appVersion", AppUtil.getVersionName(CommonAppLike.getContext()))
                    .add("systemVersion", AppUtil.getOSVersion())
                    .add("versionNo", String.valueOf(AppUtil.getVersionCode(CommonAppLike.getContext())));
        }

        public Builder addAudio(String key, String path) {
            File file = new File(path);
            FileNameMap fileNameMap = URLConnection.getFileNameMap();
            String contentTypeFor = fileNameMap.getContentTypeFor(path);
            RequestBody requestBody =
                    RequestBody.create(MediaType.parse(contentTypeFor), file);
            map.put(key + "\";filename=\"" + file.getName(), requestBody);
            return this;
        }

        public Builder addPic(String key, List<File> fileList) {
            for (int i = 0; i < fileList.size(); i++) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), fileList.get(i));
                map.put(key + "[" + i + "]" + "\";filename=\"" + fileList.get(i).getName(), requestBody);
            }
            return this;
        }

        public Builder addSinglePic(String key, File file) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
            map.put(key + "\";filename=\"" + file.getName(), requestBody);
            return this;
        }


        public Builder addGif(String key, File file) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/gif"), file);
            map.put(key + "\";filename=\"" + file.getName(), requestBody);
            return this;
        }

        public Builder addVideo(String key, String path) {
            File file = new File(path);
            RequestBody requestBody = RequestBody.create(MediaType.parse("video/mp4"), file);
            map.put(key + "\";filename=\"" + file.getName(), requestBody);
            return this;
        }
    }


}
