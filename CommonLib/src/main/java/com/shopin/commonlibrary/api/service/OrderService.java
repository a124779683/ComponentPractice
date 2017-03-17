package com.shopin.commonlibrary.api.service;

import com.shopin.commonlibrary.api.Api;
import com.shopin.commonlibrary.entity.AdvanceConfirmOrderEntity;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.entity.ConfirmOrderEntity;
import com.shopin.commonlibrary.entity.ConfirmOrderInitParam;
import com.shopin.commonlibrary.entity.OrderInitEntity;
import com.shopin.commonlibrary.entity.OrderStatusEntity;
import com.shopin.commonlibrary.entity.PaySignEntity;
import com.shopin.commonlibrary.entity.RefundApplyEntity;
import com.shopin.commonlibrary.entity.RefundDetailEntity;
import com.shopin.commonlibrary.entity.RefundInfoEntity;
import com.shopin.commonlibrary.entity.UploadImageEntity;
import com.shopin.commonlibrary.entity.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 存放订单API
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface OrderService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    @Headers({HEADER_API_VERSION})
    @GET("users")
    Observable<List<User>> getUsers(@Query("since") int lastIdQueried, @Query("per_page") int perPage);

    //  @Headers({HEADER_API_VERSION})    //1 支付宝  2微信
    @POST("pay/getSign/{outTradeNo}/{type}")
    Observable<BaseEntity<PaySignEntity>> getPaySign(@Path("outTradeNo") String outTradeNo, @Path("type") String type);

    /**
     * 支付完成后获取订单状态   查看是否支付成功
     *
     * @param outTradeNo
     * @param type
     * @return
     */
    @POST("pay/check/{outTradeNo}/{type}")
    Observable<BaseEntity<OrderStatusEntity>> getOrderStatus(@Path("outTradeNo") String outTradeNo, @Path("type") String type);


    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("getActivity")
    Observable<BaseEntity<OrderInitEntity>> initOrder(@Body ConfirmOrderInitParam body);

    /**
     * 运费测试接口
     *
     * @param jsonName
     * @return
     */
    @POST(Api.API_TEST + "order/{jsonName}")
    Observable<BaseEntity<OrderInitEntity>> testInitOrder(@Path("jsonName") String jsonName);


    /**
     * 预下单接口
     *
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("preCart")
    Observable<BaseEntity<AdvanceConfirmOrderEntity>> advanceConfirmOrder(@Body ConfirmOrderInitParam body);

    /**
     * 运费预下单接口 ，测试使用
     *
     * @param jsonName
     * @return
     */
    @POST(Api.API_TEST + "order/{jsonName}")
    Observable<BaseEntity<AdvanceConfirmOrderEntity>> testAdvanceConfirmOrder(@Path("jsonName") String jsonName);


    /**
     * 真正下单接口
     *
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("confirmOrder")
    Observable<BaseEntity<ConfirmOrderEntity>> confirmOrder(@Body ConfirmOrderInitParam body);

    /**
     * 真正下单接口 ，测试使用
     *
     * @param jsonName
     * @return
     */
    @POST(Api.API_TEST + "order/{jsonName}")
    Observable<BaseEntity<ConfirmOrderEntity>> testConfirmOrder(@Path("jsonName") String jsonName);


    @Multipart
    @POST()
    Observable<UploadImageEntity> uploadPicture(@Url String url, @Part MultipartBody.Part file);

    /**
     * 申请退货接口
     *
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("refund/createRefundOrder")
    Observable<BaseEntity<String>> applyRefund(@Body RefundApplyEntity body);

    /**
     * 输入退货运费接口
     *
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("refund/modifyRefundInfo")
    Observable<BaseEntity<String>> commitExpress(@Body RequestBody body);

    /**
     * 申请退货接口 ，测试使用
     *
     * @param jsonName
     * @return
     */
    @POST(Api.API_TEST + "order/{jsonName}")
    Observable<BaseEntity<String>> testApplyRefund(@Path("jsonName") String jsonName);

    /**
     * 退货详情接口
     *
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("refund/getRefundOrderByRefundNo")
    Observable<BaseEntity<RefundInfoEntity>> getRefundInfo(@Body RequestBody body);

    /**
     * 退货详情接口 ，测试使用
     *
     * @param jsonName
     * @return
     */
    @POST(Api.API_TEST + "order/{jsonName}")
    Observable<BaseEntity<RefundDetailEntity>> testGetRefundInfo(@Path("jsonName") String jsonName);
}
