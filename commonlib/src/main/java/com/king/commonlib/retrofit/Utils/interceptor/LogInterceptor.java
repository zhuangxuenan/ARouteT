package com.king.commonlib.retrofit.Utils.interceptor;

import com.king.commonlib.utils.AppLogMessageMgr;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 *  TODO Log拦截器代码
 */
public class LogInterceptor implements Interceptor{
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        AppLogMessageMgr.e("request:-----" + request.toString());
        long t1 = System.nanoTime();
        okhttp3.Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        AppLogMessageMgr.e(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        AppLogMessageMgr.e("response body:------------" + content);
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
