package com.example.demo.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private List<String> friends;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.friends = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friend) {
        this.friends.add(friend);
    }
}
