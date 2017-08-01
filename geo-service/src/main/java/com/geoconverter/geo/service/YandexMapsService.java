package com.geoconverter.geo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geoconverter.geo.dto.GeoObjectDto;
import com.geoconverter.geo.entity.GeoObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class YandexMapsService {

    @Autowired
    private YandexMapsRestApiService yandexMapsRestApiService;
    @Autowired
    private GeoConverterService geoConverterService;
    @Autowired
    private ObjectMapper mapper;

    public List<GeoObject> getGeoInformationByGeoParam(String geoParam) throws IOException {
        List<GeoObject> geoObjects = new ArrayList<>();
        log.debug("get request parameter: {}", geoParam);
        List<JsonNode> yandexMapsJsonObjectResponse =  yandexMapsRestApiService.getGeographicObject(geoParam);
        log.debug("get response from yandex maps rest service: {}", yandexMapsJsonObjectResponse);
        yandexMapsJsonObjectResponse.forEach((JsonNode geoItem) -> {
            geoObjects.add(geoConverterService.convertToFinalGeoObject((mapper.convertValue(geoItem, GeoObjectDto.class))));
        });
        log.debug("object after convertation: {}", geoObjects);
        return geoObjects;
    }

}
