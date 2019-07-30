package com.king.commonlib.retrofit;

import com.king.commonlib.retrofit.Utils.BaseResponse;
import com.king.commonlib.retrofit.bean.Article;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

//如果参数是请求体 可以通过@Body注解 传入一个对象或者map 然后将其转成json
//RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), "json字符串");
//RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), bodyStr);
//RequestBody body = RequestBody.create(MediaType.parse("application/text;charset=utf-8"), "加密串");
//@Field & @FieldMap与@FormUrlEncoded配合使用
/**
 * 注解使用 https://blog.csdn.net/carson_ho/article/details/73732076
 *
 * */
public interface ApiUrl {
    /**首页文章列表
     *get请求，不带参数
     */
    //@Headers("Accept:application/json")
    @GET("article/list/{page}/json")
    Observable<BaseResponse<Article>>article_list(@Path("page")int page);
}
