package com.shopin.commonlibrary.adapter;

import android.view.View;

/**
 * @author 蒋洪波
 * @version 版本号
 * @file 文件名
 * @brief 简要说明
 * 详细说明,如果没有请删除
 * @date 2017/10/28
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public interface OnItemClickListener<T> {
    void onItemClick(View v, int position, T t);
}
