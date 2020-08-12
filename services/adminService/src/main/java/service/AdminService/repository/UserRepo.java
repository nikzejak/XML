package service.AdminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdminService.model.Role;
import service.AdminService.model.User;


import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> findAllByRole(Role role);

}
