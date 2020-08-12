package com.agent.backend.repository;

import com.agent.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {


    List<Car> findAll();
    Car findCarById(Long id);
}
