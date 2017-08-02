package com.geoconverter.geo.service;

public interface YandexMapsRestApiService {
    /**
     * Get json string line from yandex maps rest api service
     *
     * @param geoParam place or geographic coordinates
     * @return json string
     */
    String getGeographicJsonStringFromYandexMapsRestApiService(String geoParam);
}
