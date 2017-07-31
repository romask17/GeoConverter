package com.geoconverter.geo.controllers;

import com.geoconverter.geo.entity.GeoObject;
import com.geoconverter.geo.service.YandexMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeoConvertController {

    @Autowired
    private YandexMapsService yandexMapsService;

    @RequestMapping(method = RequestMethod.GET, path = "/{geoParam}")
    public List<GeoObject> getGeoInformationByGeoparam(@PathVariable String geoParam) throws Exception {
        return yandexMapsService.getGeoInformationByGeoParam(geoParam);

    }
}
