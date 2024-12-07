package com.sensors.sensors_api.service;

import com.sensors.sensors_api.entities.Measurement;
import com.sensors.sensors_api.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement saveMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public Optional<Measurement> getMeasurementById(int id) {
        return measurementRepository.findById((long) id);
    }

    public void deleteMeasurementById(int id) {
        measurementRepository.deleteById((long) id);
    }
}
