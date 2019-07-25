package web.controllers;

import web.models.User;
import web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserRepository userRepository;

    @GetMapping("/list")
    public Iterable<User> list() {
        return userRepository.findAll();
    }
}
