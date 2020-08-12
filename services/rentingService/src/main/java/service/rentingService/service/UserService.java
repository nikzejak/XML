package service.rentingService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rentingService.model.User;
import service.rentingService.repository.UserRepo;

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
}
