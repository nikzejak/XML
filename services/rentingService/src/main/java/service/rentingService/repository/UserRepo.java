package service.rentingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();

    User findUserByEmail(String email);
}
