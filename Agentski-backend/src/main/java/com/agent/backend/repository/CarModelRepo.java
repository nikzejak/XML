package com.agent.backend.repository;

import com.agent.backend.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarModelRepo extends JpaRepository<CarModel, Long> {

    CarModel findCarModelByModel(String model);
}
