package com.example.Spring_Security_Bus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring_Security_Bus.entity.Busline;
import org.springframework.stereotype.Repository;


@Repository
public interface BuslineIml extends JpaRepository<Busline, Integer> {
    Busline findOneById(int id);
}
