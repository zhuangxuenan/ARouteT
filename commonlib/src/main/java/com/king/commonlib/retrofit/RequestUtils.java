package com.king.commonlib.retrofit;

import android.content.Context;

import com.king.commonlib.retrofit.Utils.CusObserver;
import com.king.commonlib.retrofit.Utils.RetrofitUtils;
import com.king.commonlib.retrofit.Utils.RxHelper;
import com.king.commonlib.retrofit.bean.Article;

/**
 * https://www.jianshu.com/p/f23be7f8cb93
 * 提交参数方式
 */
public class RequestUtils {
    /**
     * Get 请求demo
     * @param context
     * @param observer
     */
    public static void getarticle(Context context, CusObserver<Article> observer){
        RetrofitUtils.getApiUrl()
                .article_list(0)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);
    }
}

