package com.king.commonlib.retrofit.Utils.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/***
 *项目名称：ARouteT
 *类描述:请求头拦截器
 *创建人：Android
 *创建时间：2019/7/30 13:49
 *修改人：Android
 * https://blog.csdn.net/jdsjlzx/article/details/52063950
 * https://blog.csdn.net/weixin_37577039/article/details/79495797
 * 一个第三方拦截器，可以设置请求头等参数
 * https://github.com/jkyeo/okhttp-basicparamsinterceptor
 */
public class AddHeadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest  = chain.request();
            Request.Builder builder = originalRequest
                    .newBuilder();
                    //builder.addHeader("Content-Type", "application/text;charset=utf-8");
                    //builder.addHeader("xxx","");
                    Request.Builder requestBuilder =builder.method(originalRequest.method(), originalRequest.body());
                    Request request = requestBuilder.build();
            return chain.proceed(request);
    }
}
