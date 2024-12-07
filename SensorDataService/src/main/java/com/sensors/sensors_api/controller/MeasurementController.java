package com.sensors.sensors_api.controller;

import com.sensors.sensors_api.entities.Measurement;
import com.sensors.sensors_api.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/measurementApi")
@RestController
public class MeasurementController {
    @Autowired
    private MeasurementService measurementService;

    @PostMapping("/createMeasurement")
    public ResponseEntity<Measurement> createmeasurement(@RequestBody Measurement measurement) {
        Measurement createdMeasurement = measurementService.saveMeasurement(measurement);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
    }

    @GetMapping("/measurements")
    public List<Measurement> getAllmeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/measurement/{id}")
    public ResponseEntity<Measurement> getmeasurementById(@PathVariable("id") int id) {
        return measurementService.getMeasurementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/measurement")
    public ResponseEntity<Measurement> updatemeasurement(@RequestBody Measurement measurement) {
        Measurement createdMeasurement = measurementService.saveMeasurement(measurement);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.OK);
    }

    @DeleteMapping("/measurement/{id}")
    public HttpStatus deleteMeasurement(@PathVariable("id") int id) {
        measurementService.deleteMeasurementById(id);
        return HttpStatus.OK;
    }
}

//TODO: vll mit Swagger UI?


//TODO: CRUD funktionen implementieren
// create check
// readAll check
// read -> findById/findAllById
// update -> save mit bereits existenter Id
// delete -> deleteById/deleteAllById/deleteAll