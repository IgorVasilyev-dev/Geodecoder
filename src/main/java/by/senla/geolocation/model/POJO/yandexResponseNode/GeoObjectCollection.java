package by.senla.geolocation.model.POJO.yandexResponseNode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObjectCollection implements Serializable {

    private MetaDataProperty metaDataProperty;

    private List<GeoObjectWrapper> featureMember;

    public GeoObjectCollection() {
    }

    public GeoObjectCollection(MetaDataProperty metaDataProperty, List<GeoObjectWrapper> featureMember) {
        this.metaDataProperty = metaDataProperty;
        this.featureMember = featureMember;
    }

    public MetaDataProperty getMetaDataProperty() {
        return metaDataProperty;
    }

    public void setMetaDataProperty(MetaDataProperty metaDataProperty) {
        this.metaDataProperty = metaDataProperty;
    }

    public List<GeoObjectWrapper> getFeatureMember() {
        return featureMember;
    }

    public void setFeatureMember(List<GeoObjectWrapper> featureMember) {
        this.featureMember = featureMember;
    }
}
