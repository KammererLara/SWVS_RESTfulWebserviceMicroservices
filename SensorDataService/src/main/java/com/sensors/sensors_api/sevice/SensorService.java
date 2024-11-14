package com.sensors.sensors_api.sevice;

import com.sensors.sensors_api.entities.Sensor;
import com.sensors.sensors_api.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
