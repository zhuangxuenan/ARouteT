package com.king.aroutet.activity

import android.content.Context
import android.os.Bundle
import android.view.View
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun limitOnClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): MainPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doBusiness(mContext: Context?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list_article(appInfo: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}