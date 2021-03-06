package com.king.commonlib.utils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.king.commonlib.base.BaseActivity;
import com.king.commonlib.base.BaseFragment;

/**
 * Describe：ARouter帮助类
 * Created by 阳光下的影子 on 2018/11/13.
 */

public class ARouterUtils {


    /**
     * 根据path返回Fragment
     *
     * @param path path
     * @return fragment
     */
    public static BaseFragment getFragment(String path) {
        return (BaseFragment) ARouter.getInstance()
                .build(path)
                .navigation();
    }

    /**
     * 根据path返回Activity
     *
     * @param path path
     * @return Activity
     */
    public static BaseActivity getActivity(String path) {
        return (BaseActivity) ARouter.getInstance()
                .build(path)
                .navigation();
    }
}
