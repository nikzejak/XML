package com.agent.backend.repository;

import com.agent.backend.model.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceListRepo extends JpaRepository<PriceList, Long> {
    List<PriceList> findAll();
    PriceList findPriceListById(Long id);
    List<PriceList> findAllByClientId(Long id);
}
