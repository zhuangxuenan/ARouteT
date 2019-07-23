package com.king.commonlib.bean;

import lombok.Getter;
import lombok.Setter;


/**
 * Describe：EventBus事件类
 * Created by 眼光下的影子 on 2018/10/22.
 */

@Getter
@Setter
public class Event<T> {

    private String action;
    private T data;
    public Event(String action) {
        this.action = action;
    }
    public Event(String action, T data) {
        this.action = action;
        this.data = data;
    }
}
