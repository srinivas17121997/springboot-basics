package com.pracitce.basics.demo.controller;

import com.pracitce.basics.demo.DTO.GreetingRequest;
import com.pracitce.basics.demo.configuration.AppConfig;
import com.pracitce.basics.demo.service.GreetingService;
import com.pracitce.basics.demo.service.GreetingServiceDevImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class HomeController {

    private static final Logger logger= LoggerFactory.getLogger(HomeController.class);
    @Autowired
    GreetingService greetingService;
    @Autowired
    AppConfig appConfig;

    @GetMapping("hi")
    public String hi(){
        return "helloWorld";
    }

    @GetMapping("hello")
    public ResponseEntity<?> hello(){
        ResponseEntity<String> response= new ResponseEntity<>("Hello World",HttpStatus.OK);
        return response;
    }

    @PostMapping("greet")
    public ResponseEntity<?> greet(@RequestBody GreetingRequest greetingRequest){
        logger.warn("we got request: {}",greetingRequest);
        logger.error("We might go the error {}.",greetingRequest.getName());

        ResponseEntity<String> response= new ResponseEntity<>(greetingService.getGreeting(greetingRequest.getName()),HttpStatus.OK);
        return response;
    }
}
