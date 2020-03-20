package com.king.commonlib.test

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.king.commonlib.R
import com.king.commonlib.databinding.ActivityViewModelBinding
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * @CompanyName:    xxxx科技
 * @ProjectName:    ARouteT
 * @Package:        com.king.commonlib.test
 * @ClassName:      TestKotlinActivity
 * @Description:    java类作用描述
 * @Author:         庄学南
 * @CreateDate:     2020/3/20 0020 21:05
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/3/20 0020 21:05
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class TestKotlinActivity:RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityViewModelBinding>(this, R.layout.activity_view_model)
        binding.viewModel = userViewModel
        // 让xml内绑定的LiveData和Observer建立连接，也正是因为这段代码，让LiveData能感知Activity的生命周期
        //这行很重要
        binding.lifecycleOwner = this
        binding.btVm.setOnClickListener {
            userViewModel.postValue(User("wangergo",12,1))
        }
    }
}