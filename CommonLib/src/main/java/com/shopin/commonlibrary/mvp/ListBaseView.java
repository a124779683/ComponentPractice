package com.shopin.commonlibrary.mvp;

import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file ListBaseView.java
 * @brief
 * @date 2017/12/27
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public interface ListBaseView<T> extends BaseView {

    void renderList(List<T> list, boolean isRefresh);

    void refreshWrong();

    void loadWrong();
}
