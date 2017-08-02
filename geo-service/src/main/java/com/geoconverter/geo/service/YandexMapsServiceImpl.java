package com.geoconverter.geo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
public class YandexMapsServiceImpl implements YandexMapsService {

    @Autowired
    private YandexMapsRestApiService yandexMapsRestApiService;
    @Autowired
    private GeoConverterObjectService geoConverterService;
    @Autowired
    private ObjectMapper mapper;

    public List<GeoObject> getGeoInformationByGeoParam(String geoParam) throws IOException {
        List<GeoObject> geoObjects = new ArrayList<>();
        log.debug("get request parameter: {}", geoParam);
        String yandexMapsJsonStringResponse =  yandexMapsRestApiService.getGeographicJsonStringFromYandexMapsRestApiService(geoParam);
        List<JsonNode> yandexMapsJsonObjectResponse = mapper.readValue(yandexMapsJsonStringResponse, ObjectNode.class).findValues("GeoObject");
        log.debug("get response from yandex maps rest service: {}", yandexMapsJsonStringResponse);
        yandexMapsJsonObjectResponse.forEach((JsonNode geoItem) -> {
            geoObjects.add(geoConverterService.convertToFinalGeoObject((mapper.convertValue(geoItem, GeoObjectDto.class))));
        });
        log.debug("object after convertation: {}", geoObjects);
        return geoObjects;
    }
}
