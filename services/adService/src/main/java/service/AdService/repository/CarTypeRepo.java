package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.CarType;

public interface CarTypeRepo extends JpaRepository<CarType, Long> {

    CarType findCarTypeByType(String type);
}
