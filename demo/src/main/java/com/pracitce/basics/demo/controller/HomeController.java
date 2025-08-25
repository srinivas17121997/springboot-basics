package com.pracitce.basics.demo.controller;

import com.pracitce.basics.demo.DTO.GreetingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class HomeController {

    final String greetingTemplate="Hello %s how are you?.";
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

        ResponseEntity<String> response= new ResponseEntity<>(greetingTemplate.formatted(greetingRequest.getName()),HttpStatus.OK);
        return response;
    }
}
