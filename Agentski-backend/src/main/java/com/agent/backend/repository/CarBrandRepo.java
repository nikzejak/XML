package com.agent.backend.repository;

import com.agent.backend.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {

    CarBrand findCarBrandById(Long id);
    CarBrand findCarBrandByBrand(String brand);
    List<CarBrand> findAll();
}
