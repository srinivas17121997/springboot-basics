package com.pracitce.basics.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@ConditionalOnProperty(name = "feature.greeting.enabled", havingValue = "true", matchIfMissing = false)
public class GreetingServiceProdImpl implements GreetingService{

    final String greetingTemplate="Hello %s.How are you?. This message is from Prod.";

    @Override
    public String getGreeting(String name) {
        return greetingTemplate.formatted(name);
    }
}
