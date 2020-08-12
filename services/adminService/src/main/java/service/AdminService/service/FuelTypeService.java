package service.AdminService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService.model.FuelType;
import service.AdminService.repository.FuelTypeRepo;

import java.util.List;

@Service
public class FuelTypeService {

    @Autowired
    FuelTypeRepo fuelTypeRepo;

    public List<FuelType> findall() {return fuelTypeRepo.findAll();}

    public FuelType findFuelTypeById(Long id) {return fuelTypeRepo.findFuelTypeById(id);}

    public FuelType save(FuelType f) { return fuelTypeRepo.save(f);}

    public boolean addFuelType(FuelType f){
        List<FuelType> tmp = findall();
        if(tmp.size() == 0){
            fuelTypeRepo.save(f);
        }
        for(FuelType f1: tmp){
            if(f1.getId() == f.getId()){
                return  false;
            }
            else {
                fuelTypeRepo.save(f);
                return true;
            }
        }
        return false;
    }

    public FuelType getFuelType(String serialNumber){
        List<FuelType> tmp = findall();
        if(tmp.size() == 0){
            return null;
        }
        for (FuelType f : tmp){
            if(f.getSerialNumber().equals(serialNumber)){
                return f;
            }
        }
        return null;
    }
}
