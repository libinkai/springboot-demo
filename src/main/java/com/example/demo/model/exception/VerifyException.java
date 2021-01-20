package com.example.demo.model.exception;

/**
 * @Author: Equator
 * @Date: 2020/11/1 21:10
 **/

public class VerifyException extends RuntimeException {
    public VerifyException(String msg) {
        super(msg);
    }
}
