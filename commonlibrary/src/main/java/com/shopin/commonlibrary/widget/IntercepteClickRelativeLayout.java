package com.shopin.commonlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/4/5.
 */
public class IntercepteClickRelativeLayout extends RelativeLayout {

    public boolean intercept;

    public IntercepteClickRelativeLayout(Context context) {
        super(context);
    }

    public IntercepteClickRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IntercepteClickRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int downX;
    private int downY;
    private int upX;
    private int upY;
    private static final int DEVIATION = 7;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return intercept;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) ev.getX();
                downY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                upX = (int) ev.getX();
                upY = (int) ev.getY();
                if (downX == upX && downY == upY && onClickListener != null) {
                    onClickListener.onClick(this);
                } else if (onClickListener != null) {
                    if (upY < downY + DEVIATION && upY > downY - DEVIATION
                            && upX < downX + DEVIATION && upX > downX - DEVIATION
                            )
                        onClickListener.onClick(this);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    OnClickListener onClickListener;

    @Override
    public void setOnClickListener(OnClickListener l) {
        this.onClickListener = l;
    }

    public void setIntercept(boolean intercept) {
        this.intercept = intercept;
    }
}
