package com.geoconverter.geo.service;

import com.geoconverter.geo.dto.GeoObjectDto;
import com.geoconverter.geo.entity.GeoObject;

public interface GeoConverterObjectService {
    /**
     * Convert yandex maps response object to domain object
     *
     * @param geographicObject yandex maps rest api service response object
     * @return domain geo object - GeoObject
     */
    GeoObject convertToFinalGeoObject(GeoObjectDto geographicObject);
}
