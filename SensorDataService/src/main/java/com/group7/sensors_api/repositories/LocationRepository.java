package com.group7.sensors_api.repositories;

import com.group7.sensors_api.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
