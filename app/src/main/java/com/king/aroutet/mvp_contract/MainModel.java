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
            RequestUtils.getarticle(activity, new CusObserver<Article>(activity) {
                @Override
                public void onSuccess(Article result) {

                }
                @Override
                public void onFailure(Throwable e, String errorMsg) {

                }
            });
        }
    }
}
