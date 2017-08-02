package com.geoconverter.geo.service;

import com.geoconverter.geo.client.YandexMapsRestApiServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YandexMapsRestApiServiceImpl implements YandexMapsRestApiService {
    @Autowired
    private YandexMapsRestApiServiceClient client;

    public String getGeographicJsonStringFromYandexMapsRestApiService(String requestParam) {
        String responseFormat = "json";
        return client.getCountryInfo(requestParam, responseFormat);
    }
}