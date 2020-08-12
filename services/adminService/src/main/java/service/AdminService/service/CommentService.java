package service.AdminService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService.model.Comment;
import service.AdminService.repository.CommentRepo;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> findAll()
    {
        return commentRepo.findAll();
    }
    public void save(Comment user) {
        commentRepo.save(user);
    }
    public Comment findCommentById(Long id) {
        return commentRepo.findCommentById(id);
    }
}
