package com.king.aroutet.mvp_contract;

import com.king.commonlib.novate.callback.OnResultCallBack;

/**
 * Describe：首页Module
 * Created by 眼光下的影子 on 2018/11/21.
 */

public class MainModel implements MainContract.Model {
    @Override
    public void getarticleList(OnResultCallBack callback) {
        //通过网络请求获取结果通过mainPresenter来传递给mainview
    }
}
