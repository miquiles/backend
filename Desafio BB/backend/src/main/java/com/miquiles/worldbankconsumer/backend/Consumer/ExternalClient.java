package com.miquiles.worldbankconsumer.backend.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExternalClient {

    private final String URL = "http://api.worldbank.org/v2/country/";

    public Object getIndicatorsByCountry(String code){

        log.info("Find results by code");
        RestTemplate template = new RestTemplate();
        var url = URL + "" + code +"/indicator/SI.POV.DDAY?format=json";
        var response = template.getForEntity(url, Object.class);
        log.info("Response : " + response);

        return response.getBody();


       }

}
