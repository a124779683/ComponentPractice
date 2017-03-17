package com.shopin.commonlibrary.api.service;

import com.shopin.commonlibrary.api.Api;
import com.shopin.commonlibrary.entity.CommentListEntity;
import com.shopin.commonlibrary.entity.CommentResultEntity;
import com.shopin.commonlibrary.entity.PraiseResultEntity;
import com.shopin.commonlibrary.entity.PublishTalentEntity;
import com.shopin.commonlibrary.entity.TalentDetailEntity;
import com.shopin.commonlibrary.entity.TalentListEntity;
import com.shopin.commonlibrary.entity.TalentShareEntity;
import com.shopin.commonlibrary.entity.UploadImageEntity;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by zq on 2017/1/26.
 */
public interface TalentService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    /**
     * 获取所有的达人列表
     *
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<TalentListEntity> getTalentList(@Url String url, @Body RequestBody account);

    /**
     * 获取用户关注过的达人列表
     * PostJSON
     *
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<TalentListEntity> getUserAttentionTalentList(@Url String url, @Body RequestBody body);

    /**
     * PostJSON
     * 获取评论列表
     *
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<CommentListEntity> getCommentList(@Url String url, @Body RequestBody body);

    /**
     * PostJSON
     * 发布评论
     *
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<CommentResultEntity> PublishComment(@Url String url, @Body RequestBody account);

    /**
     * PostJSON
     * 获取详情
     *
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<TalentDetailEntity> getTalentShareDetail(@Url String url, @Body RequestBody account);


    /**
     * 上传图片
     *
     * @return
     */
    @Multipart
    @POST()
    Observable<UploadImageEntity> uploadPicture(@Url String url, @Part MultipartBody.Part file);


    /**
     * PostJSON  达人发布
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PublishTalentEntity> publishTalent(@Url String url, @Body RequestBody account);

    /**
     * PostJSON  点赞
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PraiseResultEntity> Praise(@Url String url, @Body RequestBody account);

    /**
     * PostJSON  点赞
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PraiseResultEntity> CancelPraise(@Url String url, @Body RequestBody account);


    /**
     * PostJSON  关注
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PraiseResultEntity> Attention(@Url String url, @Body RequestBody account);


    /**
     * PostJSON  取消关注
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PraiseResultEntity> cancelAttention(@Url String url, @Body RequestBody account);

    /**
     * PostJSON  修改帖子
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PublishTalentEntity> updateInvitation(@Url String url, @Body RequestBody account);
    /**
     * PostJSON  删除帖子
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<PublishTalentEntity> deleteInvitation(@Url String url, @Body RequestBody account);


    /**
     * PostJSON  获取当前用户所有发布的帖子
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<TalentListEntity> getMemberInvitations(@Url String url, @Body RequestBody account);

    /**
     * PostJSON    获取分享到第三方需要的内容
     *
     * @param account
     * @param
     * @return
     */
    @Headers(Api.CONTENT_TYPE_JSON)
    @POST()
    Observable<TalentShareEntity> getShareData(@Url String url, @Body RequestBody account);


}
