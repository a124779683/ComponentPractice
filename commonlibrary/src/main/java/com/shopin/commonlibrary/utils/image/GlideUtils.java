package com.shopin.commonlibrary.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shopin.commonlibrary.utils.StringUtils;

/**
 * @author Administrator
 * @version 1.0
 * @file GlideCircleTransform.java
 * @brief Glide加载圆角图片用的transform
 * @date 2017/6/17
 * Copyright (c) 2017
 * All rights reserved.
 */
public class GlideUtils {
    /**
     * 上品图片加载规则
     * @param ctx
     * @param view
     * @param host 主机地址
     * @param dir  文件夹地址
     * @param path 路径
     */
    public static void load(Context ctx, ImageView view, String host, String dir, String path,int placeHold) {
        load(ctx, view, StringUtils.concat(host, dir, path),placeHold);
    }
    /**
     * 上品图片加载规则
     * @param ctx
     * @param view
     * @param host 主机地址
     * @param path 路径
     * @param placeHold
     */
    public static void loadCircle(Context ctx, ImageView view, String host, String path,int placeHold) {
        loadCircle(ctx, view, StringUtils.concat(host, path),placeHold);
    }

    /**
     * 上品图片加载规则
     * @param ctx
     * @param view
     * @param host 主机地址
     * @param path 路径
     */
    public static void load(Context ctx, ImageView view, String host,String path,int placeHold) {
        load(ctx, view, StringUtils.concat(host, path),placeHold);
    }

    /**
     * 普通的加载图片，不带占位图
     * @param ctx
     * @param view
     * @param uri
     */
    public static void load(Context ctx, ImageView view, String uri) {
        load(ctx, view, uri, 0);
    }

    /**
     * 普通的加载图片，带占位图
     * @param ctx
     * @param view
     * @param uri
     */
    public static void load(Context ctx, ImageView view, String uri, int placeHolder) {
        Glide.with(ctx)
                .load(uri)
                .crossFade()
                .placeholder(placeHolder)
                .fitCenter()
                .thumbnail(0.5f)
                .into(view);
    }

    /**
     * 普通的加载图片，带占位图
     * @param ctx
     * @param view
     * @param resourceId
     */
    public static void load(Context ctx, ImageView view, int resourceId) {
        Glide.with(ctx)
                .load(resourceId)
                .crossFade()
                .fitCenter()
                .thumbnail(0.5f)
                .into(view);
    }

    /**
     * 加载圆形头像，不带占位图
     * @param ctx
     * @param view
     * @param url
     */
    public static void loadCircle(Context ctx, ImageView view, String url) {
        loadCircle(ctx, view, url, 0);
    }

    /**
     * 加载圆形头像
     * @param ctx         对应的context
     * @param view        view
     * @param url         地址
     * @param placeHolder 占位图资源
     */
    public static void loadCircle(Context ctx, ImageView view, String url, int placeHolder) {
        Glide.with(ctx)
                .load(url)
                .crossFade()
                .centerCrop()
                .placeholder(placeHolder)
                .transform(new GlideCircleTransform(ctx))
                .into(view);
    }

    /**
     * 加载圆形头像，不带占位图
     * @param ctx
     * @param view
     * @param url
     */
    public static void loadRound(Context ctx, ImageView view, String url) {
        loadCircle(ctx, view, url, 0);
    }

    /**
     * 加载圆形头像
     * @param ctx         对应的context
     * @param view        view
     * @param url         地址
     * @param placeHolder 占位图资源
     */
    public static void loadRound(Context ctx, ImageView view, String url, int placeHolder) {
        Glide.with(ctx)
                .load(url)
                .crossFade()
                .centerCrop()
                .placeholder(placeHolder)
                .transform(new GlideRoundTransform(ctx))
                .into(view);
    }


}
