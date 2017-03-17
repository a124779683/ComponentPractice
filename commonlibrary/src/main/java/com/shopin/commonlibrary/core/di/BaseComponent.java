package com.shopin.commonlibrary.core.di;


import com.shopin.commonlibrary.core.CommonAppLike;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jess on 14/12/2017 13:58
 * Contact with jess.yan.effort@gmail.com
 */
@Singleton
@Component(modules={AppModule.class})
public interface BaseComponent {
    void inject(CommonAppLike application);
}
