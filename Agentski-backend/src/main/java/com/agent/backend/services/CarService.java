package com.agent.backend.services;

import com.agent.backend.model.Car;
import com.agent.backend.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    @Autowired
    CarRepo carRepo;

    public void addCar(Car car){
        carRepo.save(car);
    }

    public Car findCar(Long id){
        return carRepo.findCarById(id);
    }
}
