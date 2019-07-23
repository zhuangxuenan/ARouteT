package com.king.commonlib.base;

import android.os.Bundle;

import com.king.commonlib.base.mvp.BasePresenter;
import com.king.commonlib.base.mvp.IBaseView;

import androidx.annotation.Nullable;


/**
 * Describe：所有需要Mvp开发的Fragment的基类
 * Created by 阳光下的影子 on 2018/10/17.
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IBaseView {

    protected P presenter;


    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建present
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }

    }


    //***************************************IBaseView方法实现*************************************
    @Override
    public void showLoading() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
    //***************************************IBaseView方法实现*************************************

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();
}
