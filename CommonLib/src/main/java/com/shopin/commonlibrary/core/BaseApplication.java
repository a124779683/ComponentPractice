package com.shopin.commonlibrary.core;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author jianghongbo
 * @version 1.0
 * @file BaseApplication.java
 * @brief 请勿修改此类！
 * @date 2017/3/16
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class BaseApplication extends TinkerApplication {

    /**
     * 这个方法只提供给组件APPLICATION继承使用，其他人勿用
     */
    public BaseApplication() {
        super(
                //tinkerFlags, tinker支持的类型，dex,library，还是全部都支持！
                ShareConstants.TINKER_ENABLE_ALL,
                //ApplicationLike的实现类，只能传递字符串,不能使用class.getName()
                "com.shopin.commonlibrary.core.CommonAppLike",
                //加载Tinker的主类名，对于特殊需求可能需要使用自己的加载类。需要注意的是：
                //这个类以及它使用的类都是不能被补丁修改的，并且我们需要将它们加到dex.loader[]中。
                //一般来说，我们使用默认即可。
                "com.tencent.tinker.loader.TinkerLoader",
                //由于合成过程中我们已经校验了各个文件的Md5，并将它们存放在/data/data/..目录中。
                // 默认每次加载时我们并不会去校验tinker文件的Md5,但是你也可通过开启loadVerifyFlag强制每次加载时校验，
                // 但是这会带来一定的时间损耗。
                false);
    }

    public BaseApplication(int tinkerFlags, String delegateClassName, String loaderClassName, boolean tinkerLoadVerifyFlag) {
        super(tinkerFlags, delegateClassName, loaderClassName, tinkerLoadVerifyFlag);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
