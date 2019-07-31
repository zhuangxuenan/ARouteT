package com.king.commonlib.retrofit.Utils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/***
 *项目名称：ARouteT
 *类描述:创建RequestBody参数提供给@body使用
 *创建人：Android
 *创建时间：2019/7/30 16:31
 *修改人：Android
 */
//如果参数是请求体 可以通过@Body注解 传入一个对象或者map 然后将其转成json
//RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), "json字符串");//可能不支持
//RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), bodyStr);
//RequestBody body = RequestBody.create(MediaType.parse("application/text;charset=utf-8"), "加密串");
public class ParamsSet {
    //通过body表单提交参数 相当于Field
    public RequestBody getRequestBody(HashMap<String, String> hashMap) {
        StringBuffer data = new StringBuffer();
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append("&");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), jso);
        return requestBody;
    }
    public FormBody getFormBody(HashMap<String, String> hashMap) {
        FormBody.Builder builder = new FormBody.Builder();
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                builder.add(key,val);
            }
        }
        return builder.build();
    }
    //通过body提交请求体json请求体
    public RequestBody getRequestBody2(HashMap<String, String> hashMap) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),new Gson().toJson(hashMap));
        return requestBody;
    }
    //通过body提交请求体文本请求体
    public RequestBody getRequestBody3(HashMap<String, String> hashMap) {
        String json = new Gson().toJson(hashMap);
        //将json转成某种加密文本
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/text;charset=utf-8"),json);
        return requestBody;
    }
}
