package com.king.commonlib.listener;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Fragment接口
 */
public interface IBaseFragment {

    /**
     * 绑定渲染视图的布局文件
     *
     * @return 布局文件资源id
     */
    int bindLayout();
    void resume();
    /**
     * 初始化界面参数
     *
     * @param parms
     */
    void initParms(Bundle parms);

    /**
     * 初始化控件
     */
    void initView(final View view);

    /**
     * 业务处理操作（onCreateView方法中调用）
     *
     * @param mContext 当前Activity对象
     */
    void doOnceBusiness(Context mContext, View view);

    void onCreateSavedInstanceState(Bundle savedInstanceState, View view);
}
