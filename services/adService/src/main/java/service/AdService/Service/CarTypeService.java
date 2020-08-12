package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.CarType;
import service.AdService.repository.CarTypeRepo;

@Service
public class CarTypeService {

    @Autowired
    CarTypeRepo carTypeRepo;

    public void addType(CarType carType){
        carTypeRepo.save(carType);
    }

    public CarType findByType(String type){
        return carTypeRepo.findCarTypeByType(type);
    }
}
