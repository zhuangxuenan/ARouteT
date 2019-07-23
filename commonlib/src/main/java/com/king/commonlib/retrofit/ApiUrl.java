package com.king.commonlib.retrofit;

import com.king.commonlib.retrofit.bean.Article;
import com.king.commonlib.retrofit.bean.BannerModel;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiUrl {
    /**首页文章列表
     *get请求，不带参数
     */
    @Headers("Accept:application/json")
    @GET("article/list/{page}/json")
    Observable<Article> article_list(@Path("page")int page);

    @GET("banner/text")
    Observable<BannerModel> banner();
    @POST("dfgdg/gdfgd")
    Observable<String> gggg(@Body Object A);

}
