package com.pracitce.basics.demo.service;

import com.pracitce.basics.demo.DTO.UserRequest;
import com.pracitce.basics.demo.DTO.UserResponse;
import com.pracitce.basics.demo.exceptions.UserNotFoundException;
import com.pracitce.basics.demo.model.User;
import com.pracitce.basics.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUserDetails(int userId){
        return userRepository.findById(userId).map(this::convertToUserResponse).orElseThrow(() -> new UserNotFoundException("User not present with the id:"+userId));
    }

    public List<UserResponse> getAllUsers(){
        Iterable<User> abc = userRepository.findAll();
       return StreamSupport.stream(abc.spliterator(), false)
               .map(this::convertToUserResponse)
                .collect(Collectors.toList());
    }

    public void addUser(UserRequest userRequest){
        User user=convertToUser(userRequest);
        userRepository.save(user);
    }
    private UserResponse convertToUserResponse(User user){
        return new UserResponse(user.getName(),user.getEmail(),user.getId());
    }

    private User convertToUser(UserRequest userRequest){
        User user= new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        return user;
    }

}
