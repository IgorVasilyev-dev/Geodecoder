package by.senla.geolocation.service;

import by.senla.geolocation.model.POJO.Data;
import by.senla.geolocation.model.GeoData;
import by.senla.geolocation.service.api.IGeoConverter;
import by.senla.geolocation.service.api.IYandexResponseService;
import by.senla.geolocation.storage.Cache;
import org.springframework.beans.factory.annotation.Value;

public class GeoConverterService implements IGeoConverter {

    private final Cache cache;
    private final IYandexResponseService yandexResponseService;

    @Value("${yandexGeoProperty.url}")
    private String url;

    @Value("${yandexGeoProperty.apiKey}")
    private String apiKey;

    @Value("${yandexGeoProperty.format}")
    private String format;

    public GeoConverterService(Cache cache, IYandexResponseService yandexResponseService) {
        this.cache = cache;
        this.yandexResponseService = yandexResponseService;
    }

    /**
     * Метод получения геоданных
     * Если данных нет в кэше, то обращаетмся к удаленному сервису
     * @param geoCode - параметр запросса
     * @return объект GeoData, если удаленный сервис не нашел геоданные, возвращаем null
     */
    @Override
    public GeoData getGeoData(String geoCode) {
        if(this.cache.get(geoCode) == null) {
            String response;
            Data data = yandexResponseService.getResponse(url + "?apikey=" + apiKey + "&geocode=" + geoCode + "&format=" + format,geoCode);
            if(data.getResponse().getGeoObjectCollection().getMetaDataProperty().getGeocoderResponseMetaData().getFound() == 0) {
                return null;
            }
            if(data.getResponse().getGeoObjectCollection().getMetaDataProperty().getGeocoderResponseMetaData().getPoint() == null) {
                response = data.getResponse().getGeoObjectCollection().getFeatureMember().get(0)
                        .getGeoObject().getPoint().getPos();
            } else {
                response = data.getResponse().getGeoObjectCollection().getFeatureMember().get(0)
                        .getGeoObject().getMetaDataProperty().getGeocoderMetaData().getText();
            }
            GeoData geoData = new GeoData(geoCode, response, false );
            this.cache.add(geoCode, geoData);
            return geoData;
        }
        GeoData geoData = this.cache.get(geoCode);
        geoData.setUsedCache(true);
        return geoData;
    }
}
