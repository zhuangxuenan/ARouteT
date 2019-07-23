package com.king.commonlib.utils;


import com.king.commonlib.bean.Event;

import org.greenrobot.eventbus.EventBus;

/**
 * Describe：EventBusUtils
 * Created by 阳光下的影子 on 2018/10/22.
 */

public class EventBusUtils {

    /**
     * 注册事件
     */
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 解除事件
     */
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发送普通事件
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }
    //...
}
