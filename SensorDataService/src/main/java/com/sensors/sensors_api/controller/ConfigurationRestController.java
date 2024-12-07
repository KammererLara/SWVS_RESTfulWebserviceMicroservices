package com.sensors.sensors_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigurationRestController {
    @Value("${message:default}")
    private String message;

    @RequestMapping("/message")
    String getMessage(){
        return this.message;
    }
}

//TODO: kann entfernt werden - mein Port wird schon von Configurationserver bezogen - brauche ich sonst noch was?
// Controller nötig? kann weg?
