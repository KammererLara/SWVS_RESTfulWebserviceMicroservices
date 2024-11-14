package com.sensors.sensors_api.controller;

import com.sensors.sensors_api.entities.Sensor;
import com.sensors.sensors_api.sevice.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @PostMapping
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        Sensor createdSensor = sensorService.saveSensor(sensor);
        return new ResponseEntity<>(createdSensor, HttpStatus.CREATED);
    }

    //TODO: CRUD funktionen implementieren
    // create check
    // readAll check
    // read -> findById/findAllById
    // update -> save mit bereits existenter Id
    // delete -> deleteById/deleteAllById/deleteAll
}
