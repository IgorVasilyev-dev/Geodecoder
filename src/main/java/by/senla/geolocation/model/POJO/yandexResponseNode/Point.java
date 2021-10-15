package by.senla.geolocation.model.POJO.yandexResponseNode;

import java.io.Serializable;

public class Point implements Serializable {

    private String pos;

    public Point() {
    }

    public Point(String pos) {
        this.pos = pos;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pos='" + pos + '\'' +
                '}';
    }
}
