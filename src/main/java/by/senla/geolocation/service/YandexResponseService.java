package by.senla.geolocation.service;

import by.senla.geolocation.model.POJO.Data;
import by.senla.geolocation.service.api.IYandexResponseService;
import org.springframework.web.client.RestTemplate;

public class YandexResponseService implements IYandexResponseService {

    private final RestTemplate restTemplate;

    public YandexResponseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Data getResponse(String url, String geoCode) {
        return restTemplate.getForObject(url, Data.class);
    }

}
