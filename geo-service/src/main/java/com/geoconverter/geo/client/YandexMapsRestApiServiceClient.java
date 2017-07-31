package com.geoconverter.geo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${yandex.url}", name = "yandex-maps")
public interface YandexMapsRestApiServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getCountryInfo(@RequestParam("geocode") String geocode, @RequestParam("format") String format);
}


