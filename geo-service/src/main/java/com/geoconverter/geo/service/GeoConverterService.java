package com.geoconverter.geo.service;

import com.geoconverter.geo.dto.GeoObjectDto;
import com.geoconverter.geo.entity.GeoObject;
import org.springframework.stereotype.Component;

@Component
public class GeoConverterService {
    public GeoObject convertToFinalGeoObject(GeoObjectDto geographicObject) {
        String addressLine = geographicObject.getAddressLine();
        String location = geographicObject.getLocation();
        double longitude = Double.parseDouble(geographicObject.getGeoCoordinates().getGeoCoordinates().split(" ")[0]); //долгота
        double latitude = Double.parseDouble(geographicObject.getGeoCoordinates().getGeoCoordinates().split(" ")[1]); //широта
        return new GeoObject(addressLine, location, latitude, longitude);
    }
}
