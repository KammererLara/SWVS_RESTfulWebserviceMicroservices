package com.sensors.sensors_api.repositories;

import com.sensors.sensors_api.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
