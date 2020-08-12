package service.AdService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.PriceList;

import java.util.List;

public interface PriceListRepo extends JpaRepository<PriceList, Long> {
    List<PriceList> findAll();
    PriceList findPriceListById(Long id);
    List<PriceList> findAllByClientId(Long id);
}
