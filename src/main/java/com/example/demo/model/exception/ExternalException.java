package com.example.demo.model.exception;

/**
 * @Author: Equator
 * @Date: 2020/11/3 23:07
 **/

public class ExternalException extends RuntimeException {
    public ExternalException(String msg) {
        super(msg);
    }
}
