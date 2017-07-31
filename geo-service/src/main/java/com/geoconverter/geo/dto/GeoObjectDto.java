package com.geoconverter.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObjectDto {
    @JsonProperty("description")
    private String addressLine;
    @JsonProperty("name")
    private String location;
    @JsonProperty("Point")
    private GeoObjectsDto geoCoordinates;
}

