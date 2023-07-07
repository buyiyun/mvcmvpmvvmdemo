package com.example.demo.mvp.view;

public interface LoginView {
    void onLoginSuccess();
    void onLoginFailed();

    void showFailedCount(int count);
}