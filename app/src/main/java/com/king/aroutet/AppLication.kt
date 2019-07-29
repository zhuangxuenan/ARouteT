package com.king.aroutet

import com.king.commonlib.base.BaseApplication

/***
 *项目名称：ARouteT
 *类描述:
 *创建人：Android
 *创建时间：2019/7/29 11:45
 *修改人：Android
 */
class AppLication : BaseApplication() {
    //kotlin单例实现
    companion object {
        val instance: AppLication by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AppLication()
        }
    }
}