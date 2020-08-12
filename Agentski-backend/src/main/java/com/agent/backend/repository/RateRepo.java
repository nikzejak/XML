package com.agent.backend.repository;

import com.agent.backend.model.Car;
import com.agent.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAll();
    Comment findCommentById(Long id);
    List<Comment> findAllByAd_Id(Long id);
    List<Comment> findAllByAd_Car(Car car);
}
