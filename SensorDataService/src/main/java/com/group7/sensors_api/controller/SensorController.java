package com.group7.sensors_api.controller;

import com.group7.sensors_api.entities.Sensor;
import com.group7.sensors_api.service.SensorService;
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
    public ResponseEntity<?> createSensor(@RequestBody Sensor sensor) {
        if (sensor == null
                || sensor.getName() == null
                || sensor.getLocation() == null
                || sensor.getActive() == null
                || sensor.getType() == null)
            return new ResponseEntity<>("Invalid measurement data", HttpStatus.BAD_REQUEST);

        if (sensorService.getAllSensors().stream().map(Sensor::getId).toList().contains(sensor.getId()))
            return new ResponseEntity<>("Measurement already exists", HttpStatus.NOT_ACCEPTABLE);
        //TODO id kommt direkt schon mit??

        try {
            Sensor createdSensor = sensorService.saveSensor(sensor);
            return new ResponseEntity<>(createdSensor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sensors")
    public ResponseEntity<?> getAllSensors() {
        List<Sensor> sensors = sensorService.getAllSensors();
        if (sensors == null|| sensors.isEmpty())
            return new ResponseEntity<>("No sensors found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(sensors, HttpStatus.OK);
    }

    @GetMapping("/sensor/{id}")
    public ResponseEntity<?> getSensorById(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>("Invalid ID provided", HttpStatus.BAD_REQUEST);

        return sensorService.getSensorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sensor/{sensorName}")
    public ResponseEntity<?> getSensorByName(@PathVariable("sensorName") String sensorName) {
        return sensorService.getSensorByName(sensorName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/sensor")
    public ResponseEntity<?> updateSensor(@RequestBody Sensor sensor) {
        if (sensor == null
                || sensor.getId() <= 0
                || sensor.getName() == null
                || sensor.getLocation() == null
                || sensor.getActive() == null
                || sensor.getType() == null)
            return new ResponseEntity<>("Invalid measurement data", HttpStatus.BAD_REQUEST);

        if (!sensorService.getAllSensors().stream().map(Sensor::getId).toList().contains(sensor.getId()))
            return new ResponseEntity<>("Measurement doesn't exist", HttpStatus.NOT_FOUND);

        try {
            Sensor createdSensor = sensorService.saveSensor(sensor);
            return new ResponseEntity<>(createdSensor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sensor/{id}")
    public ResponseEntity<?> deleteSensor(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>("Invalid ID provided", HttpStatus.BAD_REQUEST);

        if (!sensorService.getAllSensors().stream().map(Sensor::getId).toList().contains(id))
            return new ResponseEntity<>("Measurement doesn't exist", HttpStatus.NOT_FOUND);

        sensorService.deleteSensorById(id);
        return new ResponseEntity<>("Sensor deleted", HttpStatus.OK);
    }
}