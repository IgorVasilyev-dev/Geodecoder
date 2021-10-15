package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class FeatureMemberMetaDataProperty implements Serializable {

    @JsonProperty("GeocoderMetaData")
    private GeocoderMetaData geocoderMetaData;

    public FeatureMemberMetaDataProperty() {
    }

    public FeatureMemberMetaDataProperty(GeocoderMetaData geocoderMetaData) {
        this.geocoderMetaData = geocoderMetaData;
    }

    public GeocoderMetaData getGeocoderMetaData() {
        return geocoderMetaData;
    }

    public void setGeocoderMetaData(GeocoderMetaData geocoderMetaData) {
        this.geocoderMetaData = geocoderMetaData;
    }

    @Override
    public String toString() {
        return "FeatureMemberMetaDataProperty{" +
                "geocoderMetaData=" + geocoderMetaData +
                '}';
    }
}
