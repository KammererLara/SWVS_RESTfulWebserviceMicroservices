package com.group7.sensors_api.service;

import com.group7.sensors_api.entities.Location;
import com.group7.sensors_api.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Optional<Location> getLocationById(int id) {
        return locationRepository.findById((long) id);
    }
}
