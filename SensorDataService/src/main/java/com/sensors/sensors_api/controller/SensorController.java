package com.sensors.sensors_api.controller;

import com.sensors.sensors_api.entities.Sensor;
import com.sensors.sensors_api.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sensorApi")
@RestController
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping("/createSensor")
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        Sensor createdSensor = sensorService.saveSensor(sensor);
        return new ResponseEntity<>(createdSensor, HttpStatus.CREATED);
    }

    @GetMapping("/sensors")
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/sensor/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable("id") int id) {
        return sensorService.getSensorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sensor/{sensorName}")
    public ResponseEntity<Sensor> getSensorByName(@PathVariable("sensorName") String sensorName) {
        return sensorService.getSensorByName(sensorName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/sensor")
    public ResponseEntity<Sensor> updateSensor(@RequestBody Sensor sensor) {
        Sensor createdSensor = sensorService.saveSensor(sensor);
        return new ResponseEntity<>(createdSensor, HttpStatus.OK);
    }

    @DeleteMapping("/sensor/{id}")
    public HttpStatus deleteSensor(@PathVariable("id") int id) {
        sensorService.deleteSensorById(id);
        return HttpStatus.OK;
    }
}
