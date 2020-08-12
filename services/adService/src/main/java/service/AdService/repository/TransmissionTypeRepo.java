package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.TransmissionType;


import java.util.List;

public interface TransmissionTypeRepo extends JpaRepository<TransmissionType, Long> {
    List<TransmissionType> findAll();
    TransmissionType findTransmissionTypeById(Long id);
    TransmissionType findTransmissionTypeByType(String type);
}
