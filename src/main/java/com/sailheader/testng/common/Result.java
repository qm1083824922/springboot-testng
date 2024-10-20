package com.sailheader.testng.common;

import lombok.Data;

/**
 * @author Porsche
 * @Date 2024/10/20 11:04
 */
@Data
public class Result<T> {
    /**
     * 状态码
     */
    int code;
    /**
     * 消息
     */
    String message;
    /**
     * 数据
     */
    T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(int code,String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String message, T data) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(int code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
