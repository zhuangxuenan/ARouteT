package com.king.commonlib.retrofit.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/***
 *项目名称：ARouteT
 *类描述:创建RequestBody参数提供给@body使用
 *创建人：Android
 *创建时间：2019/7/30 16:31
 *修改人：Android
 */
public class ParamsSet {
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
}
