package by.senla.geolocation.service.api;

import by.senla.geolocation.model.GeoData;

public interface IGeoConverter {

    /**
     * Метод получения и кэшированния геоданных
     * Ели геоданных нету в кэше, происходит запрос к удаленному сервису
     * @param geoCode - параметр запросса
     * @return объект GeoData
     */
    GeoData getGeoData(String geoCode);
}
