package com.king.commonlib.test;

import android.os.Bundle;
import android.text.Editable;

import com.king.commonlib.R;
import com.king.commonlib.databinding.ActivityLivedataTestLayoutBinding;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

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
        mViewModel = ViewModelProviders.of(this).get(EditViewModel.class);
        mBinding.setEvm(mViewModel);
        //mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplication.getslacker()).create(EditViewModel.class);
        /* mBinding.et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(s.toString().trim())){
                    mViewModel.setValue(s.toString());
                }
            }
        });*/
        /*mViewModel.getValue().observe(this, s -> {
            tv.setText(s);
        });*/
    }
    private LiveData<String> getName(String num) {
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue(num + "a");
        return liveData;
    }
    public class JJ {
        public void afterTextChanged(Editable s) {
            mViewModel.setValue(s.toString());
        }
    }
}
