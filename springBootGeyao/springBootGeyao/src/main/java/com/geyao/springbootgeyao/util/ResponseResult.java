package com.geyao.springbootgeyao.util;
public class ResponseResult<T> {
    private int code; // 状态码
    private String message; // 消息
    private T data; // 数据

    // 构造方法
    public ResponseResult() {}

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功时的静态方法
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "成功", data);
    }

    // 失败时的静态方法
    public static <T> ResponseResult<T> failure(int code, String message) {
        return new ResponseResult<>(code, message, null);
    }

    // Getter 和 Setter 方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
