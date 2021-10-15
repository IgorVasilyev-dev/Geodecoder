package by.senla.geolocation.controller.REST;

import by.senla.geolocation.error.ApiError;
import by.senla.geolocation.model.GeoData;
import by.senla.geolocation.service.api.IGeoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/geolocation")
public class GeolocationRestServlet {

    private final IGeoConverter geoConverter;

    public GeolocationRestServlet(IGeoConverter geoConverter) {
        this.geoConverter = geoConverter;
    }

    @GetMapping(produces = {"application/json"})
    protected ResponseEntity<Object> getGeolocation(@RequestParam String geoCode) {
        try {
            GeoData geoData = geoConverter.getGeoData(geoCode);
            if (geoData == null) {
                return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST,
                        "Not found Entity", "no results on request 'geoCode' = '" + geoCode + "'"));
            }
            return ResponseEntity.ok().body(geoData);
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.internalServerError().body(new ApiError(exception.getStatusCode(),
                    "Error request from remote server", exception.getMessage()));
        } catch (Throwable throwable) {
            return ResponseEntity.internalServerError().body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Internal Server Error", throwable.getMessage()));
        }
    }
}