package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.FuelType;
import service.AdService.repository.FuelTypeRepo;


@Service
public class FuelTypeService {

    @Autowired
    FuelTypeRepo fuelTypeRepo;


    public FuelType save(FuelType f) { return fuelTypeRepo.save(f);}

    public FuelType findFuelByType(String type){
        return fuelTypeRepo.findFuelTypeByType(type);
    }

}
