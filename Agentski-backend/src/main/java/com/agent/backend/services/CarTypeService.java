package com.agent.backend.services;

import com.agent.backend.model.CarType;
import com.agent.backend.repository.CarTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarTypeService {

    @Autowired
    CarTypeRepo carTypeRepo;

    public List<CarType> findall() {return carTypeRepo.findAll();}

    public CarType findCarTypeById(Long id) {return carTypeRepo.findCarTypeById(id);}

    public CarType save(CarType f) { return carTypeRepo.save(f);}

    public boolean addCarType(CarType f){
        List<CarType> tmp = findall();
        if(tmp.size() == 0){
            carTypeRepo.save(f);
        }
        for(CarType f1: tmp){
            if(f1.getId() == f.getId()){
                return  false;
            }
            else {
                carTypeRepo.save(f);
                return true;
            }
        }
        return false;
    }

    public CarType getCarType(String car_type){
        List<CarType> tmp = findall();
        if(tmp.size() == 0){
            return null;
        }
        for (CarType f : tmp){
            if(f.getType().equals(car_type)){
                return f;
            }
        }
        return null;
    }

    public CarType findByType(String type){
        return carTypeRepo.findCarTypeByType(type);
    }
}
