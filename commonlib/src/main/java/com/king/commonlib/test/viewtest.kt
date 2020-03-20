package com.king.commonlib.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @CompanyName:    xxxx科技
 * @ProjectName:    ARouteT
 * @Package:        com.king.commonlib.test
 * @ClassName:      viewtest
 * @Description:    java类作用描述
 * @Author:         庄学南
 * @CreateDate:     2020/3/20 0020 21:10
 * @UpdateUser:     更新者：
 * @UpdateDate:     2020/3/20 0020 21:10
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
// 假设我们要存放的UI数据就是User对象
// 先新建一个实体对象
data class User(val name: String, val age: Int, val sex: Int)

// 新建ViewModel类
class UserViewModel : ViewModel() {
    var user:MutableLiveData<User>? = null
    fun getValue(): MutableLiveData<User> {
        if(user!=null){
            user  =  MutableLiveData()
        }
        return user as MutableLiveData<User>
    }

    fun getValueValue(): User? {
        return getValue().value
    }

    fun setValue(mValue: User) {
        if (this.user == null) {
            return
        }
        this.user?.value = mValue
    }

    fun postValue(mValue: User) {
        if (this.user == null) {
            return
        }
        this.user?.postValue(mValue)
    }
}