package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.Car;
import service.AdService.model.CarBrand;

import java.util.List;

public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {

    CarBrand findCarBrandById(Long id);
    CarBrand findCarBrandByBrand(String brand);
    List<CarBrand> findAll();
}
