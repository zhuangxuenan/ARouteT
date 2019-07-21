package com.king.commonlib.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.king.commonlib.R;
import com.king.commonlib.bean.Event;
import com.king.commonlib.dialog.LoadingDialog;
import com.king.commonlib.listener.IBaseFragment;
import com.king.commonlib.listener.IMemoryState;
import com.king.commonlib.utils.AppLogMessageMgr;
import com.king.commonlib.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Describe：所有Fragment的基类
 * Created by 阳光下的影子 on 2018/10/17.
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment,IMemoryState,View.OnClickListener {
    /**
     * 当前Fragment渲染的视图View
     **/
    private View rootView;
    private Unbinder unBinder;
    protected Context mContext;
    protected LoadingDialog loadingDialog;
    protected BaseActivity mActivity;
    protected final String TAG = this.getClass().getSimpleName();
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }
    @Override
    public void onResume() {
        super.onResume();
        resume();
    }
    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            hideSoftInput();
            if (NetworkUtil.isNetworkConnected(mContext)) {
                limitOnClick(v);
            } else {
                //弹出吐司
            }
        } else {
            return;
        }
    }

    protected abstract void limitOnClick(View v);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        loadingDialog = new LoadingDialog(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_base, container, false);
        ((ViewGroup) rootView.findViewById(R.id.fl_content)).addView(getLayoutInflater().inflate(bindLayout(), null));
        unBinder = ButterKnife.bind(this, rootView);
        if (regEvent()) {
            EventBus.getDefault().register(this);
        }
        return rootView;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppLogMessageMgr.e(TAG);
        initView(view);
        initParms(savedInstanceState);
        doOnceBusiness(mContext,view);
        onCreateSavedInstanceState(savedInstanceState,view);
    }

    @Override
    public void memorystate(int memory) {
        memoryChangeState(memory);
    }
    /**
     * fragment 内存监听
     * @param state 内存状态
     */
    public void memoryChangeState(int state) {

    }

    @Override
    public void onCreateSavedInstanceState(Bundle savedInstanceState, View view) {

    }
    @Override
    public void onPause() {
        super.onPause();
        hideSoftInput();
    }

    @Override
    public void onStop() {
        System.gc();
        super.onStop();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        hideSoftInput();
        if (unBinder != null) {
            unBinder.unbind();
        }
        if (regEvent()) {
            EventBus.getDefault().unregister(this);
        }
    }
    /**
     * 子类接受事件 重写该方法
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(Event event) {
    }

    /**
     * 需要接收事件 重新该方法 并返回true
     */
    protected boolean regEvent() {
        return false;
    }
    //    强制隐藏输入法
    protected void hideSoftInput() {
        View v = getHoldingActivity().getCurrentFocus();
        if (v != null && v.getWindowToken() != null) {
            InputMethodManager manager = (InputMethodManager) getHoldingActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            boolean isOpen = manager.isActive();
            if (isOpen) {
                manager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
