package service.rentingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.RentRequest;

import java.util.List;

public interface RentRequestRepo extends JpaRepository<RentRequest, Long> {
    List<RentRequest> findAll();
    List<RentRequest> findAllByClientId(Long id);
    RentRequest findRentRequestById(Long id);
}
