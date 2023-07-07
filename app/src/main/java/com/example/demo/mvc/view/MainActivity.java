package com.example.demo.mvc.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.mvc.model.User;

import java.util.List;

public class MainActivity extends Activity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;
    private Button changePasswordButton;
    private Button deleteAccountButton;
    private User user;

    private TextView friendsTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        registerButton = findViewById(R.id.register);
        changePasswordButton = findViewById(R.id.changePassword);
        deleteAccountButton = findViewById(R.id.deleteAccount);
        friendsTextView = findViewById(R.id.friends);

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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Register a new user
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                user = new User(email, password);

                // Show a message to indicate the user has been registered
                Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
            }
        });

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the user's password
                String newPassword = passwordEditText.getText().toString();

                if (user != null) {
                    user.changePassword(newPassword);

                    // Show a message to indicate the password has been changed
                    Toast.makeText(MainActivity.this, "Password Changed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete the user's account
                user = null;

                // Show a message to indicate the account has been deleted
                Toast.makeText(MainActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate(User user) {
        // Validate the user credentials here
        // This is just a dummy validation. In real world application, you should have proper validation here
        return user.getEmail().equals("test@test.com") && user.getPassword().equals("password");
    }

    private void showFriends() {
        if (user != null) {
            List<String> friends = user.getFriends();
            String friendsString = "Friends: " + TextUtils.join(", ", friends);
            friendsTextView.setText(friendsString);
        }
    }
}


