package com.example.demo;

import com.example.demo.mvp.presenter.LoginPresenter;
import com.example.demo.mvp.presenter.LoginPresenterImpl;
import com.example.demo.mvp.view.LoginView;

import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest {
    private LoginPresenter presenter;
    private LoginView view;

    @Before
    public void setUp() {
        view = mock(LoginView.class);
        presenter = new LoginPresenterImpl(view);
    }

    @Test
    public void testLoginSuccess() {
        when(view.getEmail()).thenReturn("test@test.com");
        when(view.getPassword()).thenReturn("password");

        presenter.login(view.getEmail(), view.getPassword());

        verify(view).onLoginSuccess();
    }

    @Test
    public void testLoginFailed() {
        when(view.getEmail()).thenReturn("wrong@test.com");
        when(view.getPassword()).thenReturn("wrongPassword");

        presenter.login(view.getEmail(), view.getPassword());

        verify(view).onLoginFailed();
    }
}
