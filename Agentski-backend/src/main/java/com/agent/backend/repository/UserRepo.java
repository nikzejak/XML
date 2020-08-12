package com.agent.backend.repository;

import com.agent.backend.model.Role;
import com.agent.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> findAllByRole(Role role);
}
