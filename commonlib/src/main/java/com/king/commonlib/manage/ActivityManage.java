package com.king.commonlib.manage;

import android.app.Activity;

import java.util.Stack;

/**
 * Describe：管理所有的Activity
 * Created by 阳光下的的影子 on 2018/10/15.
 */

public class ActivityManage {

    //保存所有创建的Activity
    private Stack<Activity> allActivities = new Stack<>();

    private static ActivityManage mSlacker= null;
    private ActivityManage(){}
    public static ActivityManage getslacker() {
        // 为空就new
        if(mSlacker== null){
            synchronized (ActivityManage.class) {
                if (mSlacker== null){
                    return mSlacker= new ActivityManage();
                }
            }
        }
        return mSlacker;
    }
    /**
     * 添加Activity到管理器
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        if (null == allActivities) {
            allActivities = new Stack<>();
        }
        if (activity != null) {
            allActivities.add(activity);
        }
    }


    /**
     * 从管理器移除Activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            allActivities.remove(activity);
            activity.finish();
        }
    }
    public void removeByname(String name) {
        Stack<Activity> activityTemp = new Stack<>();
        for (int i = 0; i < allActivities.size(); i++) {
            if (allActivities.get(i).getClass().getSimpleName().equals(name)) {
                //添加到临时集合中
                activityTemp.add(allActivities.get(i));
                //结束Activity
                allActivities.get(i).finish();
            }
        }
        allActivities.removeAll(activityTemp);
    }
    /**
     * 栈中销毁并移除所有Act对象
     */
    public void removeAllActivity() {
        if (null != allActivities && allActivities.size() > 0) {
            //创建临时集合对象
            Stack<Activity> activityTemp = new Stack<>();
            for (Activity activity : allActivities) {
                if (null != activity) {
                    //添加到临时集合中
                    activityTemp.add(activity);
                    //结束Activity
                    activity.finish();
                }
            }
            allActivities.removeAll(activityTemp);
        }
        System.gc();
        System.exit(0);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    /**
     * 获取当前Act对象
     * @return Activity 当前act
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!allActivities.empty()) {
            activity = allActivities.lastElement();
        }
        return activity;
    }


    /**
     * 获得当前Act的类名
     * @return String
     */
    public String getCurrentActivityName() {
        String actSimpleName = "";
        if (!allActivities.empty()) {
            actSimpleName = allActivities.lastElement().getClass().getSimpleName();
        }
        return actSimpleName;
    }
}
