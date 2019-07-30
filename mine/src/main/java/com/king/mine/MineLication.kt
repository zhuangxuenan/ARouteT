package com.king.mine

import com.king.commonlib.base.BaseApplication

/***
 *项目名称：ARouteT
 *类描述:
 *创建人：Android
 *创建时间：2019/7/30 9:11
 *修改人：Android
 */
class MineLication : BaseApplication() {
    //kotlin单例实现
    companion object {
        val instance: MineLication by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MineLication()
        }
    }
}