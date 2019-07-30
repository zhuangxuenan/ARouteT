package com.king.commonlib.retrofit.Utils.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
/**
 * 请求体参数修改
 *
 *
 * Map<String, String> params = new HashMap<>();
 *  params.put("leaveType", leaveParams.getType());
 *  params.put("startDate", leaveParams.getTime_start());
 *  params.put("endDate", leaveParams.getTime_end());
 *  params.put("leaveReason", leaveParams.getRemarks());
 *  String obj = JSON.toJSONString(params);
 *  RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/text;charset=utf-8"), obj);
 */
public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();// 得到请求体
        Buffer buffer = new Buffer();// 创建缓存
        body.writeTo(buffer);//将请求体内容,写入缓
        String parameterStr = buffer.readUtf8();// 读取参数字符串
        if (!TextUtils.isEmpty(parameterStr)){
            //如果需要对请求体重新定义
            //对应请求头大伙按照自己的传输方式 定义
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/text;charset=utf-8"),parameterStr);
            request = request.newBuilder().post(requestBody).build();
        }
        return chain.proceed(request);
    }
}
