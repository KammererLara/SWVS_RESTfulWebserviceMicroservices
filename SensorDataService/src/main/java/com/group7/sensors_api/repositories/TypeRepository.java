package com.group7.sensors_api.repositories;

import com.group7.sensors_api.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
