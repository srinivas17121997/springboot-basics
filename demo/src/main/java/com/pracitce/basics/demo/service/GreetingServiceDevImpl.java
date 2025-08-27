package com.pracitce.basics.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Profile("dev")
public class GreetingServiceDevImpl implements GreetingService {
    final String greetingTemplate="Hello %s how are you?.";
    @Value("${app.message}")
    String message;
    private final long createdAt;

    public GreetingServiceDevImpl(){
        this.createdAt = System.currentTimeMillis();
    }

    public long getCreatedAt(){
        return createdAt;
    }

    @Override
    public String getGreeting(String name) {
        return greetingTemplate.formatted(name)+message;
    }
}
