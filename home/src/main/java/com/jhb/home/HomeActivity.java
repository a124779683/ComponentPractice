package com.jhb.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jhb.util.LogUtil;
import com.shopin.commonlibrary.mvp.BaseView;

/**
 * @author jianghongbo
 * @version 1.0
 * @file HomeActivity.java
 * @brief
 * @date 2017/3/15
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class HomeActivity extends AppCompatActivity implements BaseView {


    private View viewById;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);

        viewById = findViewById(R.id.tv_haha);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.tv_haha) {
                    LogUtil.i("hahah", "freeline");
                }
            }
        });


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
