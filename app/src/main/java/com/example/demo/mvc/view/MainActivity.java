package com.example.demo.mvc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.mvc.controller.LoginController;
import com.example.demo.mvc.model.User;

public class MainActivity extends Activity implements LoginController.LoginListener {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        loginController = new LoginController(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                loginController.login(email, password);
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
