package com.agent.backend.controller;

import com.agent.backend.dtos.LoginDTO;
import com.agent.backend.model.User;
import com.agent.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/all")
    public ResponseEntity<List<User>> all() {
        return new ResponseEntity<>(userService.findall(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/allEndUsers")
    public ResponseEntity<List<User>> allEndUsers() {
        return new ResponseEntity<>(userService.findAllEndUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/userByEmail")
    public ResponseEntity<User> userByEmail(@RequestParam(value = "email", required = true) String email) {
        System.out.println(userService.findUserByEmail(email).getPassword());
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> login(@RequestBody LoginDTO logindto)
    {
        System.out.println("Sifra je " + logindto.getPassword());
        User user = userService.findUserByEmail(logindto.getEmail());
        System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getPassword()))
            {
                System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                System.out.println("User is logged in with email: " + user.getEmail());
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


}
