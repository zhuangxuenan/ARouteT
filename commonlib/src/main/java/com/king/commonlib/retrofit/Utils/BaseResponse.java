package com.king.commonlib.retrofit.Utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一响应
 * @param <T>
 */
@Getter
@Setter
public class BaseResponse<T> {
    private int res_code;
    private String err_msg;
    private T demo;
}
