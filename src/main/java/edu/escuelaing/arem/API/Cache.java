package edu.escuelaing.arem.API;
import java.util.HashMap;

public class Cache {

    private static final Cache instance = new Cache();
    private HashMap<String, String> cache = new HashMap<>();

    private Cache() {
    }

    public void insertCache(String key, String value) {
        cache.put(key, value);
    }

    public String getKey(String key) {
        return cache.get(key);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public static Cache getInstance() {
        return instance;
    }
}
