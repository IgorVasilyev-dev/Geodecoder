package by.senla.geolocation.config;

import by.senla.geolocation.service.GeoConverterService;
import by.senla.geolocation.service.property.YandexRequestProperty;
import by.senla.geolocation.service.YandexResponseService;
import by.senla.geolocation.service.api.IGeoConverter;
import by.senla.geolocation.service.api.IYandexResponseService;
import by.senla.geolocation.storage.Cache;
import by.senla.geolocation.storage.api.ICache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("by.senla.geolocation.config")
public class RootConfig {


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ICache cache() {
        return new Cache();
    }

    @Bean
    YandexRequestProperty yandexRequestProperty() {
        return new YandexRequestProperty();
    }

    @Bean
    IYandexResponseService yandexResponseService(RestTemplate restTemplate, YandexRequestProperty yandexRequestProperty) {
        return new YandexResponseService(restTemplate, yandexRequestProperty);
    }

    @Bean
    IGeoConverter geoConverter(ICache cache, IYandexResponseService yandexResponseService) {
        return new GeoConverterService(cache, yandexResponseService);
    }
}
