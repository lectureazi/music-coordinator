package com.mc.musiccoordinator.infra.llm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ResponseFormat<T> {

    private final Class<T> clazz;

    public ResponseFormat(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String formatToJson(){
        Gson gson = new GsonBuilder().serializeNulls().create();
        try {
            Constructor<T> constructor = clazz.getConstructor();
            T instance = constructor.newInstance();
            return gson.toJson(instance)
                    .replaceAll("\"","'")
                    .replaceAll("null","''");

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
