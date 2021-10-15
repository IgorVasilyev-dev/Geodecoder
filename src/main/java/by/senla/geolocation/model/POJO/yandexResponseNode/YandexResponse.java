package by.senla.geolocation.model.POJO.yandexResponseNode;

import by.senla.geolocation.model.POJO.yandexResponseNode.GeoObjectCollection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexResponse implements Serializable {

    @JsonProperty("GeoObjectCollection")
    GeoObjectCollection geoObjectCollection;

    public YandexResponse() {
    }

    public YandexResponse(GeoObjectCollection geoObjectCollection) {
        this.geoObjectCollection = geoObjectCollection;
    }

    public GeoObjectCollection getGeoObjectCollection() {
        return geoObjectCollection;
    }

    public void setGeoObjectCollection(GeoObjectCollection geoObjectCollection) {
        this.geoObjectCollection = geoObjectCollection;
    }

    @Override
    public String toString() {
        return "YandexResponse{" +
                "geoObjectCollection=" + geoObjectCollection +
                '}';
    }
}
