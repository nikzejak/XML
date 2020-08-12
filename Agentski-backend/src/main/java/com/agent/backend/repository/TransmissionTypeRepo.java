package com.agent.backend.repository;

import com.agent.backend.model.TransmissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransmissionTypeRepo extends JpaRepository<TransmissionType, Long> {
    List<TransmissionType> findAll();
    TransmissionType findTransmissionTypeById(Long id);
    TransmissionType findTransmissionTypeByType(String type);
}
