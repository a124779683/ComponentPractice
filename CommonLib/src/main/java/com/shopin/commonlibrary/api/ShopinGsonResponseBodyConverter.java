/*
 * Copyright (C) 2017 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shopin.commonlibrary.api;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class ShopinGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    ShopinGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //可以在这里通过异常的方式处理，也可以通过工具类统一的map变换一下。
//        String response = value.string();
//        ResultEntity result = gson.fromJson(response, ResultEntity.class);
//        if (result != null && !result.isValidate(result.code)) {
//            value.close();
//            ResultException resultException = new ResultException(result.errorMessage);
//            resultException.setResultCode(result.code);
//            resultException.setErrorMessage(result.errorMessage);
//            throw resultException;
//        }

        //这里我们可以考虑直接T extentd BaseEntity 然后返回那个data
        //返回正常结果
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
