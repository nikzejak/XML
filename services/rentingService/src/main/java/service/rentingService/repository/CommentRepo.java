package service.rentingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.Car;
import service.rentingService.model.Comment;

import java.util.List;

public interface CommentRepo  extends JpaRepository<Comment, Long> {
    List<Comment> findAll();
    Comment findCommentById(Long id);
    List<Comment> findAllByAd_Id(Long id);
    List<Comment> findAllByAd_Car(Car car);
}
