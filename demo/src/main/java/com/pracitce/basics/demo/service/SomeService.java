package com.pracitce.basics.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private static final Logger logger= LoggerFactory.getLogger(SomeService.class);
    public String abc="ABC";

    @PreDestroy
    public void abc(){
        logger.info("it is about to destroying");
    }

    @PostConstruct
    public void abcedf(){
        logger.info("Constructed");
    }

}
