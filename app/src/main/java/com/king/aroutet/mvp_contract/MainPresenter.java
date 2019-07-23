package com.king.aroutet.mvp_contract;

import com.king.commonlib.base.mvp.BasePresenter;
import com.king.commonlib.novate.callback.OnResultCallBack;

/**
 * Describe：首页Presenter
 * Created by 眼光下的影子 on 2018/11/20.
 */

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> implements MainContract.Presenter {


    @Override
    protected MainModel createModule() {
        return new MainModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void checkList() {
        getModule().getarticleList(new OnResultCallBack<String>() {
            @Override
            public void onSuccess(boolean success, int code, String msg, Object tag, String response) {
                getView().list_article(response);
            }

            @Override
            public void onFailure(Object tag, Exception e) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
