package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.CarModel;
import service.AdService.repository.CarModelRepo;

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
