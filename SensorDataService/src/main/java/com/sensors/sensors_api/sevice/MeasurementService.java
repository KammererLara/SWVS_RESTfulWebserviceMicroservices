package com.sensors.sensors_api.sevice;

import com.sensors.sensors_api.entities.Measurement;
import com.sensors.sensors_api.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
