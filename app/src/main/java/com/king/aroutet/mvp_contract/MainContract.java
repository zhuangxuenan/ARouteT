package com.king.aroutet.mvp_contract;

import com.king.commonlib.base.mvp.IBaseModel;
import com.king.commonlib.base.mvp.IBaseView;
import com.king.commonlib.novate.callback.OnResultCallBack;

/**
 * Describe：契约类
 * Created by 眼光下的影子 on 2018/11/21.
 */

public interface MainContract {
    interface Model extends IBaseModel {
        /**
         * 检查更新
         *
         * @param callback 回调函数
         */
        void getarticleList(OnResultCallBack callback);
    }
    interface View extends IBaseView {
        /**
         * 需要更新
         *
         * @param appInfo appInfo
         */
        void list_article(String appInfo);
    }

    interface Presenter {
        /**
         * 检查更新
         */
        void checkList();
    }
}
