package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.CarModel;

public interface CarModelRepo extends JpaRepository<CarModel, Long> {

    CarModel findCarModelByModel(String model);
}
