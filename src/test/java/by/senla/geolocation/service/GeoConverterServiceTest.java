package by.senla.geolocation.service;

import by.senla.geolocation.service.api.IGeoConverter;
import by.senla.geolocation.service.property.YandexRequestProperty;
import by.senla.geolocation.storage.Cache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

class GeoConverterServiceTest {

    private static IGeoConverter geoConverter;

    @BeforeAll
    static void init() {
        geoConverter = new GeoConverterService( new Cache(), new YandexResponseService(new RestTemplate(),
                new YandexRequestProperty("https://geocode-maps.yandex.ru/1.x/",
                        "15aaf703-c7c6-4cba-8b5c-5ff7ea891b1a","json" )));
    }

    @ParameterizedTest(name = "{index} Request = {0} : Response = {1}")
    @DisplayName("Проверка геокодирования")
    @MethodSource("valueProvider")
    void checkResponse(String geoCode, String result) {
        Assertions.assertEquals(result, geoConverter.getGeoData(geoCode).getResponse());
    }


    @ParameterizedTest(name = "{index} useCache - {2}; First Request = {0} : Second Request = {1}")
    @DisplayName("Проверка кэширования")
    @MethodSource("valueProviderForCache")
    void checkUseCache(String geoCode, boolean result) {
        Assertions.assertEquals(geoConverter.getGeoData(geoCode).isUsedCache(), result);
    }

    public static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.arguments("37.587093 55.733974", "Россия, Москва, улица Льва Толстого, 16"),
                Arguments.arguments("Москва, улица Льва Толстого, 16", "37.587093 55.733974"),
                Arguments.arguments("27.525773, 53.89079", "Беларусь, Минск, проспект Дзержинского, 5"),
                Arguments.arguments("Минск, ул. Коржа, 7", "27.521847 53.893493"),
                Arguments.arguments("Беларусь, Минск, ул. Коржа, 7", "27.521847 53.893493")
        );
    }

    public static Stream<Arguments> valueProviderForCache() {
        return Stream.of(
                Arguments.arguments("37.587093 55.733974",  true),
                Arguments.arguments("Москва, улица Льва Толстого, 16", true),
                Arguments.arguments("Минск, ул. Коржа, 8", false),
                Arguments.arguments("27.525773, 53.89079",true),
                Arguments.arguments("Беларусь, Минск, ул. Коржа, 7",true),
                Arguments.arguments("37.587093 55.733974",  true),
                Arguments.arguments("Минск, ул. Коржа, 9", false)
        );
    }
}