package com.services.messageService.service;

import com.services.messageService.model.Role;
import com.services.messageService.model.User;
import com.services.messageService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findall()
    {
        return userRepo.findAll();
    }
    public void save(User user) {
        userRepo.save(user);
    }
    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }
    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }
    public void deleteUser(User user) {
        userRepo.delete(user);
    }
    public List<User> findAllEndUsers() {
        return userRepo.findAllByRole(Role.ENDUSER);
    }
}
