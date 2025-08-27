package com.pracitce.basics.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public String abc="ABC";

    @PreDestroy
    public void abc(){
        System.out.println("it is about to destroying");
    }

    @PostConstruct
    public void abcedf(){
        System.out.println("Constructed");
    }

}
