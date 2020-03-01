package com.king.commonlib.retrofit.Utils.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/***
 *项目名称：ARouteT
 *类描述:拦截请求结果
 *创建人：Android
 *创建时间：2019/7/30 15:26
 *修改人：Android
 */
public class ResultInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!TextUtils.isEmpty(response.body().toString())) {
            try {
                MediaType mediaType = response.body().contentType();
                String string = response.body().string();//这是请求返回的数据
                //如果返回的数据是加密的可以解密之后返回
                ResponseBody responseBody = ResponseBody.create(mediaType,string);
                return response.newBuilder().body(responseBody).build();
            } catch (Exception e) {
                e.printStackTrace();
                return response;
            }
        } else {
            return response;
        }
    }
}
