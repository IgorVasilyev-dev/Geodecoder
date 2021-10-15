package by.senla.geolocation.config;

import by.senla.geolocation.service.GeoConverterService;
import by.senla.geolocation.service.YandexResponseService;
import by.senla.geolocation.service.api.IGeoConverter;
import by.senla.geolocation.service.api.IYandexResponseService;
import by.senla.geolocation.storage.Cache;
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
    Cache cache() {
        return new Cache();
    }

    @Bean
    IYandexResponseService yandexResponseService(RestTemplate restTemplate) {
        return new YandexResponseService(restTemplate);
    }

    @Bean
    IGeoConverter geoConverter(Cache cache, IYandexResponseService yandexResponseService) {
        return new GeoConverterService(cache, yandexResponseService);
    }
}
