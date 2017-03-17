package ir.mirrajabi.okhttpjsonmock.models;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class MockedResponse {

    public boolean success;
    @SerializedName("errorMessage")
    public String errorMessage;
    @SerializedName("code")
    String code;
    @SerializedName("data")
    LinkedTreeMap data;
    @SerializedName("status")
    int mStatusCode;

    public LinkedTreeMap getData() {
        return data;
    }

    public MockedResponse setData(LinkedTreeMap response) {
        data = response;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MockedResponse setCode(String statusCode) {
        code = statusCode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public MockedResponse setStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
        return this;
    }
}
