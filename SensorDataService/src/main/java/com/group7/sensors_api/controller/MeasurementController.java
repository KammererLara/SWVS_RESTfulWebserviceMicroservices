package com.group7.sensors_api.controller;

import com.group7.sensors_api.entities.Measurement;
import com.group7.sensors_api.service.MeasurementService;
import com.group7.sensors_api.service.SensorService;
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
    @Autowired
    private SensorService sensorService;

    @PostMapping("/createMeasurement")
    public ResponseEntity<?> createMeasurement(@RequestBody Measurement measurement) {
        if (measurement == null
                || measurement.getTimestamp() == null
                || measurement.getSensor() == null)
            return new ResponseEntity<>("Invalid measurement data", HttpStatus.BAD_REQUEST);

        if (sensorService.getSensorById(measurement.getSensor().getId()).isEmpty())
            return new ResponseEntity<>("Sensor not found", HttpStatus.NOT_FOUND);

        if (measurement.getId() != 0)
            return new ResponseEntity<>("Id has to be created from backend", HttpStatus.NOT_ACCEPTABLE);

        try {
            measurement.setSensor(sensorService.getSensorById(measurement.getSensor().getId()).orElseThrow());
            Measurement createdMeasurement = measurementService.saveMeasurement(measurement);
            return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/measurements")
    public ResponseEntity<?> getAllMeasurements() {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        if (measurements == null|| measurements.isEmpty())
            return new ResponseEntity<>("No measurements found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(measurements, HttpStatus.OK);
    }

    @GetMapping("/measurement/{id}")
    public ResponseEntity<?> getMeasurementById(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>("Invalid ID provided", HttpStatus.BAD_REQUEST);

        return measurementService.getMeasurementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/measurement")
    public ResponseEntity<?> updateMeasurement(@RequestBody Measurement measurement) {
        if (measurement == null
                || measurement.getId() <= 0
                || measurement.getTimestamp() == null
                || measurement.getSensor() == null)
            return new ResponseEntity<>("Invalid measurement data", HttpStatus.BAD_REQUEST);

        if (!measurementService.getAllMeasurements().stream().map(Measurement::getId).toList().contains(measurement.getId()))
            return new ResponseEntity<>("Measurement doesn't exist", HttpStatus.NOT_FOUND);

        if (sensorService.getSensorById(measurement.getSensor().getId()).isEmpty())
            return new ResponseEntity<>("Sensor not found", HttpStatus.NOT_FOUND);

        try {
            measurement.setSensor(sensorService.getSensorById(measurement.getSensor().getId()).orElseThrow());
            Measurement createdMeasurement = measurementService.saveMeasurement(measurement);
            return new ResponseEntity<>(createdMeasurement, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/measurement/{id}")
    public ResponseEntity<String> deleteMeasurement(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>("Invalid ID provided", HttpStatus.BAD_REQUEST);

        if (!measurementService.getAllMeasurements().stream().map(Measurement::getId).toList().contains(id))
            return new ResponseEntity<>("Measurement doesn't exist", HttpStatus.NOT_FOUND);

        measurementService.deleteMeasurementById(id);
        return new ResponseEntity<>("Measurement deleted", HttpStatus.OK);
    }
}