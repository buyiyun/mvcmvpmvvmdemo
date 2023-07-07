package com.example.demo.mvvm.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo.mvvm.model.User;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<User> user;

    public LiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void login(String email, String password) {
        // This is just a dummy login. In real world application, you should have proper login here
        if (email.equals("test@test.com") && password.equals("password")) {
            user.setValue(new User(email, password));
        } else {
            user.setValue(null);
        }
    }
}
