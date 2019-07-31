package com.king.commonlib.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.king.commonlib.base.mvp.BasePresenter;
import com.king.commonlib.base.mvp.IBaseView;

import androidx.annotation.Nullable;


/**
 * Describe：所有需要Mvp开发的Activity的基类
 * Created by 阳光下的影子 on 2018/10/15.
 */
/**
 * 1.0 定义一个契约类Contract
 * 1.1 在契约类中定义三个接口分别继承IBaseModel IBaseView 还有一个作为扩展Presenter，让BasePresenter实现他
 * 去做一些额外的工作
 * 1.3在实现了IBaseModel的接口中定义一些抽象方法用来实现http sql json cache等操作
 * 1.4在实现了IBaseView的接口中定义一些抽象方法去渲染修改ui
 * 1.5在Presenter接口中定义的抽象方法让他去跟Model和View去交互
 * 2.0 定义模块的NeedPresenter实现上述1.5中的Presenter
 * 2.1在NeedPresenter中调用createModule创建Model对象
 * 2.2在NeedPresenter中通过调用getModule()和getView()来完成Model层和View层的交互
 * 2.3通过NeedPresenter作为媒介，Model层和View层的交互结果返回了activity去处理
 * 2.4在activity或者fragment中通过createPresenter创建NeedPresenter引用
 * 2.5然后通过NeedPresenter对象p来去调用NeedPresenter中定义的一些个方法
 */
@SuppressWarnings("unchecked")
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //创建present
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }
    //***************************************IBaseView方法实现*************************************
    @Override
    public void showLoading() {
        showLoading("");
    }

    public void showLoading(String msg) {
        if(null!=hud&&!hud.isShowing()){
            if (!TextUtils.isEmpty(msg)) {
                hud.setLabel(msg);
            }
            hud.show();
        }
    }

    @Override
    public void dismissLoading() {
        if(null!=hud&&hud.isShowing()){
            hud.dismiss();
        }
    }
    @Override
    public Context getContext() {
        return mContext;
    }
    //***************************************IBaseView方法实现*************************************
    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();
}
