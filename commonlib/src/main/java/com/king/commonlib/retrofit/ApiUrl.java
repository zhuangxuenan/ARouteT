package com.king.commonlib.retrofit;

import com.king.commonlib.retrofit.bean.Article;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


public interface ApiUrl {
    /**首页文章列表
     *get请求，不带参数
     */
    @Headers("Accept:application/json")
    @GET("article/list/{page}/json")
    Observable<Article> article_list(@Path("page")int page);

    @Headers("Accept:application/json")
    @GET("banner/text")
    Observable<String> banner();
}
