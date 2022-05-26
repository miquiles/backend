package com.miquiles.worldbankconsumer.backend.controller;

import com.miquiles.worldbankconsumer.backend.Consumer.ExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class RequestController {

    ExternalClient client;

    @GetMapping("/indicators/country/{code}")
    public ResponseEntity get(@PathVariable String code){
        try {
            return new ResponseEntity<>( this.client.getIndicatorsByCountry(code),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }




}
