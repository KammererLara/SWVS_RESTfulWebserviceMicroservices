package com.group7.sensors_api.service;

import com.group7.sensors_api.entities.Type;
import com.group7.sensors_api.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public Optional<Type> getTypeById(int id) {
        return typeRepository.findById((long) id);
    }
}
