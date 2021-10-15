package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResponseMetaData implements Serializable {
    @JsonProperty("Point")
    private Point point;

    private String request;

    private int found;

    public GeocoderResponseMetaData() {
    }

    public GeocoderResponseMetaData(Point point, String request, int found) {
        this.point = point;
        this.request = request;
        this.found = found;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }
}
