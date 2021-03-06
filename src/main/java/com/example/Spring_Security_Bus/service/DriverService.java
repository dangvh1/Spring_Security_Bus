package com.example.Spring_Security_Bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Spring_Security_Bus.entity.Driver;
import com.example.Spring_Security_Bus.repository.DriverIml;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverIml driverIml;

    public List<Driver> getListDriver() {
        return driverIml.findAll();
    }

    public Driver insertDriver(Driver driver) {
        return driverIml.save(driver);
    }
    public void removeDriver(int id){
        driverIml.deleteById(id);
    }

    public void updateDriver(Driver driver) {
        driverIml.save(driver);
    }

    public Driver getById(int id){
        return driverIml.findOneById(id);
    }
}
