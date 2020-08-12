package service.AdminService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.AdminService.dtos.RegisterDto;
import service.AdminService.model.*;
import service.AdminService.service.ClientService;
import service.AdminService.service.CommentService;
import service.AdminService.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ClientService clientService;

    @GetMapping(value = "/user/all")
    public ResponseEntity<List<User>> all() {
        return new ResponseEntity<>(userService.findall(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/allEndUsers")
    public ResponseEntity<List<User>> allEndUsers() {
        return new ResponseEntity<>(userService.findAllEndUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/allEndUsersForOperations")
    public ResponseEntity<List<User>> allEndUsersForOperations() {
        List<User> pom = userService.findAllEndUsers();
        List<User> ret = new ArrayList<>();
        for(User u : pom) {
            if(u.getStatus() != UserStatus.REMOVED) {
                ret.add(u);
                System.out.println(u.getStatus().toString());
            }
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/user/userByEmail")
    public ResponseEntity<User> userByEmail(@RequestParam(value = "email", required = true) String email) {
        System.out.println(userService.findUserByEmail(email).getPassword());
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping(value = "/user/accountOperation")
    public ResponseEntity<User> operations(@RequestParam(value = "operation", required = true) String operation,
                                           @RequestParam(value = "id", required = true) String id) {

        System.out.println(id);
        Long lid = Long.parseLong(id);
        User user = userService.findUserById(lid);
        System.out.println(user.getEmail() + " adresa usera za operacije");
        if(operation.equals("АCCEPTED")) {
            user.setStatus(UserStatus.ACCEPTED);
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else if(operation.equals("BLOCKED")) {
            user.setStatus(UserStatus.BLOCKED);
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else if(operation.equals("REMOVED")) {
            userService.deleteUser(user);
            Client c = clientService.findClientByEmail(user.getEmail());
            clientService.deleteClient(c);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/user/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        Client client = clientService.findClientByEmail(registerDto.getEmail());
        if(client == null) {
            client = new Client(registerDto.getEmail(), registerDto.getPassword(), registerDto.getFirstName(), registerDto.getLastName(), registerDto.getJmbg(), registerDto.getPhoneNumber(), registerDto.getAddress());
            clientService.addClient(client);
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(registerDto.getPassword());
            user.setRole(Role.ENDUSER);
            user.setStatus(UserStatus.AWAITING_APPROVAL);
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }

    }

    @PostMapping(value = "/permissionOperation")
    public ResponseEntity<Client> permissionOperation(@RequestParam(value = "operation", required = true) String operation,
                                           @RequestParam(value = "id", required = true) String id) {

        System.out.println(id);
        Long lid = Long.parseLong(id);
        Client client = clientService.findClientByID(lid);
        System.out.println(client.getEmail() + " adresa clienta za operacije");
        if(operation.equals("ALLOW")) {
            client.setAllowReservation(true);
            clientService.save(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else if(operation.equals("DISALLOW")) {
            client.setAllowReservation(false);
            clientService.save(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }

        return new ResponseEntity<>(client, HttpStatus.BAD_REQUEST);
    }



}
