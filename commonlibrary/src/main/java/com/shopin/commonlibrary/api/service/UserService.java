package com.shopin.commonlibrary.api.service;

import com.shopin.commonlibrary.api.Api;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.entity.BrandAttentionEntity;
import com.shopin.commonlibrary.entity.CartItemsEntity;
import com.shopin.commonlibrary.entity.DeliveryAddressEntity;
import com.shopin.commonlibrary.entity.FeedBackEntity;
import com.shopin.commonlibrary.entity.GoodsCollectData;
import com.shopin.commonlibrary.entity.IntegralRecordEntity;
import com.shopin.commonlibrary.entity.LoginResultEntity;
import com.shopin.commonlibrary.entity.OwnerEntity;
import com.shopin.commonlibrary.entity.SignBaseBody;
import com.shopin.commonlibrary.entity.UserEntity;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 存放关于用户的一些api
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface UserService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";


    @POST("selectMemberInfoBySid/{memberSid}")
    Observable<BaseEntity<UserEntity>> getUsers(@Path("memberSid") String memberSid);

    /**
     * PostJSON
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST("member/mobileLogin")
    Observable<BaseEntity<LoginResultEntity>> login(@Body RequestBody account);


    /**
     * 获取验证码
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST("member/getCode")
    Observable<BaseEntity<String>> getVerificationCode(@Body RequestBody account);

    /**
     * 获取收货地址
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("member/address/listAddress")
    Observable<BaseEntity<List<DeliveryAddressEntity>>> getAddress(@Body RequestBody body);

    /**
     * 测试收货地址
     * @return
     */
    @GET(Api.API_TEST + "user/{jsonName}")
    Observable<BaseEntity<List<DeliveryAddressEntity>>> testAddress(@Path("jsonName") String jsonName);

    /**
     * 保存收货地址
     * @param address
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("address/saveAddress")
    Observable<BaseEntity<DeliveryAddressEntity>> saveAndUpdateAddress(
            @Body RequestBody address);

    /**
     * 删除收货地址
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("address/deleteAddress")
    Observable<BaseEntity<String>> delAddress(@Body RequestBody body);

    /**
     * 商品收藏
     * PostJSON
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/product/selectList")
    Observable<BaseEntity<GoodsCollectData>> getGoodsCollectList(@Body RequestBody body);

    /**
     * 品牌关注
     * PostJSON
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/brand")
    Observable<BaseEntity<List<BrandAttentionEntity>>> getBrandAttentionList(@Body RequestBody body);

    /**
     * 取消品牌关注
     * PostJSON
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/brand/deleteFavoriteBrand")
    Observable<BaseEntity<String>> cancelAttentionBrand(@Body RequestBody body);

    /**
     * 取消商品收藏
     * PostJSON
     *
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/product/deleteFavoriteProduct")
    Observable<BaseEntity<String>> cancelGoodsCollect(@Body RequestBody body);

    /**
     * 取消品牌关注
     * PostJSON
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/brand/addFavoriteBrand")
    Observable<BaseEntity<String>> AttentionBrand(@Body RequestBody body);

    /**
     * 获取积分记录
     * PostJSON
     * @return
     */
    @GET("member/getCode")
    Observable<BaseEntity<List<IntegralRecordEntity>>> getIntegralList(@Query("page") int currPage);


    /**
     * 获取购物车数据 ，测试数据 需要修改入参 Path
     * @return
     */
    @GET("mobile/wsgCartShowBJ/{memberSid}/{mobile}")
    Observable<BaseEntity<List<CartItemsEntity>>> getShoppincart(@Path("memberSid") String memberSid, @Path("mobile") String mobile);

    /**
     * 获取购物车数据 ，测试数据
     * @return
     */
    @GET(Api.API_TEST + "{jsonName}")
    Observable<BaseEntity<List<CartItemsEntity>>> testShoppincart(@Path("jsonName") String jsonName);

    /**
     * 反馈消息
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST()
    Observable<FeedBackEntity> feedBack(@Url String url, @Body RequestBody body);

    /**
     * 删除购物车数据
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("mobile/removeWsgCart")
    Observable<BaseEntity<String>> delCartItem(@Body RequestBody body);

    /**
     * 删除收货地址
     * @return
     */
    @GET(Api.API_TEST + "order/{delcartitem}")
    Observable<BaseEntity<String>> testDelCartItem(@Path("delcartitem") String jsonName);

    /**
     * 删除收货地址
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("member/savePersonalOfWechat")
    Observable<BaseEntity<String>> savePersonalInfo(@Body RequestBody body);

    /**
     * 获取用户签到的数据
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST()
    Observable<SignBaseBody> getPersonalSignData(@Url String url, @Body RequestBody body);

    /**
     * 用户签到
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST()
    Observable<SignBaseBody> userSignDate(@Url String url, @Body RequestBody body);


    /**
     * 改绑手机号时验证code是否填写正确
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("member/checkCode")
    Observable<BaseEntity<String>> checkCode(@Body RequestBody body);

    /**
     * 改绑到新的手机号
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("member/replaceMobileForWeChat")
    Observable<BaseEntity<String>> replaceMobile(@Body RequestBody body);

    /**
     * 获取小能聊天的客服组id
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("service/id")
    Observable<BaseEntity<String>> getChatParams();

    /**
     * 获取我的界面数据
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("order/getOrderListCount")
    Observable<BaseEntity<OwnerEntity>> getOwnerData(@Body RequestBody body);

}
