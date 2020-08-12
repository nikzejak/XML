package com.agent.backend.services;

import com.agent.backend.model.CarModel;
import com.agent.backend.repository.CarModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarModelService {

    @Autowired
    CarModelRepo carModelRepo;

    public void addCarModel(CarModel carModel){
        carModelRepo.save(carModel);
    }

    public CarModel findCarByModel(String model){
        return carModelRepo.findCarModelByModel(model);
    }

}
