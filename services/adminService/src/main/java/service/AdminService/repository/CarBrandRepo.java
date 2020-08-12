package service.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdminService.model.CarBrand;

import java.util.List;

public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {
    List<CarBrand> findAll();
    CarBrand findCarBrandById(Long id);
    CarBrand findCarBrandByBrand(String brand);

    //List<CarBrand> findAllByBrand(String brand);
    //List<CarBrand> findAllEndCarBrands(CarBrand brand);
}
