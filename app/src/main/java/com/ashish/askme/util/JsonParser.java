package com.ashish.askme.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class JsonParser {

    public static <T> Object parseJson(String jsonString, Class<T> model) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonString, model);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T[] parseJsonArray(String jsonString, Class<T[]> model) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonString, model);
        } catch (Exception e) {
            L.v("parsing exception" + e.getMessage());
            return null;
        }
    }


    public static String toJson(Object payloadObject) {
        if (payloadObject == null) {
            throw new IllegalArgumentException("Object can not be null");
        }

        try {
            GsonBuilder builder = new GsonBuilder();
            builder.disableHtmlEscaping();
            Gson gson = builder.create();
            return gson.toJson(payloadObject);
        } catch (Exception e) {
            L.v("parsing exception" + e.getMessage());
        }

        return null;
    }
    /*Type listOfTestObject = new TypeToken<List<TestObject>>(){}.getType();
    String s = gson.toJson(list, listOfTestObject);
    List<TestObject> list2 = gson.fromJson(s, listOfTestObject);*/

    public static <T> String toJsonList(List<T> payloadList) {
        if (payloadList == null) {
            throw new IllegalArgumentException("Object list can not be null");
        }

        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<T>>() {
            }.getType();
            return gson.toJson(payloadList, listType);
        } catch (Exception e) {
            L.v("parsing exception" + e.getMessage());
        }

        return null;
    }

    public static <T> List<T> parseJsonList(String jsonList, Type type) {
        if (jsonList == null) {
            throw new IllegalArgumentException("Object list can not be null");
        }

        try {
            Gson gson = new Gson();

            return gson.fromJson(jsonList, type);
        } catch (Exception e) {
        }

        return null;
    }

}
