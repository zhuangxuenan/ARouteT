package com.king.aroutet.mvp_contract;

import com.king.commonlib.base.mvp.BasePresenter;

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
        getModule().getarticleList(params -> {
            getView().list_article(params);
        });
    }
}
