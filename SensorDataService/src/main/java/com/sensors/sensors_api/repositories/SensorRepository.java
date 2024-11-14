package com.sensors.sensors_api.repositories;

import com.sensors.sensors_api.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
