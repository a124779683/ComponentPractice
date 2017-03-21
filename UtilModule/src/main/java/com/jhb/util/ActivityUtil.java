package com.jhb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.Stack;


/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 * @version 1.0
 * @created 2012-3-21
 */
public class ActivityUtil {

    private static Stack<Activity> activityStack;
    private static ActivityUtil instance;

    public interface IBuilder {
        void with(Intent intent);
    }

    private ActivityUtil() {
    }

    /**
     * 单一实例
     */
    public static ActivityUtil getInstance() {
        if (instance == null) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 简单开启Activity的方法
     * @param context
     * @param cls
     */
    public static void startToActivity(Context context, Class cls) {
        startToActivity(context, cls, null);
    }

    /**
     * 简单开启Activity的方法，带Intent参数
     * @param context
     * @param cls
     */
    public static void startToActivity(Context context, Class cls, IBuilder builder) {
        Intent intent = new Intent(context, cls);
        if (builder != null) {
            builder.with(intent);
        }
        context.startActivity(intent);
    }

    /**
     * @param context
     * @param cls
     */
    public static void startToActivityForResult(Activity context, Class cls, int requestCode) {
        startToActivityForResult(context, cls, requestCode, null);
    }

    /**
     * @param context
     * @param cls
     * @param requestCode
     * @param builder
     */
    public static void startToActivityForResult(Activity context, Class cls, int requestCode, IBuilder builder) {
        Intent intent = new Intent(context, cls);
        if (builder != null) {
            builder.with(intent);
        }
        context.startActivityForResult(intent, requestCode);
    }
}