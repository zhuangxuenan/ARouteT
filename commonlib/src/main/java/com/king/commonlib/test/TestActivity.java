package com.king.commonlib.test;

import android.os.Bundle;
import android.text.Editable;

import com.king.commonlib.R;
import com.king.commonlib.databinding.ActivityLivedataTestLayoutBinding;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.commonlib.test$
 * @ClassName: TestActivity$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/10$ 17:21$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/10$ 17:21$
 * @UpdateRemark: 更新说明：
 */
public class TestActivity extends RxAppCompatActivity {
    private EditViewModel mViewModel;
    private ActivityLivedataTestLayoutBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_livedata_test_layout);
        //mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplication.getslacker()).create(EditViewModel.class);
        mViewModel = ViewModelProviders.of(this).get(EditViewModel.class);
        mBinding.setEvm(mViewModel);
        //让xml内绑定的LiveData和Observer建立连接，也正是因为这段代码，让LiveData能感知Activity的生命周期
        //https://www.jianshu.com/p/7f77cfc43313
        mBinding.setLifecycleOwner(this);
        try {
            Class duclass = Du.class;
            Object du = duclass.newInstance();
            Method shoutMethod = duclass.getDeclaredMethod("shout");
            shoutMethod.invoke(du);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    private LiveData<String> getName(String num) {
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue(num + "a");
        return liveData;
    }
    public class JJ {
        public void afterTextChanged(Editable s) {
            mViewModel.setValue(s.toString());
            mBinding.setEvm(mViewModel);
        }
    }
}
