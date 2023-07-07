package com.example.demo.mvp.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.mvp.presenter.LoginPresenter;
import com.example.demo.mvp.presenter.LoginPresenterImpl;

public class WelcomeActivity extends Activity implements LoginView {
  private Button loginButton;
  private LoginPresenter presenter;

  @SuppressLint("MissingInflatedId")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_welcome);

      loginButton = findViewById(R.id.login_welcome);

      presenter = new LoginPresenterImpl(this);

      loginButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email = "";
              String password = "";
              presenter.login(email, password);
          }
      });
  }

  @Override
  public void onLoginSuccess() {
      Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
  }

    @Override
    public void showFailedCount(int count) {
        Toast.makeText(this, "Failed Count: " + count, Toast.LENGTH_SHORT).show();
    }


    @Override
  public void onLoginFailed() {
      Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
  }
}