package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GeoObjectWrapper implements Serializable {

    @JsonProperty("GeoObject")
    private GeoObject geoObject;

    public GeoObjectWrapper() {
    }

    public GeoObjectWrapper(GeoObject geoObject) {
        this.geoObject = geoObject;
    }

    public GeoObject getGeoObject() {
        return geoObject;
    }

    public void setGeoObject(GeoObject geoObject) {
        this.geoObject = geoObject;
    }

    @Override
    public String toString() {
        return "GeoObjectWrapper{" +
                "geoObject=" + geoObject +
                '}';
    }
}
