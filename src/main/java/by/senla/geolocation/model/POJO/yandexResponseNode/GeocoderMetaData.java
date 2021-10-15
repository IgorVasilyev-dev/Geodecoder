package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderMetaData implements Serializable {

    private String text;

    public GeocoderMetaData() {
    }

    public GeocoderMetaData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "GeocoderMetaData{" +
                "text='" + text + '\'' +
                '}';
    }
}
