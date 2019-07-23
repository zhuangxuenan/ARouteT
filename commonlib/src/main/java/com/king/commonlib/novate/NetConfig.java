package com.king.commonlib.novate;


import com.king.commonlib.constants.Constants;

/**
 * Describe：网络请求URL
 * Created by 阳光下的影子 on 2017/9/26.
 */

public class NetConfig {
    /**
     * 响应的返回key
     */
    public class Code {
        public static final String SUCCESS = "success";
        public static final String MSG = "errorMsg";
        public static final String CODE = "errorCode";
        public static final String MODEL = "data";
    }
    /**
     * 网络请求Url
     */
    public static class Url {
        //自己服务器IP
        public static String MY_SERVICE_URL = "http://sdk.xiaoyuyu.com.cn";
        //服务器地址
        interface BaseUrl {
            String SERVER_DEVELOP = "https://www.wanandroid.com";
            String SERVER_TEST = "";
            String SERVER_PRODUCTION = "";
        }
        /**
         * 返回服务器基础地址
         */
        static String getBaseUrl() {
            switch (Constants.SERVER_TYPE) {
                case Constants.ServerType.SERVER_DEVELOP:
                    return BaseUrl.SERVER_DEVELOP;
                case Constants.ServerType.SERVER_TEST:
                    return BaseUrl.SERVER_TEST;
                case Constants.ServerType.SERVER_PRODUCTION:
                    return BaseUrl.SERVER_PRODUCTION;
            }
            return BaseUrl.SERVER_PRODUCTION;
        }


    }

}
