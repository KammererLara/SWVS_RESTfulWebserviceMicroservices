package com.sensors.sensors_api.repositories;

import com.sensors.sensors_api.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Query("SELECT u FROM Sensor u WHERE u.name = :name")
    public Optional<Sensor> getSensorByName(@Param("name") String name);
}
