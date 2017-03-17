package com.shopin.commonlibrary.core.di;


import com.shopin.commonlibrary.api.cache.CommonCache;
import com.shopin.commonlibrary.core.CommonAppLike;
import com.shopin.commonlibrary.utils.cache.ACache;
import com.shopin.commonlibrary.utils.cache.ICache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;

/**
 * Created by zhiyicx on 2017/3/30.
 */
@Module
public class CacheModule {

    @Singleton
    @Provides
    CommonCache provideCommonService(RxCache rxCache) {
        return rxCache.using(CommonCache.class);
    }

    @Provides
    @Singleton
    ICache provideCache() {
        return ACache.get(CommonAppLike.getInstance().getApplication().getApplicationContext());
    }


}
