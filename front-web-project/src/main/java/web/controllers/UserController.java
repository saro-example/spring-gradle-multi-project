package web.controllers;

import data.models.User;
import data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired UserRepository userRepository;

    @GetMapping("/list")
    public Iterable<User> list() {
        return userRepository.findAll();
    }
}
