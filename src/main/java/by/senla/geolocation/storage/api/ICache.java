package by.senla.geolocation.storage.api;

import by.senla.geolocation.model.GeoData;

public interface ICache {

    /**
     * Метод добавления объекта GeoData в кэш
     * @param key - ключ
     * @param val - значение
     */
     void add(String key, GeoData val);

    /**
     * Метод получения объекта из кэша
     * @param key - ключ объекта
     * @return объект типа GeoData
     */
     GeoData get(String key);
}
