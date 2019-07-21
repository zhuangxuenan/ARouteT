package com.king.commonlib.constants;


import com.king.commonlib.base.BaseApplication;

/**
 * Describe：缓存key
 * Created by 吴天强 on 2018/11/13.
 */

public interface CacheKey {

    /**
     * 保存用户信息
     */
    String USER_INFO = BaseApplication.getslacker().getPackageName() + ".UserInfo";

    /**
     * 保存登录状态
     */
    String USER_LOGGED = BaseApplication.getslacker().getPackageName() + ".UserLogged";
}
