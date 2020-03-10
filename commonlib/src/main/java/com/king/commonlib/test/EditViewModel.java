package com.king.commonlib.test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.commonlib.test$
 * @ClassName: EditViewModel$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/10$ 17:18$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/10$ 17:18$
 * @UpdateRemark: 更新说明：
 */
public class EditViewModel extends ViewModel {
    private MutableLiveData<String> mValue;

    public MutableLiveData<String> getValue() {
        if (mValue == null) {
            mValue = new MutableLiveData<>();
        }
        return mValue;
    }

    public String getValueValue() {
        return getValue().getValue();
    }

    public void setValue(String mValue) {
        if (this.mValue == null) {
            return;
        }
        this.mValue.setValue(mValue);
    }

    public void postValue(String mValue) {
        if (this.mValue == null) {
            return;
        }
        this.mValue.postValue(mValue);
    }
}
