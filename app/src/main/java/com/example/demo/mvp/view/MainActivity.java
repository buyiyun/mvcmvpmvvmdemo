package com.example.demo.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.mvp.presenter.LoginPresenter;
import com.example.demo.mvp.presenter.LoginPresenterImpl;


public class MainActivity extends Activity implements LoginView{
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        presenter = new LoginPresenterImpl(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                presenter.login(email, password);
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedCount(int count) {
        Toast.makeText(this, "Failed Count: " + count, Toast.LENGTH_SHORT).show();
    }

}


