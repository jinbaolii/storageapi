package com.dessert.storageapi.common;

import lombok.Getter;

@Getter
public class ResponseResult<T> {

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回代码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功时候的调用
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(0, "success", data);
    }

    /**
     * 成功时候的调用
     */
    public static ResponseResult success() {
        return new ResponseResult(0, "success", null);
    }

    /**
     * 失败时候的调用
     */
    public static <T> ResponseResult<T> error(ResultCode ResultCode) {
        if (ResultCode == null) {
            return null;
        }
        return new ResponseResult<T>(ResultCode.getCode(), ResultCode.getMsg(), null);
    }
}
