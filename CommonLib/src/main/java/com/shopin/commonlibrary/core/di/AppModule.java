package com.shopin.commonlibrary.core.di;

import android.app.Application;
import android.os.Handler;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jess on 8/4/16.
 */
@Module
public class AppModule {
    private Application mApplication;
    private Handler handler;

    public AppModule(Application application) {
        this.mApplication = application;
        this.handler = new Handler();
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public Handler provideHandler() {
        return handler;
    }

}
