package by.senla.geolocation.model.POJO;

import by.senla.geolocation.model.POJO.yandexResponseNode.YandexResponse;

import java.io.Serializable;

public class Data implements Serializable {

    private YandexResponse response;

    public Data() {
    }

    public Data(YandexResponse response) {
        this.response = response;
    }

    public YandexResponse getResponse() {
        return response;
    }

    public void setResponse(YandexResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Data{" +
                "response=" + response +
                '}';
    }
}
