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
@SuppressWarnings("unchecked")
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建present
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
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
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            if (!TextUtils.isEmpty(msg)) {
                loadingDialog.setTitleText(msg);
            }
            loadingDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
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
