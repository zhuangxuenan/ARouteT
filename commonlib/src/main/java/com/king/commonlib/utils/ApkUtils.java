package com.king.commonlib.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import java.io.File;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;

/**
 * Created by Administrator on 2017/9/16 0016.
 */

public class ApkUtils {
    private Context mAct;
    private String mPath;
    public ApkUtils(Context mAct, String mPath) {
        this.mAct = mAct;
        this.mPath = mPath;
    }
    public void install() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startInstallO();
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                startInstallN();
            } else {
                startInstall();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * android1.x-6.x
     */
    private void startInstall(){
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setDataAndType(Uri.parse("file://" + mPath), "application/vnd.android.package-archive");
        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mAct.startActivity(install);
    }

    /**
     * android7.x
     */
    private void startInstallN(){
        //参数1 上下文, 参数2 在AndroidManifest中的android:authorities值, 参数3 共享的文件
        Uri apkUri = FileProvider.getUriForFile(mAct, getAuthority(mAct, ".fileprovider"), new File(mPath));
        Intent install = new Intent(Intent.ACTION_VIEW);
        //由于没有在Activity环境下启动Activity,设置下面的标签
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //添加这一句表示对目标应用临时授权该Uri所代表的文件
        install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        install.setDataAndType(apkUri, "application/vnd.android.package-archive");
        mAct.startActivity(install);
    }

    /**
     * android8.x
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startInstallO() {
        boolean isGranted = mAct.getPackageManager().canRequestPackageInstalls();
        if (isGranted) {
            startInstallN();//安装应用的逻辑(写自己的就可以)
        } else {
            new AlertDialog.Builder(mAct).setCancelable(false).setTitle("安装应用需要打开未知来源权限，请去设置中开启权限").setPositiveButton("确定", (d, w) -> {
                Uri packageURI = Uri.parse("package:" + mAct.getPackageName());
                //注意这个是8.0新API
                Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
                mAct.startActivity(intent);
            }).show();
        }
    }

    /**
     * 获取FileProvider * 返回： "此处为你的包名.FileProvider" * china.test.provider
     */
    private String getAuthority(Context context, String authority) {
        return getAppProcessName(context) + authority;
    }

    /**
     * 获取当前应用程序的包名 * * @param context 上下文对象 * @return 返回包名
     */
    private String getAppProcessName(Context context) {
        //当前应用pid
        int pid = android.os.Process.myPid();
        //任务管理类
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //遍历所有应用
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.pid == pid) //得到当前应用
            {
                return info.processName;
                //返回包名
            }
        }
        return "";
    }
}
