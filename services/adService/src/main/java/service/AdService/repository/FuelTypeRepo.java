package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.FuelType;


import java.util.List;

public interface FuelTypeRepo extends JpaRepository<FuelType, Long> {
    List<FuelType> findAll();
    FuelType findFuelTypeById(Long id);
    FuelType findFuelTypeByType(String type);
}
