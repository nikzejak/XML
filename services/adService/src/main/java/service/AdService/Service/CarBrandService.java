package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.CarBrand;
import service.AdService.repository.CarBrandRepo;

import java.util.List;


@Service
public class CarBrandService {

       @Autowired
       CarBrandRepo carBrandRepo;

   public void addCarBrand(CarBrand carBrand){
       carBrandRepo.save(carBrand);
   }

//   public CarBrand findOneCarBrand(String car_brand){
//       return carBrandRepo.findCarBrandByCar_brand(car_brand);
//   }
    public CarBrand findByID(Long Id){
       return carBrandRepo.findCarBrandById(Id);
    }

    public CarBrand findCarByBrand(String brand){
        return carBrandRepo.findCarBrandByBrand(brand);
    }
    public List<CarBrand> findall() {
        return  carBrandRepo.findAll();
    }
}
