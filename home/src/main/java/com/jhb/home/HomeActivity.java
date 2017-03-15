package com.jhb.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.shopin.commonlibrary.utils.LogUtil;

/**
 * @author jianghongbo
 * @version 1.0
 * @file HomeActivity.java
 * @brief
 * @date 2017/3/15
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);

        findViewById(R.id.tv_tinker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "123", Toast.LENGTH_SHORT).show();
            }
        });
        LogUtil.i("hahah", "xixixixi");
    }
}
