package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.models.User;
import web.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userService;

    @GetMapping("/add/{name}")
    public String list(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        userService.save(user);
       return "OK";
    }
}
