package com.junit.component.unit.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * @Author: DengDaoCheng
 * @Date: 2020/9/21 16:02
 */
@Data
public class ErrorCode {
    /**
     * 通用错误码
     */
    public static final int DATA_EMPTY = 404;
    public static final int REQUEST_FAIL = 500;

    /**
     * 参数错误
     */
    public static final int DATA_ERROR = 10001;

    /**
     * 认证
     */
    public static final int AUTH_FAIL = 10002;

    public static HashMap<Integer, String> messageMap = new HashMap<>();

    static {
        messageMap.put(DATA_EMPTY, "数据为空");
        messageMap.put(REQUEST_FAIL, "请求内部错误");
        messageMap.put(AUTH_FAIL, "请重新登录");
    }
}
