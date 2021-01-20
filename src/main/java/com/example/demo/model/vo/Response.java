package com.example.demo.model.vo;

import com.example.demo.model.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int status;
    private String msg;
    private T data;

    private static <T> Response response(int status, String msg, T data) {
        return new Response<>(status, msg, data);
    }

    public static <T> Response fail(String msg, T data) {
        return response(ResponseCode.FAIL.getStatus(), msg, data);
    }

    public static <T> Response success() {
        return response(ResponseCode.SUCCESS.getStatus(), ResponseCode.SUCCESS.getMsg(), null);
    }

    public static <T> Response success(T data) {
        return response(ResponseCode.SUCCESS.getStatus(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static <T> Response success(String msg, T data) {
        return response(ResponseCode.SUCCESS.getStatus(), msg, data);
    }

    public static <T> Response forbidden(String msg, T data) {
        return response(ResponseCode.FORBIDDEN.getStatus(), msg, data);
    }

    public static <T> Response badRequest(String msg, T data) {
        return response(ResponseCode.BAD_REQUEST.getStatus(), msg, data);
    }

    public static <T> Response serverError(String msg, T data) {
        return response(ResponseCode.SERVER_ERROR.getStatus(), msg, data);
    }
}
