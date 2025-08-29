package com.pracitce.basics.demo.controller;

import com.pracitce.basics.demo.model.User;
import com.pracitce.basics.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUsers(){
       return userRepository.findAll();
    }
}
