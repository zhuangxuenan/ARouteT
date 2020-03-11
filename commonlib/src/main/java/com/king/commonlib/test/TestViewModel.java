package com.king.commonlib.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.commonlib.test$
 * @ClassName: TestViewModel$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/11$ 12:00$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/11$ 12:00$
 * @UpdateRemark: 更新说明：
 */
public class TestViewModel extends ViewModel {
    private MutableLiveData<Integer> mNumLiveData = new MutableLiveData<>();

    //switchMap变换
    private LiveData<String> mNameLiveData = Transformations.switchMap(mNumLiveData, num -> getName(num));

    //返回一个LiveData
    private LiveData<String> getName(Integer num) {
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue(num + "a");
        return liveData;
    }

    public MutableLiveData<Integer> getNumLiveData() {
        return mNumLiveData;
    }

    public LiveData<String> getNameLiveData() {
        return mNameLiveData;
    }
}
