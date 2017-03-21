package com.shopin.commonlibrary.api;

import com.jhb.util.AppUtil;
import com.jhb.util.StringUtils;
import com.shopin.commonlibrary.core.CommonAppLike;

import java.io.File;

/**
 * 主要定义与服务器交互的主要参数
 */
public class Api {
    //主机地址
    public final static String APP_HOST = "http://172.16.103.145:9002/";
//        public final static String APP_HOST = "http://172.16.102.77:8080/";
    //只有在达人时用到的地址
    public final static String APP_HOST_TALENT = "http://192.168.205.132:9002/";
    //图片主机，图片拼接规则 HOST+{proPictDir}+{proPictName}
    public final static String IMAGE_HOST = "http://images.shopin.net/images";
    //测试数据文件位置
    public final static String API_TEST = "api/test/";

    //首页地址
    public final static String SUFFIX_H5_URL = "http://172.16.103.145:9002/h5/";
    public final static String SUFFIX_CMS_URL = "http://172.16.200.2/";
    //! H5 example:http://172.16.103.145:9002/h5/v1_0_0/html
    public static final String BASE_H5_URL = StringUtils.concat(SUFFIX_H5_URL,
            "v", AppUtil.getVersionName(CommonAppLike.getContext()).replace(".", "_")
            , File.separator, "html", File.separator);

    public final static String MALE_STYLE = StringUtils.concat(SUFFIX_CMS_URL, "index.html");
    public final static String FEMALE_STYLE = StringUtils.concat(SUFFIX_CMS_URL, "index_wm.html");
    public final static String CHILD_STYLE = StringUtils.concat(SUFFIX_CMS_URL, "index_kid.html");
    //门店对应的地址
    public final static String MALL_LGY = "http://news.baidu.com/";
    public final static String MALL_WFJ = "http://www.baidu.com/";
    public final static String MALL_WKS = "http://news.baidu.com/";
    public final static String MALL_SLH = "http:/www.sina.com.cn/";

    //帖子发布评论
    public final static String PUBLISH_COMMENT = StringUtils.concat(APP_HOST_TALENT, "fashion/commentInvitation");
    //获取帖子详情
    public final static String GETINVITATIONINFO = StringUtils.concat(APP_HOST_TALENT, "fashion/getInvitationInfo");
    //发布 上传图片
    public final static String RELASEINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/relaseInvitation");
    //达人的发布
    public final static String PUBLICINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/publicInvitation");
    //点赞
    public final static String PRAISEINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/publicInvitation");
    //取消点赞
    public final static String CANCELPRAISE = StringUtils.concat(APP_HOST_TALENT, "fashion/cancelPraise");
    //关注
    public final static String ATTENTIONINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/attentionInvitation");
    //取消关注
    public final static String CANCELATTENTION = StringUtils.concat(APP_HOST_TALENT, "fashion/cancelAttention");
    //修改帖子
    public final static String UPDATEINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/updateInvitation");
    //帖子的删除
    public final static String DELETEINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/deleteInvitation");
    //获取帖子分享到第三方需要的资料
    public final static String SHARESANINVITATION = StringUtils.concat(APP_HOST_TALENT, "fashion/shareSanInvitation");
    //用户签到
    public final static String ADDDAILYSIGN = StringUtils.concat(APP_HOST_TALENT, "member/addDailysign");
    //获取用户本月所有的签到信息
    public final static String GETDAILYSIGN = StringUtils.concat(APP_HOST_TALENT, "member/getDailysign");
    //意见反馈接口
    public final static String ADDFEEDBACK = StringUtils.concat(APP_HOST_TALENT, "member/addFeedback");


    //商品详情
    public static final String H5_GOOD_DETAIL = StringUtils.concat(BASE_H5_URL + "goodsDetail.html?productSid=%1$s&supplySid=%2$s&channelMark=%3$s& optUserName=%4$s");
    //待支付
    public static final String H5_ORDER_UNPAY = StringUtils.concat(BASE_H5_URL + "order.html?k=waitpay");
    //待提货
    public static final String H5_ORDER_UNRECEIVER = StringUtils.concat(BASE_H5_URL + "order.html?k=waitpick");
    //配送中
    public static final String H5_ORDER_ONTHEWAY = StringUtils.concat(BASE_H5_URL + "order.html?k=delivering");
    //全部订单
    public static final String H5_ORDER_ALL = StringUtils.concat(BASE_H5_URL + "order.html?k=allorder");
    //退货订单
    public static final String H5_ORDER_REFUND = StringUtils.concat(BASE_H5_URL + "refundOrder.html");
    //订单回收站
    public static final String H5_ORDER_RECYCLE = StringUtils.concat(BASE_H5_URL + "order.html?k=recycle");
    //积分
    public static final String H5_JIFEN = StringUtils.concat(BASE_H5_URL + "jifen.html");
    //我的券
    public static final String H5_MY_COUPON = StringUtils.concat(BASE_H5_URL + "myCoupon.html");
    //领取券
    public static final String H5_GET_COUPON = StringUtils.concat(BASE_H5_URL + "getCoupon.html");
    //关于
    public static final String H5_ABOUT = StringUtils.concat(BASE_H5_URL + "about.html");
    //帮助中心
    public static final String H5_HELP = StringUtils.concat(BASE_H5_URL + "help.html");
}
