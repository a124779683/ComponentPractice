package com.shopin.commonlibrary.core.di;

import android.app.Application;
import android.os.Handler;

import com.google.gson.Gson;
import com.shopin.commonlibrary.api.cache.CacheManager;
import com.shopin.commonlibrary.api.service.ServiceManager;
import com.shopin.commonlibrary.core.AppManager;
import com.shopin.commonlibrary.imageloader.ImageLoader;
import com.shopin.commonlibrary.utils.cache.ICache;

import javax.inject.Singleton;

import dagger.Component;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by jess on 8/4/16.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class, ImageModule.class,
        CacheModule.class, GlobeConfigModule.class})
public interface AppComponent {
    Application application();

    //服务管理器,retrofitApi
    ServiceManager serviceManager();

    //Retrofit
    Retrofit retrofitManager();

    //缓存管理器
    CacheManager cacheManager();

    //Rxjava错误处理管理类
    RxErrorHandler rxErrorHandler();

    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();

    //用于管理所有activity
    AppManager appManager();

    Handler getHandler();

    /**
     * 获得缓存实现类
     * @return
     */
    ICache getCacheUtil();
}
