package com.shopin.commonlibrary.utils;

import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

import com.shopin.commonlibrary.core.CommonAppLike;


/**
 * Created by zhangzhiqiang@zjsj on 2017/10/8.
 */
public class ToastUtil {

    public static short POSITION_BOTTOM = 2;
    public static short POSITION_CENTER = 1;
    public static int DEFAULT_DURATION = 2000;

    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }
    };

    /**
     * @param text     文字
     * @param duration 持续的时间
     * @param position 位置
     */
    public static void showToast(String text, int duration, short position) {

        mHandler.removeCallbacks(r);
        if (mToast != null)
            mToast.setText(text);
        else
            mToast = Toast.makeText(CommonAppLike.getInstance().getApplication(), text, Toast.LENGTH_SHORT);
        if (POSITION_BOTTOM == position) {
            mToast.setGravity(Gravity.BOTTOM, 0, 0);
        } else {
            mToast.setGravity(Gravity.CENTER, 0, 0);
        }
        mHandler.postDelayed(r, duration);
        mToast.show();
    }

    public static void showToast(int resId, int duration, short position) {
        showToast(ResourceUtil.getString(resId), duration, position);
    }

    public static void showToast(int resId, int duration) {
        showToast(ResourceUtil.getString(resId), duration, POSITION_CENTER);
    }

    public static void showToast(int resId) {
        showToast(ResourceUtil.getString(resId), DEFAULT_DURATION, POSITION_CENTER);
    }

    public static void showToast(String text) {
        showToast(text, DEFAULT_DURATION, POSITION_CENTER);
    }

    public static void showToast(String text, int duration) {
        showToast(text, duration, POSITION_CENTER);
    }
}
