package com.king.commonlib.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.king.commonlib.BuildConfig;
import com.king.commonlib.manage.ActivityManage;
import com.king.commonlib.manage.CrashHandlerManage;

import androidx.multidex.MultiDex;


/**
 * Describe：基础Application所有需要模块化开发的module都需要继承自BaseApplication
 * Created by 阳光下的影子 on 2018/10/12.
 */
public class BaseApplication extends Application {
    private static BaseApplication application= null;
    //private BaseApplication(){}
    public static BaseApplication getslacker() {
        // 为空就new
        if(application== null){
            synchronized (BaseApplication.class) {
                if (application== null){
                    return application= new BaseApplication();
                }
            }
        }
        return application;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        initCrashManage();
    }
    /**
     * 初始化崩溃管理器
     */
    private void initCrashManage() {
        if (!BuildConfig.DEBUG) {
            CrashHandlerManage.getInstance()
                    .init(getApplicationContext());
        }
    }




    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application);// 尽可能早，推荐在Application中初始化
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }
    /**
     * 退出应用
     */
    public void exitApp() {
       ActivityManage.getslacker().removeAllActivity();
    }
}