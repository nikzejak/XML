package service.rentingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.Ad;
import service.rentingService.model.Car;

import java.util.List;

public interface AdRepo extends JpaRepository<Ad, Long> {
    List<Ad> findAll();
    List<Ad> findAllByClientId(Long id);
    List<Ad> findAllByCarId(Long id);
    Ad findAdByCar(Car car);
    Ad findAdById(Long id);
    Ad findAdByCarId(Long id);
}
