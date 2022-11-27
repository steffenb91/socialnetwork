package com.example;

import com.example.users.User;

public class UserTestbuilder {
    
    private String username = "testuser" + Math.random();

    public static UserTestbuilder newUser() {
        return new UserTestbuilder();
    }

    public UserTestbuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public User build(){
        return new User(username);
    }
}
