package by.senla.geolocation.service;

import by.senla.geolocation.model.POJO.Data;
import by.senla.geolocation.service.api.IYandexResponseService;
import by.senla.geolocation.service.property.YandexRequestProperty;
import org.springframework.web.client.RestTemplate;

public class YandexResponseService implements IYandexResponseService {

    private final RestTemplate restTemplate;
    private final YandexRequestProperty yandexRequestProperty;

    public YandexResponseService(RestTemplate restTemplate, YandexRequestProperty yandexRequestProperty) {
        this.restTemplate = restTemplate;
        this.yandexRequestProperty = yandexRequestProperty;
    }

    /**
     * метод получения геоданных
     * @param geoCode - параметр запроса
     * @return объект Data
     */
    @Override
    public Data getResponse(String geoCode) {
        return restTemplate.getForObject(yandexRequestProperty.getBaseUrl() + geoCode, Data.class);
    }

}
