package com.king.commonlib.base.mvvm;

/**
 * Created by goldze on 2017/6/15.
 */

public interface MBaseView {
    /**
     * 初始化界面传递参数
     */
    void initParam();
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();
}
