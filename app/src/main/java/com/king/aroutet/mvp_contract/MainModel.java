package com.king.aroutet.mvp_contract;

import com.king.commonlib.base.BaseActivity;
import com.king.commonlib.listener.AppInterface;
import com.king.commonlib.manage.ActivityManage;
import com.king.commonlib.retrofit.RequestUtils;
import com.king.commonlib.retrofit.Utils.CusObserver;
import com.king.commonlib.retrofit.bean.Article;

/**
 * Describe：首页Module
 * Created by 眼光下的影子 on 2018/11/21.
 */

public class MainModel implements MainContract.Model {
    @Override
    public void getarticleList(AppInterface<Article>appInterface) {
        //通过网络请求获取结果通过mainPresenter来传递给mainview
        BaseActivity activity = (BaseActivity) ActivityManage.getslacker().currentActivity();
        if("MainActivity".equals(activity.getClass().getSimpleName())){
            RequestUtils.getarticle(0,activity, new CusObserver<Article>(activity) {
                @Override
                public void onSuccess(Article result) {

                }
                @Override
                public void onFailure(Throwable e, String errorMsg) {

                }
            });
        }
        /*//如果没有配置.addCallAdapterFactory(RxJava2CallAdapterFactory.create())则返回Call
        RetrofitUtils.getApiUrl().article_list2(0).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                Article article = response.body();
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });*/
        /*RetrofitUtils.getApiUrl()
                     .article_list4(0)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Consumer<Result<Article>>() {
                            @Override
                            public void accept(Result<Article> articleResult) throws Exception {
                                //articleResult.response().headers()
                                //articleResult.response().body()
                            }
                      }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                      });*/
        /*RetrofitUtils.getApiUrl()
                .article_list5(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Response<Article>>() {
            @Override
            public void accept(Response<Article> articleResponse) throws Exception {
                //articleResponse.code() //响应码
                //articleResponse.headers();
                //articleResponse.body()
            }
        });*/
    }
}
