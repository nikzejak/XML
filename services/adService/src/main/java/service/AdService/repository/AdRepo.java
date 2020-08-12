package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.Ad;

import java.util.List;

public interface AdRepo extends JpaRepository<Ad, Long> {
    List<Ad> findAll();
    List<Ad> findAllByClientId(Long id);
    Ad findAdById(Long id);
}
