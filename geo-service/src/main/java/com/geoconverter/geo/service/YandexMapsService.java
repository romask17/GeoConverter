package com.geoconverter.geo.service;

import com.geoconverter.geo.entity.GeoObject;

import java.io.IOException;
import java.util.List;

public interface YandexMapsService {
    /**
     * Convert geo place to geographic coordinates and vice versa
     *
     * @param geoParam to be converted
     * @return converted geoParam
     * @throws IOException
     */
    List<GeoObject> getGeoInformationByGeoParam(String geoParam) throws IOException;
}
