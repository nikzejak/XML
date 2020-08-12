package service.AdminService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService.model.CarModel;
import service.AdminService.repository.CarModelRepo;

import java.util.List;

@Service
public class CarModelService {

    @Autowired
    CarModelRepo carModelRepo;

    public List<CarModel> findall() {return carModelRepo.findAll();}

    public CarModel findCarBrandById(Long id) {return carModelRepo.findCarModelById(id);}

    public CarModel save(CarModel f) { return carModelRepo.save(f);}

    public boolean addCarModel(CarModel f){
        List<CarModel> tmp = findall();
        if(tmp.size() == 0){
            carModelRepo.save(f);
        }
        for(CarModel f1: tmp){
            if(f1.getId() == f.getId()){
                return  false;
            }
            else {
                carModelRepo.save(f);
                return true;
            }
        }
        return false;
    }

    public CarModel getCarModel(String car_model){
        List<CarModel> tmp = findall();
        if(tmp.size() == 0){
            return null;
        }
        for (CarModel f : tmp){
            if(f.getModel().equals(car_model)){
                return f;
            }
        }
        return null;
    }
}
