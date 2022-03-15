package com.example.Spring_Security_Bus.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring_Security_Bus.entity.Driver;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverIml extends JpaRepository<Driver, Integer> {
    Driver findOneById(int driverId);

}
