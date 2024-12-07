package com.sensors.sensors_api.service;

import com.sensors.sensors_api.entities.Sensor;
import com.sensors.sensors_api.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor saveSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Optional<Sensor> getSensorById(int id) {
        return sensorRepository.findById((long) id);
    }

    public Optional<Sensor> getSensorByName(String name) {
        return sensorRepository.getSensorByName(name);
    }

    public void deleteSensorById(int id) {
        sensorRepository.deleteById((long) id);
    }
}
