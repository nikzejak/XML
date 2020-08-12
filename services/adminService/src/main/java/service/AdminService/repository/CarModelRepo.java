package service.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdminService.model.CarModel;

import java.util.List;

public interface CarModelRepo extends JpaRepository<CarModel, Long> {
    List<CarModel> findAll();
    CarModel findCarModelById(Long id);
}
