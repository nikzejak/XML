package service.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdminService.model.TransmissionType;

import java.util.List;

public interface TransmissionTypeRepo extends JpaRepository<TransmissionType, Long> {
    List<TransmissionType> findAll();
    TransmissionType findTransmissionTypeById(Long id);
}
