package com.king.commonlib.retrofit.Utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.king.commonlib.R;
import com.king.commonlib.utils.PxUtils;

import androidx.core.content.ContextCompat;
import io.reactivex.disposables.Disposable;

/**
 * Observer加入加载框
 *可以选择加入弹窗的观察者
 * @param <T>
 */
public abstract class CusObserver<T> extends BaseObserver<T> {
    private boolean mShowDialog;
    protected KProgressHUD hud;
    private Context mContext;
    private Disposable d;
    public CusObserver(Context context, Boolean showDialog) {
        mContext = context;
        mShowDialog = showDialog;
    }

    public CusObserver(Context context) {
        this(context, true);
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        if (!isConnected(mContext)) {
            Toast.makeText(mContext, "未连接网络", Toast.LENGTH_SHORT).show();
            if (d.isDisposed()) {
                d.dispose();
            }
        } else {
            if(mShowDialog){
                if(null==hud){
                    hud = KProgressHUD.create(mContext)
                            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                            .setCancellable(true)
                            .setAnimationSpeed(2)
                            .setSize(PxUtils.dp2px(mContext,100f),PxUtils.dp2px(mContext,100f))//宽高
                            .setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorPrimary))//设置背景
                            .setDimAmount(0.4f);//透明度
                }
                hud.setLabel("正在加载中").show();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (d.isDisposed()) {
            d.dispose();
        }
        hidDialog();
        super.onError(e);
    }

    @Override
    public void onComplete() {
        if (d.isDisposed()) {
            d.dispose();
        }
        hidDialog();
        super.onComplete();
    }


    public void hidDialog() {
        if(null!=hud&&mShowDialog==true){
            if(hud.isShowing()){
                hud.dismiss();
            }
            hud = null;
        }
    }

    /**
     * 是否有网络连接，不管是wifi还是数据流量
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        boolean available = info.isAvailable();
        return available;
    }
}

