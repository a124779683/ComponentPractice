package com.shopin.commonlibrary.mvp;

import rx.Subscription;

public interface presenter {
    void onStart();
    void onDestroy();
    void unSubscribe(Subscription subscription);
}
