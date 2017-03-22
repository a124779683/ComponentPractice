package com.jhb.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shopin.commonlibrary.core.TitleBaseActivity;
import com.shopin.commonlibrary.core.di.AppComponent;
import com.shopin.commonlibrary.mvp.BaseView;

import static android.view.View.GONE;

/**
 * @author jianghongbo
 * @version 1.0
 * @file HomeActivity.java
 * @brief
 * @date 2017/3/15
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class HomeActivity extends TitleBaseActivity implements BaseView {


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity_home;
    }

    @Override
    protected void initIntentParams(Intent intent) {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        getTitleHeaderBar().setVisibility(GONE);
        $(R.id.tv_haha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("R.dfasf");
            }
        });
    }

    @Override
    protected void initData() {

    }
}