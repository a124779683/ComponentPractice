package com.shopin.commonlibrary.core.di;

import android.app.Application;

import com.jhb.network.MyCacheSpeak;
import com.jhb.network.WrapGsonDeserializerInfo;
import com.shopin.commonlibrary.api.ShopinGsonConverterFactory;
import com.shopin.commonlibrary.api.interceptor.RequestIntercept;
import com.shopin.commonlibrary.core.AppManager;
import com.shopin.commonlibrary.entity.UserEntity;
import com.shopin.commonlibrary.entity.UserMayBeEmptyStringDeserializer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErroListener;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by jessyan on 2017/3/14.
 */
@Module
public class ClientModule {
    private static final int TIME_OUT = 10;
    public static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;//缓存文件最大值为10Mb
    private AppManager mAppManager;


    public ClientModule(AppManager appManager) {
        this.mAppManager = appManager;
    }

    /**
     * @param builder
     * @param client
     * @param httpUrl
     * @return
     * @author: jess
     * @date 8/30/16 1:15 PM
     * @description:提供retrofit
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, HttpUrl httpUrl) {

        //处理一些有可能反序列化错误的接口
        List<WrapGsonDeserializerInfo> deserializerInfos = new ArrayList<>();
        WrapGsonDeserializerInfo user = new WrapGsonDeserializerInfo();
        user.setClazz(UserEntity.class);
        user.setDeserializer(new UserMayBeEmptyStringDeserializer());
        deserializerInfos.add(user);

        return builder
                .baseUrl(httpUrl)//域名
                .client(client)//设置okhttp
                //使用rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //使用我们自定义的Gson
                .addConverterFactory(ShopinGsonConverterFactory.create(deserializerInfos))
                .build();
    }

    /**
     * 提供OkhttpClient
     * @param okHttpClient
     * @return
     */
    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder okHttpClient, Cache cache, Interceptor intercept
            , List<Interceptor> interceptors) {
        OkHttpClient.Builder builder = okHttpClient
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cache(cache)//设置缓存
                .addNetworkInterceptor(intercept);
        if (interceptors != null && interceptors.size() > 0) {//如果外部提供了interceptor的数组则遍历添加
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder
                .build();
    }


    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }


    @Singleton
    @Provides
    Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);//设置缓存路径和大小
    }


    @Singleton
    @Provides
    Interceptor provideIntercept(RequestIntercept intercept) {
        return intercept;//打印请求信息的拦截器
    }


    /**
     * 提供RXCache客户端
     * @param cacheDir 缓存路径
     * @return
     */
    @Singleton
    @Provides
    RxCache provideRxCache(File cacheDir) {
        return new RxCache
                .Builder()
                .persistence(cacheDir, new MyCacheSpeak());
    }


    /**
     * 提供处理Rxjava错误的管理器
     * @return
     */
    @Singleton
    @Provides
    RxErrorHandler proRxErrorHandler(Application application, ResponseErroListener listener) {
        return RxErrorHandler
                .builder()
                .with(application)
                .responseErroListener(listener)
                .build();
    }
//
//    /**
//     * 提供权限管理类,用于请求权限,适配6.0的权限管理
//     *
//     * @param application
//     * @return
//     */
//    @Singleton
//    @Provides
//    RxPermissions provideRxPermissions(Application application) {
//        return RxPermissions.getInstance(application);
//    }


    /**
     * 提供管理所有activity的管理类
     * @return
     */
    @Singleton
    @Provides
    AppManager provideAppManager() {
        return mAppManager;
    }


//    .addNetworkInterceptor(new Interceptor() {
//        @Override
//        public Response intercept(Interceptor.Chain chain) throws IOException {
//            Request request = chain.request();
//            if(!DeviceUtils.netIsConnected(UiUtils.getContext())){
//                request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_CACHE)
//                        .build();
//                LogUtils.warnInfo("http","no network");
//            }
//            Response originalResponse = chain.proceed(request);
//            if(DeviceUtils.netIsConnected(UiUtils.getContext())){
//                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//                String cacheControl = request.cacheControl().toString();
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma")
//                        .build();
//            }else{
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
//                        .removeHeader("Pragma")
//                        .build();
//            }
//        }
//    })

}