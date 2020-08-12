package com.agent.backend.services;

import com.agent.backend.model.Car;
import com.agent.backend.model.Comment;
import com.agent.backend.repository.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    @Autowired
    RateRepo rateRepo;

    public void addComment(Comment c) {
        rateRepo.save(c);
    }

    public List<Comment> findAll() {
        return rateRepo.findAll();
    }

    public List<Comment> findAllByAdId(Long id) {
        return rateRepo.findAllByAd_Id(id);
    }

    public List<Comment> findAllByCar(Car car) {
        return rateRepo.findAllByAd_Car(car);
    }

    public void save(Comment user) {
        rateRepo.save(user);
    }
    public Comment findCommentById(Long id) {
        return rateRepo.findCommentById(id);
    }
}

