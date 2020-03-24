package com.king.commonlib.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.gyf.immersionbar.ImmersionBar;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.king.commonlib.R;
import com.king.commonlib.listener.IBaseActivity;
import com.king.commonlib.listener.IMemoryState;
import com.king.commonlib.manage.ActivityManage;
import com.king.commonlib.utils.AppLogMessageMgr;
import com.king.commonlib.utils.NetworkUtil;
import com.king.commonlib.utils.PxUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


import java.util.Arrays;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Describe：所有Activity的基类
 * Created by 阳光下的影子 on 2018/10/15.
 */
//RxAppCompatActivity https://github.com/trello/RxLifecycle
public abstract class BaseActivity extends RxAppCompatActivity implements IBaseActivity,View.OnClickListener {
    private Unbinder unbinder;
    protected Context mContext;
    protected ImmersionBar mImmersionBar;
    private IMemoryState mIMemoryState;
    protected final String TAG = this.getClass().getSimpleName();
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    protected KProgressHUD hud;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppLogMessageMgr.e(TAG);
        super.onCreate(savedInstanceState);
        mContext = this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(bindLayout());
        //初始化ButterKnife
        unbinder = ButterKnife.bind(this);
        //沉浸式状态栏
        initImmersionBar(R.color.blue);
        ActivityManage.getslacker().addActivity(this);
        hud = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                //.setLabel("Please wait")
                //.setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
                //.setAutoDismiss(true)//是否自动消失
                //.setCornerRadius(5f)//圆角
                //.setGraceTime(1000)//延迟时间
                .setSize(PxUtils.dp2px(this,100f),PxUtils.dp2px(this,100f))//宽高
                .setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))//设置背景
                .setDimAmount(0.4f);//透明度

        initView(getWindow().getDecorView(),savedInstanceState);
        doBusiness(this);
    }

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            hideSoftInput();
            if (NetworkUtil.isNetworkConnected(this)) {
                limitOnClick(v);
            } else {
                //弹出吐司
            }
        } else {
            return;
        }
    }

    protected abstract void limitOnClick(View v);
    /**
     * 沉浸栏颜色
     */
    protected void initImmersionBar(int color) {
        mImmersionBar = ImmersionBar.with(this);
        if (color != 0) {
            mImmersionBar.statusBarColor(color);
        }
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideSoftInput();
        if (unbinder != null) {
            unbinder.unbind();
        }
        destroy();
        if(null!=hud){
            if(hud.isShowing()){
                hud.dismiss();
            }
            hud = null;
        }
        //将Activity从管理器移除
        ActivityManage.getslacker().removeActivity(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AppLogMessageMgr.e("permissions:" + Arrays.toString(permissions) + " grantResults:" + Arrays.toString(grantResults));
        //如果有未授权权限则跳转设置页面
        if (!requestPermissionsResult(grantResults)) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    /**
     * 判断授权结果
     */
    private boolean requestPermissionsResult(int[] grantResults) {
        for (int code : grantResults) {
            if (code == -1) {
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onPause() {
        super.onPause();
        hideSoftInput();
        if(null!=hud){
            if(hud.isShowing()){
                hud.dismiss();
            }
        }
        pause();
    }
    //强制隐藏输入法
    protected void hideSoftInput() {
        View v = getCurrentFocus();
        if (v != null && v.getWindowToken() != null) {
            InputMethodManager manager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            boolean isOpen = manager.isActive();
            if (isOpen) {
                manager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    /**
     * activity 获取内存状态
     *
     * @param state 状态值
     *              TRIM_MEMORY_UI_HIDDEN        当我们程序中的所有UI组件全部不可见
     *              TRIM_MEMORY_COMPLETE         目前内存已经很低了，并且我们的程序处于LRU缓存列表的最边缘位置，系统会最优先考虑杀掉我们的应用程序
     *              TRIM_MEMORY_MODERATE         表示手机目前内存已经很低了，并且我们的程序处于LRU缓存列表的中间位置，如果手机内存还得不到进一步释放的话，那么我们的程序就有被系统杀掉的风险了
     *              TRIM_MEMORY_BACKGROUND       内存已经很低了，系统准备开始根据LRU缓存来清理进程。这个时候我们的程序在LRU缓存列表的最近位置，是不太可能被清理掉的，但这时去释放掉一些比较容易恢复的资源能够让手机的内存变得比较充足，从而让我们的程序更长时间地保留在缓存当中，这样当用户返回我们的程序时会感觉非常顺畅，而不是经历了一次重新启动的过程
     *              TRIM_MEMORY_RUNNING_CRITICAL 程序正常运行，但是系统已经根据LRU缓存规则杀掉了大部分缓存的进程了。这个时候我们应当尽可能地去释放任何不必要的资源，不然的话系统可能会继续杀掉所有缓存中的进程，并且开始杀掉一些本来应当保持运行的进程，比如说后台运行的服务
     *              TRIM_MEMORY_RUNNING_LOW      表示应用程序正常运行，并且不会被杀掉。但是目前手机的内存已经非常低了，我们应该去释放掉一些不必要的资源以提升系统的性能，同时这也会直接影响到我们应用程序的性能
     *              TRIM_MEMORY_RUNNING_MODERATE 正常运行，不会被杀掉。但是目前手机的内存已经有点低了，系统可能会开始根据LRU缓存规则来去杀死进程
     */
    public void getMemoryState(int state) {

    }

    /**
     * 此方法适合于activity上的fragment进行内存使用情况监听管理
     *
     * @param iMemoryState 回调接口
     */
    public void setMemoryListener(IMemoryState iMemoryState) {
        mIMemoryState = iMemoryState;
    }

}
