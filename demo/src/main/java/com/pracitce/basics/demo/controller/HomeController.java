package com.pracitce.basics.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class HomeController {

    @GetMapping("hi")
    public String hi(){
        return "helloWorld";
    }

    @GetMapping("hello")
    public ResponseEntity<?> hello(){
        ResponseEntity<String> response= new ResponseEntity<>("Hello World",HttpStatus.OK);
        return response;
    }
}
