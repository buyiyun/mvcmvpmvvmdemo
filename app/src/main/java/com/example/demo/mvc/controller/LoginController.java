package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.User;

public class LoginController {
    public interface LoginListener {
        void onLoginSuccess();
        void onLoginFailure();
    }

    private LoginListener listener;

    public LoginController(LoginListener listener) {
        this.listener = listener;
    }

    public void login(String email, String password) {
        User user = new User(email, password);

        if (validate(user)) {
            // Login successful
            listener.onLoginSuccess();
        } else {
            // Login failed
            listener.onLoginFailure();
        }
    }

    private boolean validate(User user) {
        // Validate the user credentials here
        // This is just a dummy validation. In real world application, you should have proper validation here
        return user.getEmail().equals("test@test.com") && user.getPassword().equals("password");
    }
}
