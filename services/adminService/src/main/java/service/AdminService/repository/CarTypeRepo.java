package service.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdminService.model.CarType;

import java.util.List;

public interface CarTypeRepo extends JpaRepository<CarType, Long> {
    List<CarType> findAll();
    CarType findCarTypeById(Long id);
}
