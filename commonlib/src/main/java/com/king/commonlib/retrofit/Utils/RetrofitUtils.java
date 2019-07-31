package com.king.commonlib.retrofit.Utils;


import android.text.TextUtils;

import com.king.commonlib.BuildConfig;
import com.king.commonlib.retrofit.ApiUrl;
import com.king.commonlib.retrofit.Constans;
import com.king.commonlib.utils.AppLogMessageMgr;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Retrofit封装
 */
public class RetrofitUtils {
    private static ApiUrl mApiUrl;
    /**
     * 单例模式
     */
    public static ApiUrl getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }
    private RetrofitUtils(){}
    public ApiUrl getRetrofit() {
        // 初始化Retrofit
        ApiUrl apiUrl = initRetrofit(initOkHttp()).create(ApiUrl.class);
        return apiUrl;
    }
    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constans.BaseUrl)
                    //如果返回为Call那么可以不添加这个配置。如果使用Observable那就必须添加这个配置。否则就会请求的时候就会报错！
                    //http://blog.csdn.net/new_abc/article/details/53021387
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//支持rxjava2 返回Observable
                    //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持rxjava 返回Call
                    .addConverterFactory(ScalarsConverterFactory.create())
                    //这个配置是将服务器返回的json字符串转化为对象
                    //https://www.jianshu.com/p/5b8b1062866b
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        // Debug时才设置Log拦截器，才可以看到
        HttpLoggingInterceptor interceptor = null;
        if (BuildConfig.DEBUG) {
            interceptor = new HttpLoggingInterceptor(
                    // 添加json数据拦截
                    message -> {
                        if (TextUtils.isEmpty(message)) {
                            return;
                        }
                        AppLogMessageMgr.e(message);
                    }
            );
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return new OkHttpClient().newBuilder()
                    .readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                    .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                    .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                    //.addInterceptor(new AddHeadInterceptor())//添加请求头拦截器
                    .addInterceptor(interceptor)
                    //.addInterceptor(new LogInterceptor())//添加打印拦截器
                    .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                    .build();
    }
}

