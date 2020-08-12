package service.rentingService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rentingService.model.Car;
import service.rentingService.model.Comment;
import service.rentingService.repository.CommentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public void addComment(Comment c) {
        commentRepo.save(c);
    }

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public List<Comment> findAllByAdId(Long id) {
        return commentRepo.findAllByAd_Id(id);
    }

    public List<Comment> findAllByCar(Car car) {
        return commentRepo.findAllByAd_Car(car);
    }

    public void save(Comment user) {
        commentRepo.save(user);
    }
    public Comment findCommentById(Long id) {
        return commentRepo.findCommentById(id);
    }
}

