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
     * addConverterFactory是有先后顺序的，如果有多个ConverterFactory都支持同一种类型，
     * 那么就是只有第一个才会被使用，而GsonConverterFactory是不判断是否支持的，所以这里交换顺序会有异常抛出，原因是类型不匹配。
     * 如是有Gson这类的Converter一定要放在其它前面
     * Retrofit.Builder中的所有方法：
     *
     * baseUrl(String baseUrl) 和 baseUrl(okhttp3.HttpUrl baseUrl)
     *
     * 对Call<T>中T的进行类型转换
     * addConverterFactory(retrofit2.Converter.Factory factory)
     *
     * 对Call进行转换
     * addCallAdapterFactory(retrofit2.CallAdapter.Factory factory)
     *
     * 指定Call.enqueue时使用的Executor，所以该设置只对返回值为Call的方法有效
     * callbackExecutor(java.util.concurrent.Executor executor)
     *
     * 设置一个自定义的okhttp3.Call.Factory，那什么是Factory呢？OkHttpClient就实现了此接口。
     * 如果你需要对okhttpclient进行详细的设置，需要构建OkHttpClient对象，然后通过callFactory方法传入，
     * 否则new一个默认的OkHttpClient。下面的client方法最终也是调用了该方法，所有两者不能共用
     * callFactory(okhttp3.Call.Factory factory)
     *
     * 设置自定义的OkHttpClient，以前的Retrofit版本中，不同的Retrofit对象共同OkHttpClient，
     * 在2.0后，各对象各自持有不同的OkHttpClient实例，所以当你需要共用OkHttpClient或需要自定义时则可以使用该方法，
     * 如：处理Cookie、使用stetho调式等
     * client(OkHttpClient client)
     *
     * 是否在调用create(Class)时检测接口定义是否正确，而不是在调用方法才检测。适合在开发、测试时使用
     * validateEagerly(boolean validateEagerly)
     *
     ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆-☆
     ☆        Retrofit提供的Converter                                            ☆
     ☆        Gson 	        com.squareup.retrofit2:converter-gson:2.0.2          ☆
     ☆        Jackson 	    com.squareup.retrofit2:converter-jackson:2.0.2       ☆
     ☆        Moshi 	    com.squareup.retrofit2:converter-moshi:2.0.2         ☆
     ☆        Protobuf 	    com.squareup.retrofit2:converter-protobuf:2.0.2      ☆
     ☆        Wire 	        com.squareup.retrofit2:converter-wire:2.0.2          ☆
     ☆        Simple XML 	com.squareup.retrofit2:converter-simplexml:2.0.2     ☆
     ☆        Scalars 	    com.squareup.retrofit2:converter-scalars:2.0.2       ☆
     ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆-☆
     ☆        Retrofit提供的CallAdapter                                          ☆
     ☆        guava 	        com.squareup.retrofit2:adapter-guava:2.0.2       ☆
     ☆        Java8 	        com.squareup.retrofit2:adapter-java8:2.0.2       ☆
     ☆        rxjava 	        com.squareup.retrofit2:adapter-rxjava2:2.0.2     ☆
     ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆-☆
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constans.BaseUrl)
                    //如果返回为Call那么可以不添加这个配置。如果使用Observable那就必须添加这个配置。否则就会请求的时候就会报错！
                    //http://blog.csdn.net/new_abc/article/details/53021387
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//支持rxjava2 返回Observable
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

