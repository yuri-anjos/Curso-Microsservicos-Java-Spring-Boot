package com.devsuperior.hroauth.resources;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public User findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }
}
