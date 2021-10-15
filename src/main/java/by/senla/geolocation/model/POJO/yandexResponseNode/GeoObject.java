package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName("GeoObject")
public class GeoObject implements Serializable {

    private FeatureMemberMetaDataProperty metaDataProperty;

    @JsonProperty("Point")
    private Point point;

    public GeoObject() {
    }

    public FeatureMemberMetaDataProperty getMetaDataProperty() {
        return metaDataProperty;
    }

    public void setMetaDataProperty(FeatureMemberMetaDataProperty metaDataProperty) {
        this.metaDataProperty = metaDataProperty;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "GeoObject{" +
                "metaDataProperty=" + metaDataProperty +
                ", point=" + point +
                '}';
    }
}
