package com.dd.cycad.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bryce_dd 2024/1/6 22:16
 */
public class SimpleCache {

    public static ConcurrentHashMap<String, String> logInfo = new ConcurrentHashMap<>();

    public static String get(String key) {
        return logInfo.get(key);
    }

    public static void put(String key, String val) {
        logInfo.put(key, val);
    }
}
