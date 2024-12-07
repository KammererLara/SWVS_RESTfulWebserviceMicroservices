package com.sensors.sensors_api.repositories;

import com.sensors.sensors_api.entities.Measurement;
import com.sensors.sensors_api.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
