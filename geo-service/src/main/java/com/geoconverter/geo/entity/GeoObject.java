package com.geoconverter.geo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeoObject {
    private String addressLine;
    private String location;
    private double latitude;
    private double longitude;
}
