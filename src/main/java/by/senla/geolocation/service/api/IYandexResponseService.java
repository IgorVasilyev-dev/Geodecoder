package by.senla.geolocation.service.api;

import by.senla.geolocation.model.POJO.Data;

public interface IYandexResponseService {

     /**
      * метод получения геоданных от Уandex geoDecoder APi
      * @param geoCode - параметр запроса
      * @return геоданные типа Data
      */
     Data getResponse(String geoCode);

}
