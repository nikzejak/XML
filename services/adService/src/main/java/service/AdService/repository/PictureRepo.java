package service.AdService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.Picture;

public interface PictureRepo extends JpaRepository<Picture, Long> {

}
