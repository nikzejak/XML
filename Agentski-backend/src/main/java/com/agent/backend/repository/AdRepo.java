package com.agent.backend.repository;

import com.agent.backend.model.Ad;
import com.agent.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AdRepo extends JpaRepository<Ad, Long> {
    List<Ad> findAll();
    List<Ad> findAllByClientId(Long id);
    Ad findAdById(Long id);
    Ad findAdByCar(Car car);
    Ad findAdByCarId(Long id);
    List<Ad> findAllByCarId(Long id);
}
