package com.example.demo.model.exception;

import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/11/1 21:16
 **/

public class PreCondition {
    public static void isNotNull(Object obj) {
        if (obj == null) {
            throw new VerifyException(("object can not null"));
        }
    }

    public static void isNotNull(Object obj, String msg) {
        if (obj == null) {
            throw new VerifyException(msg);
        }
    }

    public static <T> void isIn(Set<T> set, T data, String msg) {
        if (!set.contains(data)) {
            throw new VerifyException(msg);
        }
    }

    public static <T> void isIn(Set<T> set, T data) {
        if (!set.contains(data)) {
            throw new VerifyException(String.format("%s is not in the set", data.toString()));
        }
    }
}
