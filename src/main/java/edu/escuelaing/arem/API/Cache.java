package edu.escuelaing.arem.API;
import java.util.HashMap;

public class Cache {

    private static final Cache instance = new Cache();
    private HashMap<String, String> cache = new HashMap<>();

    private Cache() {
    }

    /**
     * Funcion que se encarga de insertar en el Map las llaves y los valores
     * @param key llave que se desea insertar
     * @param value valor que se desea insertar
     */
    public void insertCache(String key, String value) {
        cache.put(key, value);
    }

    /***
     * Funcion que retorna el valor contenido en la llave deseada
     * @param key
     * @return
     */
    public String getKey(String key) {
        return cache.get(key);
    }

    /**
     * Funcion que retorna si se encuentra la llave en el Map
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    /**
     * Funcion que retorna el objeto de tipo Cache
     * @return
     */
    public static Cache getInstance() {
        return instance;
    }
}
