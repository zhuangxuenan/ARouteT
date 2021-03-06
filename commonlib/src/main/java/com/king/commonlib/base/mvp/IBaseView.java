package com.king.commonlib.base.mvp;

import android.content.Context;

/**
 * Describe：所有View基类
 * Created by 阳光下的影子 on 2018/10/17.
 */

public interface IBaseView {

    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void dismissLoading();
    /**
     * 上下文
     *
     * @return context
     */
    Context getContext();
}
