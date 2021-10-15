package by.senla.geolocation.model;

import java.io.Serializable;

public class GeoData implements Serializable {

    private String request;

    private String response;

    private boolean usedCache;

    public GeoData() {
    }

    public GeoData(String request, String response, boolean usedCache) {
        this.request = request;
        this.response = response;
        this.usedCache = usedCache;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isUsedCache() {
        return usedCache;
    }

    public void setUsedCache(boolean usedCache) {
        this.usedCache = usedCache;
    }

    @Override
    public int hashCode() {
        int seed = 1123423414;
        int result = seed  + (((request == null) ? 0 : request.isEmpty() ? 0 : request.hashCode())
                + ((response == null) ? 0 : response.isEmpty() ? 0 : response.hashCode()));
        result ^= result >>> 13;
        result ^= result << 3;
        result ^= result >> 22;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        GeoData otherGeoData = (GeoData) obj;
        return (this.request.equals(otherGeoData.request) || request.equals(otherGeoData.getRequest()))
                && (response.equals(otherGeoData.response) || response.equals(otherGeoData.getResponse()));
    }
}
