package com.shopin.commonlibrary.api.service;


import com.shopin.commonlibrary.api.Api;
import com.shopin.commonlibrary.entity.BaseEntity;
import com.shopin.commonlibrary.entity.BrandInfoEntity;
import com.shopin.commonlibrary.entity.FocusBrandRespEntity;
import com.shopin.commonlibrary.entity.IsFocusEntity;
import com.shopin.commonlibrary.entity.Mall;
import com.shopin.commonlibrary.entity.SaleAttributeNameVo;
import com.shopin.commonlibrary.entity.SearchRecordEntity;
import com.shopin.commonlibrary.entity.SearchResultEntity;
import com.shopin.commonlibrary.entity.TestGoods;
import com.shopin.commonlibrary.entity.TestMall;
import com.shopin.commonlibrary.entity.UploadImgEntity;
import com.shopin.commonlibrary.entity.WrapAddressApiEntity;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 存放通用的一些API
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface CommonService {

    /**
     * 热词接口
     * @return
     * @param body
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("keyword")
    Observable<BaseEntity<List<SearchRecordEntity>>> getHotTag(@Body RequestBody body);

    /**
     * 获取热门标签，测试
     * @return
     */
    @GET(Api.API_TEST + "search/{jsonName}")
    Observable<BaseEntity<List<SearchRecordEntity>>> testHotTag(@Path("jsonName") String jsonName);

    /**
     * 获取热门标签
     * @return
     */
    @GET(Api.API_TEST + "search/{jsonName}")
    Observable<BaseEntity<SearchResultEntity>> testSearchResult(@Path("jsonName") String jsonName);


    /**
     * 1.8门店-获取所有门店
     * @return
     */
    @GET("ssdservice/photo/queryShopInfo.html")
    Observable<BaseEntity<List<Mall>>> getShopInfo();

    /**
     * 1.8门店-获取所有门店(测试使用)
     * @return
     */
    @GET(Api.API_TEST + "mall")
    Observable<TestMall> testShopInfo();

    /**
     * 搜索结果接口
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("search")
    Observable<BaseEntity<SearchResultEntity>> getSearchResultList(@Body RequestBody body);

    /**
     * 搜索结果接口（测试使用）
     * @param url
     * @return
     */
    @GET
    Observable<TestGoods> getSearchResultList(@Url String url);

    @GET("user/version")
    Observable<BaseEntity<String>> getVersionInfo();


    @GET("user/version")
    Observable<BaseEntity<List<SaleAttributeNameVo>>> getFilterData();

    /**
     * 获取省市区数据
     * @return
     */
    @FormUrlEncoded
    @POST("getProvinces")
    Observable<WrapAddressApiEntity> getAddress(@Field("field") String field);

    /**
     * 只支持单张图片上传
     * @param images
     * @return
     */
    @Multipart
    @POST("refund/uploadFile")
    Observable<BaseEntity<UploadImgEntity>> uploadImages(@Part MultipartBody.Part images);

    /**
     * 获取品牌信息
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("ssdservice/app/getBrandById")
    Observable<BaseEntity<BrandInfoEntity>> getBrandInfo(@Body RequestBody body);

    /**
     * 检查是否关注
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/brand/checkExist")
    Observable<BaseEntity<IsFocusEntity>> checkIsFocus(@Body RequestBody body);

    /**
     * 关注品牌
     * @param body
     * @return
     */
    @Headers({Api.CONTENT_TYPE_JSON})
    @POST("favorite/brand/addFavoriteBrand")
    Observable<BaseEntity<FocusBrandRespEntity>> focusBrand(@Body RequestBody body);

    /**
     * 测试关注品牌
     * @return
     */
    @GET(Api.API_TEST + "order/delcartitem")
    Observable<BaseEntity<String>> testfocusBrand();
}
