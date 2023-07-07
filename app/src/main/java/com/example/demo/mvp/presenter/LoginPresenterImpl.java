package com.example.demo.mvp.presenter;

import com.example.demo.mvp.model.User;
import com.example.demo.mvp.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;
    private int failedCount;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
    }

    @Override
    public void login(String email, String password) {
        User user = new User(email, password);

        if (validate(user)) {
            // Login successful
            view.onLoginSuccess();
            failedCount = 0;
        } else {
            // Login failed
            view.onLoginFailed();
            failedCount++;
            view.showFailedCount(failedCount);
        }
    }

    private boolean validate(User user) {
        // Validate the user credentials here
        // This is just a dummy validation. In real world application, you should have proper validation here
        return user.getEmail().equals("test@test.com") && user.getPassword().equals("password");
    }
}
