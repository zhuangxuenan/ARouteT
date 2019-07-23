package com.king.commonlib.retrofit;

import com.king.commonlib.retrofit.Utils.MyObserver;
import com.king.commonlib.retrofit.bean.Article;
import com.trello.rxlifecycle2.components.RxActivity;

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
    public static void getarticle(RxActivity context, MyObserver<Article>observer){
        /*RetrofitUtils.getApiUrl()
                .article_list(0)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);*/
    }
}

