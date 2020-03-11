package com.king.commonlib.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.lang.ref.WeakReference;

import androidx.lifecycle.LiveData;

/**
 * @ProjectName: ARouteT$
 * @Package: com.king.commonlib.test$
 * @ClassName: MyLiveData$
 * @Description: java类作用描述
 * @Author: 庄学南
 * @CreateDate: 2020/3/11$ 10:34$
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/3/11$ 10:34$
 * @UpdateRemark: 更新说明：
 */
public class MyLiveData extends LiveData {
    private static final String TAG = "MyLiveData";
    private static MyLiveData sData;
    private WeakReference<Context> mContextWeakReference;

    public static MyLiveData getInstance(Context context){
        if (sData == null){
            sData = new MyLiveData(context);
        }
        return sData;
    }

    private MyLiveData(Context context){
        mContextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected void onActive() {
        super.onActive();
        registerReceiver();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        unregisterReceiver();
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        mContextWeakReference.get().registerReceiver(mReceiver, intentFilter);
    }

    private void unregisterReceiver() {
        mContextWeakReference.get().unregisterReceiver(mReceiver);
    }


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "action = " + action);
            if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
                int wifiRssi = intent.getIntExtra(WifiManager.EXTRA_NEW_RSSI, -200);
                int wifiLevel = WifiManager.calculateSignalLevel(
                        wifiRssi, 4);
                sData.setValue(wifiLevel);
            }
        }
    };
}
