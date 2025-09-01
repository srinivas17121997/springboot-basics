package com.pracitce.basics.demo.DTO;

public class UserResponse {
    private String name;
    private String email;
    private int id;

    public UserResponse() {
    }

    public UserResponse(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
