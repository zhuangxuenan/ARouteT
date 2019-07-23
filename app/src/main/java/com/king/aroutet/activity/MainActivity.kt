package com.king.aroutet.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import com.king.aroutet.R
import com.king.aroutet.mvp_contract.MainContract
import com.king.aroutet.mvp_contract.MainPresenter
import com.king.commonlib.base.BaseMvpActivity

/***
 *项目名称：ARouteT
 *类描述:
 *创建人：Android
 *创建时间：2019/7/22 10:49
 *修改人：Android
 */
class MainActivity:BaseMvpActivity<MainPresenter>(), MainContract.View{
    override fun destroy() {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun limitOnClick(v: View?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        presenter.start()
        presenter.checkList()
    }

    override fun doBusiness(mContext: Context?) {

    }

    override fun list_article(appInfo: String?) {

    }

}