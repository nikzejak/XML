package com.agent.backend.services;

import com.agent.backend.model.PriceList;
import com.agent.backend.repository.PriceListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {

    @Autowired
    PriceListRepo priceListRepo;

    public List<PriceList> findAll() {
        return priceListRepo.findAll();
    }
    public PriceList findOneById(Long id) {
        return priceListRepo.findPriceListById(id);
    }

    public List<PriceList> findAllByClientId(Long id) {
        return priceListRepo.findAllByClientId(id);
    }

    public void save(PriceList p) {
        priceListRepo.save(p);
    }
}
