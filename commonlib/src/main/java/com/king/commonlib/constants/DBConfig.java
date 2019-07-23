package com.king.commonlib.constants;


import com.king.commonlib.R;
import com.king.commonlib.base.BaseApplication;

/**
 * Describe：数据库配置文件
 * Created by 阳光下的影子 on 2018/11/5.
 */

public interface DBConfig {
    String DB_NAME = BaseApplication.getslacker().getString(R.string.app_name) + ".db";
}
