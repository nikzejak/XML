package com.agent.backend.repository;


import com.agent.backend.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarTypeRepo extends JpaRepository<CarType, Long> {
    List<CarType> findAll();
    CarType findCarTypeById(Long id);
    CarType findCarTypeByType(String type);
}
