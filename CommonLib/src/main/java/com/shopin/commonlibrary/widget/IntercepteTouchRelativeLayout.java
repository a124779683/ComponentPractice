package com.shopin.commonlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 拦截Touch事件到下层Fragment
 * Created by Administrator on 2017/4/5.
 */
public class IntercepteTouchRelativeLayout extends RelativeLayout implements View.OnTouchListener {


    public IntercepteTouchRelativeLayout(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public IntercepteTouchRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public IntercepteTouchRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

}
