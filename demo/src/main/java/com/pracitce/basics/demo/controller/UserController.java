package com.pracitce.basics.demo.controller;

import com.pracitce.basics.demo.DTO.UserRequest;
import com.pracitce.basics.demo.DTO.UserResponse;
import com.pracitce.basics.demo.model.User;
import com.pracitce.basics.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUserDetails(@PathVariable("userId") int userId){
        return userService.getUserDetails(userId);
    }
}
