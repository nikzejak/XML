package com.services.messageService.repository;

import com.services.messageService.model.Ad;
import com.services.messageService.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepo extends JpaRepository<Ad, Long> {
    List<Ad> findAll();
    List<Ad> findAllByClientId(Long id);
    List<Ad> findAllByCarId(Long id);
    Ad findAdByCar(Car car);
    Ad findAdById(Long id);
    Ad findAdByCarId(Long id);
}
