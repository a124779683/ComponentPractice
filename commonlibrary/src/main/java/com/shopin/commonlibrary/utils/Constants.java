package com.shopin.commonlibrary.utils;

import android.support.annotation.IntDef;

import com.shopin.commonlibrary.entity.HomeStyleEntity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * @author jianghongbo
 * @version 1.0
 * @file Constants.java
 * @brief
 * @date 2017/2/10
 * Copyright (c) 2017, 上品折扣
 * All rights reserved.
 */
public class Constants {

    @IntDef({HOME_MALE_STYLE, HOME_FEMALE_STYLE, HOME_CHILD_STYLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ThemeStyle {
    }


    /**
     * 线上
     */
    public static final String INLINE = "2";

    //主题样式
    public static final int HOME_MALE_STYLE = 1;
    public static final int HOME_FEMALE_STYLE = 2;
    public static final int HOME_CHILD_STYLE = 3;
    //门店类型
    public static final int MALL_LGY = 1;
    public static final int MALL_WFJ = 2;
    public static final int MALL_WKS = 3;
    public static final int MALL_SLH = 4;

    //反馈类型
    public static final String FEEDBACK_SHOPPING = "51";
    //反馈类型--门店问题
    public static final String FEEDBACK_MALL = "52";
    //反馈类型--发现关注
    public static final String FEEDBACK_OTHER = "53";
    //强制更新标记
    public static final String FORCE_UPDATE = "1";
    public static final String NO_FORCE_UPDATE = "0";
    //! 下载APP任务类型
    public static final int TASK_APP = 1;
    //! 默认收货地址的标记
    public static final String DEFAULT_RECEIVER_TAG = "0";
    //! 不是默认收货地址的标记
    public static final String UNDEFAULT_RECEIVER_TAG = "1";
    //! 自提的标记
    public static final String EXPRESS_TYPE_SELF_GET = "0";


    //小能 企业id
    public static final String SITE_ID = "kf_9429";
    // 小能 sdkkey: 企业key，即小能通行密钥【必填】
    public static final String SDK_KEY = "88397471-0747-4A58-A3D8-33DDC6D73273";
    //测试的settingid  接待组id  测试的时候用
    public static final String DEBUG_SETTINGID = "kf_9429_1487562734950";
    //正式的settingid  接待组id  上线的时候改到正式的接待组id
    public static final String SETTINGID = "kf_9429_1487562734950";

    public static final String WEIXIN_APPID = "wx0265d4625a206cee";


    private static List<HomeStyleEntity> malls;

//    public static List<HomeStyleEntity> getMalls() {
//        if (malls == null) {
//            malls = new ArrayList<>();
//            malls.add(new HomeStyleEntity(MALL_LGY, ResourceUtil.getString(R.string.laiguangying)));
//            malls.add(new HomeStyleEntity(MALL_WFJ, ResourceUtil.getString(R.string.wangfujing)));
//            malls.add(new HomeStyleEntity(MALL_WKS, ResourceUtil.getString(R.string.wukesong)));
//            malls.add(new HomeStyleEntity(MALL_SLH, ResourceUtil.getString(R.string.sanlihe)));
//        }
//        return malls;
//    }
//
//    private static List<HomeStyleEntity> homeStyles;
//
//    public static List<HomeStyleEntity> getHomeStyle() {
//        if (homeStyles == null) {
//            homeStyles = new ArrayList<>();
//            homeStyles.add(new HomeStyleEntity(HOME_MALE_STYLE, ResourceUtil.getString(R.string.male)));
//            homeStyles.add(new HomeStyleEntity(HOME_FEMALE_STYLE, ResourceUtil.getString(R.string.female)));
//            homeStyles.add(new HomeStyleEntity(HOME_CHILD_STYLE, ResourceUtil.getString(R.string.child)));
//        }
//        return homeStyles;
//    }
//
//    private static Map<Integer, UploadIdEntity> refundReason;
//
//    /**
//     * 退货原因，用于退款之外的情况
//     * @return
//     */
//    public static Map<Integer, UploadIdEntity> getRefundReason(boolean afterReceive) {
//        if (refundReason == null) {
//            refundReason = new TreeMap<>();
//            refundReason.put(0, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_cpbxh), 5));
//            refundReason.put(1, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_cpbhs), 6));
//            if (afterReceive) {
//                refundReason.put(2, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_zlwt), 8));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_cpzc), 9));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_fccm), 10));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_fcsp), 11));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_xxcw), 13));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_yjsbfh), 15));
//                refundReason.put(3, new UploadIdEntity(ResourceUtil.getString(R.string.refund_reason_spj), 16));
//                refundReason.put(9, new UploadIdEntity(ResourceUtil.getString(R.string.other), 14));
//            }
//        }
//        return refundReason;
//    }

}
