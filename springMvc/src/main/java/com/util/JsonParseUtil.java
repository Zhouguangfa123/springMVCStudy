package com.util;

import com.bean.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JsonUtil json工具类
 *
 * @author zhougf
 * @date 2019/5/22
 */
public class JsonParseUtil {
    /** 创建Gson对象*/
    private static final Gson GSON = new Gson();

    private static final Gson GSON1 = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();

    /**
     * jsonStrToJsonObj json字符串转换成jsonObject
     * @param jsonStr son字符串转
     * @return JsonObject
     */
    private static JsonObject jsonStrToJsonObj(String jsonStr) {
        return GSON.fromJson(jsonStr, JsonObject.class);
    }

    /**
     * jsonStrToJsonObj json字符串转换成jsonObject
     * @param jsonStr son字符串转
     * @return Type
     */
    public static <T> T jsonToBean(String jsonStr, Class<T> clazz) {
        return GSON.fromJson(jsonStr, clazz);
    }

    /**
     * beanToJsonObject bean对象转换成jsonObject
     * @param object bean对象
     * @return JsonObject
     */
    public static JsonObject beanToJsonObject(Object object) {
        return GSON.toJsonTree(object).getAsJsonObject();
    }

    /**
     * listToJsonArray bean对象转换成JsonArray
     * @param object bean对象
     * @return JsonArray
     */
    public static JsonArray listToJsonArray(Object object) {

        return GSON.toJsonTree(object).getAsJsonArray();
    }

    public static void main(String[] args) {
        String jsonStr = "{\"name\":\"zhougaugnfa\", \"id\":\"1\"}";
////        JsonObject jsonObject = jsonStrToJsonObj("{\"name\":\"zhougaugnfa\"}");
////        System.out.println(jsonObject.toString());
//        System.out.println(jsonToBean(jsonStr, User.class));
        User user = new User();
        user.setAge(0);
        user.setName("zhou");
        user.setBirthDay(new Date());
        List<User> list = new ArrayList<User>();
        list.add(user);
        System.out.println(listToJsonArray(list));
    }
}
