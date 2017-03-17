package ir.mirrajabi.okhttpjsonmock.interceptors;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.util.Random;

import ir.mirrajabi.okhttpjsonmock.helpers.ResourcesHelper;
import ir.mirrajabi.okhttpjsonmock.models.MockedResponse;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpMockInterceptor implements Interceptor {
    private Context mContext;
    private int mFailurePercentage;
    private String mBasePath;

    public OkHttpMockInterceptor(Context context, int failurePercentage) {
        this(context, failurePercentage, "");
    }

    public OkHttpMockInterceptor(Context context, int failurePercentage, String basePath) {
        mContext = context;
        mFailurePercentage = failurePercentage;
        mBasePath = basePath;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Gson gson = new GsonBuilder().setLenient().create();
        HttpUrl url = chain.request().url();
        String sym = "";
        String query = url.encodedQuery() == null ? "" : url.encodedQuery();
        if (!query.equals(""))
            sym = "/";
        String path = url.encodedPath() + sym + query;
        String responseString = ResourcesHelper.loadAssetTextAsString(mContext,
                mBasePath + path.substring(1).toLowerCase() + ".json");
        if (responseString == null)
            responseString = ResourcesHelper.loadAssetTextAsString(mContext,
                    mBasePath + url.encodedPath().substring(1).toLowerCase() + ".json");
        MockedResponse mockedResponse = new MockedResponse()
                .setData(new LinkedTreeMap())
                .setStatusCode(200);
//        if (responseString != null) {
//            try {
//                mockedResponse = gson.fromJson(responseString, MockedResponse.class);
//            } catch (JsonSyntaxException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        //直接把JSON格式返回就好了
//        JsonObject jsonObject = gson.toJsonTree(mockedResponse.getData()).getAsJsonObject();
//        String result = jsonObject.toString();
//        JsonArray items = jsonObject.getAsJsonArray("items");
//        if (items != null) {
//            result = gson.toJson(items);
//        }
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 1500) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean failure = Math.abs(new Random().nextInt() % 100) < mFailurePercentage;
        int code = failure ? 504 : mockedResponse.getStatusCode(); /*504 or 408*/
        if (failure)
            Log.e("JsonMockServer", "Returning result from " +
                    path + "\t\tStatusCode : " + code);
        else
            Log.v("JsonMockServer", "Returning result from " +
                    path + "\t\tStatusCode : " + code);

        return new Response.Builder()
                .code(code)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString))
                .addHeader("content-type", "application/json")
                .build();
    }
}