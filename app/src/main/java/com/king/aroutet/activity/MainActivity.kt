package com.king.aroutet.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.kaopiz.kprogresshud.KProgressHUD
import com.king.aroutet.R
import com.king.aroutet.mvp_contract.MainContract
import com.king.aroutet.mvp_contract.MainPresenter
import com.king.commonlib.base.BaseMvpActivity
import com.king.commonlib.retrofit.bean.Article
import com.king.commonlib.utils.PxUtils
import kotlinx.android.synthetic.main.activity_main.*

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
        when(v?.id){
            R.id.kprogresshud->{
                KProgressHUD.create(this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        //.setLabel("Please wait")
                        //.setDetailsLabel("Downloading data")
                        .setCancellable(true)
                        .setAnimationSpeed(2)
                        //.setCornerRadius(5f)//圆角
                        //.setGraceTime(1000)//延迟时间
                        .setSize(PxUtils.dp2px(this,100f),PxUtils.dp2px(this,100f))//宽高
                        .setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))//设置背景
                        .setDimAmount(0.4f)//透明度
                        .show()
            }
        }
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
        kprogresshud.setOnClickListener(this)
    }

    override fun list_article(appInfo: Article?) {
        //showLoading()
    }
}