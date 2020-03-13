package com.king.commonlib.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.king.commonlib.R
import kotlinx.android.synthetic.main.activity_kotlin_test_layout.*

/**
 *
 * @ProjectName:    ARouteT$
 * @Package:        com.king.commonlib.test$
 * @ClassName:      KotlinActivty$
 * @Description:     java类作用描述
 * @Author:         庄学南
 * @CreateDate:     2020/3/12$ 14:36$
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/3/12$ 14:36$
 * @UpdateRemark:   更新说明：
 */
class KotlinActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test_layout)
        tv_ak_1.setOnClickListener {

        }
        tv_ak_1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
        tv_ak_1.setOnClickListener({ v: View? ->

        })
        tv_ak_1.setOnClickListener { v: View? ->

        }
        tv_ak_1.setOnClickListener {

        }
    }
}