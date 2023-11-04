package com.sparrow.article.commons;


import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private Map<String, String> map = new HashMap<>();

    private Singleton() {
    }

    private static volatile Singleton singleton;

    public void put(String key, String message) {
        this.map.put(key, message);
    }

    public String getMessage(String key) {
        return this.map.get(key);
    }

    public static Singleton getInstance() {
        if (singleton != null) {
            return singleton;
        }
        //A B
        synchronized (Singleton.class) {
            if (singleton != null) {
                return singleton;
            }
            singleton = new Singleton();
            return singleton;
        }
    }
}
