package org.example.model;

import java.time.LocalDateTime;

public class Activity {
    private String name;
    private String userId;
    private LocalDateTime localDateTime;

    public Activity(String name, String userId, LocalDateTime localDateTime) {
        this.name = name;
        this.userId = userId;
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
