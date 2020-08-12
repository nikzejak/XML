package com.agent.backend.repository;



import com.agent.backend.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelTypeRepo extends JpaRepository<FuelType, Long> {
    List<FuelType> findAll();
    FuelType findFuelTypeById(Long id);
    FuelType findFuelTypeByType(String type);
}
