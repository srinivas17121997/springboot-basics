package com.pracitce.basics.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeGreetingService {
    final String greetingTemplate="Hello %s how are you?.";
    private final long createdAt;

    public PrototypeGreetingService() {
        this.createdAt = System.currentTimeMillis();
    }
    public String getGreetings(String name){
        return greetingTemplate.formatted(name)+"Created at:"+createdAt;
    }
}
