package com.shopin.commonlibrary.core.di;


import com.shopin.commonlibrary.api.service.CommonService;
import com.shopin.commonlibrary.api.service.OrderService;
import com.shopin.commonlibrary.api.service.TalentService;
import com.shopin.commonlibrary.api.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zhiyicx on 2017/3/30.
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    CommonService provideCommonService(Retrofit retrofit) {
        return retrofit.create(CommonService.class);
    }

    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Singleton
    @Provides
    OrderService provideOrderService(Retrofit retrofit) {
        return retrofit.create(OrderService.class);
    }

    @Singleton
    @Provides
    TalentService provideTalentService(Retrofit retrofit) {
        return retrofit.create(TalentService.class);
    }
}
