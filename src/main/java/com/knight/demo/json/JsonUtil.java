package com.knight.demo.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Author: 张勤华
 * Date: 14-8-4
 * Time: 下午4:32
 * Desc：Java对象和JSON字符串相互转化工具类
 */
public class JsonUtil {

    private JsonUtil(){}

    /**
     * 对象转换成json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成复杂数据类型
     * @param str
     * @param typeOfT
     * @return
     */
    public static <T> T fromJson(String str, Type typeOfT) {
        Gson gson = new Gson();
        return (T) gson.fromJson(str, typeOfT);
    }
}
