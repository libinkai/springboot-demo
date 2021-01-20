package com.example.demo.service.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @Author: Equator
 * @Date: 2020/11/1 22:01
 **/

public class JsonUtil {
    public static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    public static final Gson nullableGson = new GsonBuilder().serializeNulls().create();

    public static <T> T fromJson(String str, Class<T> classOfT) {
        return gson.fromJson(str, classOfT);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static boolean isEmpty(JsonObject jsonObject, String memberName) {
        JsonElement jsonElement = jsonObject.get(memberName);
        return jsonElement == null || jsonElement.isJsonNull();
    }
}
