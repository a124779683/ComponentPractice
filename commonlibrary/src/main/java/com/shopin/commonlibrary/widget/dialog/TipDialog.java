package com.shopin.commonlibrary.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shopin.commonlibrary.R;
import com.shopin.commonlibrary.utils.UIUtils;


/**
 * @author 蒋洪波
 * @version 2.0
 * @file TipDialog.java
 * @brief 简单提示
 * @date 2017/11/24
 * Copyright (c) 2017，上品折扣
 * All rights reserved.
 */
public class TipDialog extends BaseDialog {
    TextView mClosed;
    TextView mTitle;
    TextView mTip;
    private TextView mButton;

    public TipDialog(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        widthScale(0.9f);
        View view = View.inflate(context.get(), R.layout.dialog_tip, null);
        mTitle = (TextView) view.findViewById(R.id.tv_tip_title);
        mTip = (TextView) view.findViewById(R.id.tv_tip_tip);
        mButton = (TextView) view.findViewById(R.id.tv_tip_btn);
        mClosed = (TextView) view.findViewById(R.id.tv_tip_closed);

        mClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowing()) {
                    UIUtils.closeDialog(TipDialog.this);
                }
            }
        });
        return view;
    }

    @Override
    public boolean setUiBeforShow() {
        return false;
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setTip(String tip) {
        this.mTip.setText(tip);
    }

    public void setBtn(String tip, View.OnClickListener listener) {
        this.mButton.setVisibility(View.VISIBLE);
        this.mButton.setText(tip);
        this.mButton.setOnClickListener(listener);
    }

    public void hideClose() {
        mClosed.setVisibility(View.GONE);
    }
}
