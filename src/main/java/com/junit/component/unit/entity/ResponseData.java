package com.junit.component.unit.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: DengDaoCheng
 * @Date: 2020/9/21 16:03
 */
@Data
public class ResponseData implements Serializable {
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_FAIL = 500;
    private static final long serialVersionUID = -8031562928987198570L;

    private int code;
    private String message;
    private Object data;
    private int timestamp;

    private ResponseData(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = (int) (System.currentTimeMillis()/1000);
    }

    public static ResponseData success(String message) {
        return new ResponseData(CODE_SUCCESS, message, null);
    }

    public static ResponseData success(String message, Object data) {
        return new ResponseData(CODE_SUCCESS, message, data);
    }

    public static ResponseData fail(String message) {
        return new ResponseData(CODE_FAIL, message, null);
    }

    public static ResponseData fail(String message, Object data) {
        return new ResponseData(CODE_FAIL, message, data);
    }

    public static ResponseData fail(int code, String message) {
        return new ResponseData(code, message, null);
    }

    public static ResponseData fail(int code) {
        String message = ErrorCode.messageMap.get(code);
        return new ResponseData(code, message, null);
    }
}
