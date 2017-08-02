package com.geoconverter.geo.controllers;

import com.geoconverter.geo.entity.GeoObject;
import com.geoconverter.geo.service.YandexMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GeoConvertController {

    @Autowired
    private YandexMapsService yandexMapsService;

    @RequestMapping(method = RequestMethod.GET, path = "/convert")
    public List<GeoObject> getGeoInformationByGeoparam(@RequestParam("geoparam") String geoParam) throws IOException {
        return yandexMapsService.getGeoInformationByGeoParam(geoParam);

    }
}
