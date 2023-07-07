package com.example.demo.mvc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.mvc.model.User;

public class MainActivity extends Activity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                user = new User(email, password);

                if (validate(user)) {
                    // Login successful
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Login failed
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate(User user) {
        // Validate the user credentials here
        // This is just a dummy validation. In real world application, you should have proper validation here
        return user.getEmail().equals("test@test.com") && user.getPassword().equals("password");
    }
}

