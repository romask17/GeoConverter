package com.geoconverter.geo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.geoconverter.geo.client.YandexMapsRestApiServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class YandexMapsRestApiService {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private YandexMapsRestApiServiceClient client;

    public List<JsonNode> getGeographicObject(String requestParam) throws IOException {
        String responseFormat = "json";
        String yandexMapsJsonStringResponse = client.getCountryInfo(requestParam, responseFormat);
        return mapper.readValue(yandexMapsJsonStringResponse, ObjectNode.class).findValues("GeoObject");
    }
}
