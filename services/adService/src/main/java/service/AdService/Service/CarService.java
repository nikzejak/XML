package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.Car;
import service.AdService.repository.CarRepo;

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
