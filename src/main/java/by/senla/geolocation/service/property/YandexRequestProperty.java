package by.senla.geolocation.service.property;

import org.springframework.beans.factory.annotation.Value;

public class YandexRequestProperty {

    @Value("${yandexGeoProperty.url}")
    private String url;

    @Value("${yandexGeoProperty.apiKey}")
    private String apiKey;

    @Value("${yandexGeoProperty.format}")
    private String format;

    public YandexRequestProperty() {
    }

    public YandexRequestProperty(String url, String apiKey, String format) {
        this.url = url;
        this.apiKey = apiKey;
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getFormat() {
        return format;
    }

    public String getBaseUrl() {
        return url + "?apikey=" + apiKey + "&format=" + format + "&geocode=";
    }

}
