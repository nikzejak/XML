package com.services.messageService.repository;

import com.services.messageService.model.Role;
import com.services.messageService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> findAllByRole(Role role);

}
