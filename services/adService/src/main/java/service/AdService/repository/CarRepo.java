package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.Car;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAll();
    Car findCarById(Long id);
}
