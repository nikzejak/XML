package service.authenticationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.authenticationService.model.Role;
import service.authenticationService.model.User;
import service.authenticationService.repository.UserRepo;

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

    public List<User> findAllEndUsers() {
        return userRepo.findAllByRole(Role.ENDUSER);
    }
}
