package com.sensors.sensors_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRegistryClientRestController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Sensor Service!";
    }
}