package by.senla.geolocation.storage;

import by.senla.geolocation.model.GeoData;
import by.senla.geolocation.storage.api.ICache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache implements ICache {

    private final Map<String, GeoData> cache = new ConcurrentHashMap<>();

    /**
     * Добавить объект GeoData в кэш
     * @param key - ключ
     * @param val - значение
     */
    public void add(String key, GeoData val) {
        cache.put(key, val);
    }

    /**
     * Получить объект GeoData из кэша
     * @param key - ключ объекта
     * @return объект GeoData
     */
    public GeoData get(String key) {
        return this.cache.get(key);
    }

}
