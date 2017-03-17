package com.shopin.commonlibrary.core;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import com.jhb.util.AppUtil;
import com.jhb.util.LogUtil;
import com.jhb.util.ResUtil;
import com.jhb.util.ToastUtil;
import com.shopin.commonlibrary.BuildConfig;
import com.shopin.commonlibrary.R;
import com.shopin.commonlibrary.api.Api;
import com.shopin.commonlibrary.api.interceptor.BasicParamsInterceptor;
import com.shopin.commonlibrary.core.di.AppComponent;
import com.shopin.commonlibrary.core.di.AppModule;
import com.shopin.commonlibrary.core.di.CacheModule;
import com.shopin.commonlibrary.core.di.ClientModule;
import com.shopin.commonlibrary.core.di.DaggerAppComponent;
import com.shopin.commonlibrary.core.di.DaggerBaseComponent;
import com.shopin.commonlibrary.core.di.GlobeConfigModule;
import com.shopin.commonlibrary.core.di.ImageModule;
import com.shopin.commonlibrary.core.di.ServiceModule;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.event.CheckUpgradeEvent;
import com.shopin.commonlibrary.exception.ResultException;
import com.shopin.commonlibrary.http.GlobeHttpHandler;
import com.shopin.commonlibrary.mvp.GlobalDialogActivity;
import com.shopin.commonlibrary.permission.DialogText;
import com.shopin.commonlibrary.permission.PermissifyConfig;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.zhy.changeskin.SkinManager;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.handler.listener.ResponseErroListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;


/**
 * @author jianghongbo
 * @version 1.0
 * @file AppLike.java
 * @brief 不要在这里初始化组件里的任何东西
 * @date 2017/12/16
 * Copyright (c) 2017
 * All rights reserved.
 */
public class CommonAppLike extends DefaultApplicationLike {

    private static Boolean isDebug;
    private static CommonAppLike appLike;

    //单位，小时
    private int tinkerUpdateInterval = 3;
    private String versionName;

    public CommonAppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                         long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
        appLike = this;
    }

    /**
     * install multiDex before install tinker
     * so we don't need to put the tinker lib classes in the main dex
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init();
        ResUtil.init(getApplication());
        LogUtil.init(isDebug());
        initPermission();
        initDagger();
        initSkin();
    }

    private void initSkin() {
        SkinManager.getInstance().init(getApplication());
    }

    private void initPermission() {
        PermissifyConfig permissifyConfig = new PermissifyConfig.Builder()
                .withDefaultTextForPermissions(new HashMap<String, DialogText>() {{
                    put(Manifest.permission_group.STORAGE, new DialogText(R.string.storage_rational, R.string.storage_deny_dialog));
                    put(Manifest.permission_group.CONTACTS, new DialogText(R.string.contact_rational, R.string.contact_deny_dialog));
                    put(Manifest.permission_group.PHONE, new DialogText(R.string.phone_rational, R.string.phone_deny_dialog));
                    put(Manifest.permission_group.SMS, new DialogText(R.string.sms_rational, R.string.sms_deny_dialog));
                    put(Manifest.permission_group.CAMERA, new DialogText(R.string.camera_rational, R.string.camera_deny_dialog));
                    put(Manifest.permission_group.LOCATION, new DialogText(R.string.location_rational, R.string.location_deny_dialog));
                }})
                .build();

        PermissifyConfig.initDefault(permissifyConfig);
    }

    private void initDagger() {
        //这块本应该放入到commonLib中，但是Tinker必须继承他的Application
        this.mAppModule = new AppModule(getApplication());//提供application
        DaggerBaseComponent
                .builder()
                .appModule(mAppModule)
                .build()
                .inject(this);
        this.mImagerModule = new ImageModule();//图片加载框架默认使用glide
        this.mClientModule = new ClientModule(mAppManager);//用于提供okhttp和retrofit的单例
        this.mGlobeConfigModule = createGlobeConfigModule();

        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())//baseApplication提供
                .clientModule(getClientModule())//baseApplication提供
                .imageModule(getImageModule())//baseApplication提供
                .globeConfigModule(mGlobeConfigModule)//Retrofit的全局配置，为clientModule提供Retrofit
                .serviceModule(new ServiceModule())//需自行创建，可以创建对应的ServiceManager
                .cacheModule(new CacheModule())//需自行创建
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppComponent != null)
            this.mAppComponent = null;
        if (mClientModule != null)
            this.mClientModule = null;
        if (mAppModule != null)
            this.mAppModule = null;
        if (mImagerModule != null)
            this.mImagerModule = null;
        if (mAppManager != null) {//释放资源
            this.mAppManager.release();
            this.mAppManager = null;
        }
        if (appLike != null)
            this.appLike = null;
    }

    private ClientModule mClientModule;
    private AppModule mAppModule;
    private ImageModule mImagerModule;
    private GlobeConfigModule mGlobeConfigModule;
    @Inject
    protected AppManager mAppManager;

    private static AppComponent mAppComponent;

    /**
     * 将app的全局配置信息封装进module(使用Dagger注入到需要配置信息的地方)
     * @return
     */
    private GlobeConfigModule createGlobeConfigModule() {
        return GlobeConfigModule
                .buidler()
                .baseurl(Api.APP_HOST)
                .globeHttpHandler(new GlobeHttpHandler() {// 这里可以提供一个全局处理http响应结果的处理类,
                    // 这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
                    @Override
                    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
                        //这里可以先客户端一步拿到每一次http请求的结果,可以解析成json,做一些操作,如检测到token过期后
                        //重新请求token,并重新执行请求
//                      try {
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            return response;
//                        }


                        //这里如果发现token过期,可以先请求最新的token,然后在拿新的token放入request里去重新请求
                        //注意在这个回调之前已经调用过proceed,所以这里必须自己去建立网络请求,如使用okhttp使用新的request去请求
                        // create a new request and modify it accordingly using the new token
//                    Request newRequest = chain.request().newBuilder().header("token", newToken)
//                            .build();

//                    // retry the request
//
//                    response.body().close();
                        //如果使用okhttp将新的请求,请求成功后,将返回的response  return出去即可

                        //如果不需要返回新的结果,则直接把response参数返回出去
                        return response;
                    }

                    // 这里可以在请求服务器之前可以拿到request,做一些操作比如给request统一添加token或者header
                    @Override
                    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                        //如果需要再请求服务器之前做一些操作,则重新返回一个新的requeat如增加header,不做操作则返回request
//                        RequestBody body = request.body();
//                        Request.Builder requestBuilder = request.newBuilder();
//                        if (body != null && body.contentType() != null) {
//                            HttpUrl.Builder urlBuilder = null;
//                            //Application/json类型
//                            if (body.contentType().toString().contains("json")) {
//                                urlBuilder = postJson(request);
//                                requestBuilder
//                                        .url(urlBuilder.build());//使用新拼接的url
//                            }
//                        }

                        return request;
                    }
                })
                //此公共参数是表单提交时候使用，普通使用ShopinRequestBody封装POST参数，但是get请求暂时没有添加公参
                .addInterceptor(createCommonParamIntercept())
//                .addInterceptor(new OkHttpMockInterceptor(getContext(), 1))
                .responseErroListener(new ResponseErroListener() {
                    //     用来提供处理所有错误的监听
                    //     rxjava必要要使用ErrorHandleSubscriber(默认实现Subscriber的onError方法),此监听才生效
                    @Override
                    public void handleResponseError(Context context, Exception e) {
                        //所有异常在这里处理
                        if (e instanceof ResultException) {
                            String resultCode = ((ResultException) e).getResultCode();
                            String message = e.getMessage();
                            if (!TextUtils.isEmpty(message)) {
                                ToastUtil.showToast(getApplication(), message);
                            }
                            LogUtil.e("code:" + resultCode + "msg:" + message);

                            if (TextUtils.equals(resultCode, BaseEntity.LACK_PARAMS)) {
                                //缺少必要参数
                                LogUtil.i(ResUtil.get().getString(R.string.lack_params));
                            } else if (TextUtils.equals(BaseEntity.INVALID_TOKENID, resultCode)) {
                                //不合法的TOKEN
                                Intent intent = new Intent(getContext(), GlobalDialogActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra(GlobalDialogActivity.INTENT, GlobalDialogActivity.INVALIDATE_TOKEN);
                                if (!TextUtils.isEmpty(message)) {
                                    intent.putExtra(BaseEntity.ERROR_MESSAGE, message);
                                }
                                getContext().startActivity(intent);
                            } else if (TextUtils.equals(BaseEntity.FORCE_UPGRADE, resultCode)) {
                                //强制更新 发一个EventBus通知主页和登陆页面，保证有一方会接收到通知。
                                EventBus.getDefault().post(new CheckUpgradeEvent());
                            } else if (TextUtils.equals(BaseEntity.FIX_TIME, resultCode)) {
                                //客制化
                                Intent intent = new Intent(getContext(), GlobalDialogActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra(GlobalDialogActivity.INTENT, GlobalDialogActivity.CUSTOM);
                                if (!TextUtils.isEmpty(message)) {
                                    intent.putExtra(GlobalDialogActivity.CONTENT, message);
                                }
                                getContext().startActivity(intent);
                            }
                        } else {
                            LogUtil.e(e.getMessage());
                        }
                    }
                }).build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public Interceptor createCommonParamIntercept() {
        boolean readPhonePermission = false;
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED) {
            readPhonePermission = true;
        }
        BasicParamsInterceptor interceptor = new BasicParamsInterceptor
                .Builder()
                .addParam("deviceType", "1")
                .addParam("deviceSn", readPhonePermission ? AppUtil.getDeviceId(CommonAppLike.getContext()) : "")
                .addParam("appVersion", AppUtil.getVersionName(getContext()))
                .addParam("systemVersion", AppUtil.getOSVersion())
                .addParam("versionNo", String.valueOf(AppUtil.getVersionCode(getContext())))
                .addQueryParam("deviceType", "1")
                .addQueryParam("deviceSn", readPhonePermission ? AppUtil.getDeviceId(CommonAppLike.getContext()) : "")
                .addQueryParam("appVersion", AppUtil.getVersionName(getContext()))
                .addQueryParam("systemVersion", AppUtil.getOSVersion())
                .addQueryParam("versionNo", String.valueOf(AppUtil.getVersionCode(getContext())))
                .build();
        return interceptor;
    }


    private String bodyToString(RequestBody body) {
        String postBodyString = null;
        if (body != null) {
            try {
                Buffer requestbuffer = new Buffer();
                body.writeTo(requestbuffer);
                if (body.contentType() != null && !body.contentType().toString().contains("multipart")) {
                    postBodyString = URLDecoder.decode(requestbuffer.readUtf8(), "UTF-8");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postBodyString;
    }


    public ClientModule getClientModule() {
        return mClientModule;
    }

    public AppModule getAppModule() {
        return mAppModule;
    }

    public ImageModule getImageModule() {
        return mImagerModule;
    }


    public AppManager getAppManager() {
        return mAppManager;
    }

    public GlobeConfigModule getGlobeConfigModule() {
        return mGlobeConfigModule;
    }

    /**
     * 返回上下文
     * @return
     */
    public static Context getContext() {
        return appLike.getApplication();
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }


    public static CommonAppLike getInstance() {
        return appLike;
    }

    public static boolean isDebug() {
        if (isDebug == null) {
            try {
                final Class<?> activityThread = Class.forName("android.app.ActivityThread");
                final Method currentPackage = activityThread.getMethod("currentPackageName");
                final String packageName = (String) currentPackage.invoke(null, (Object[]) null);
                final Class<?> buildConfig = Class.forName(packageName + ".BuildConfig");
                final Field DEBUG = buildConfig.getField("DEBUG");
                DEBUG.setAccessible(true);
                isDebug = DEBUG.getBoolean(null);
            } catch (final Throwable t) {
                final String message = t.getMessage();
                if (message != null && message.contains("BuildConfig")) {
                    // Proguard obfuscated build. Most likely a production build.
                    isDebug = false;
                } else {
                    isDebug = BuildConfig.DEBUG;
                }
            }
        }
        return isDebug;
    }
}
