package com.example.testbookingticket.LoginPage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testbookingticket.R;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private Button btn;
    private EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);
        btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {
            String username = ed1.getText().toString().trim();
            String password = ed2.getText().toString().trim();
            LoginResquest loginResquest = new LoginResquest(username, password);
            loginViewModel.login(loginResquest);

            // Observe here, after calling register
            loginViewModel.getData().observe(this, new Observer<LoginResponse>() {
                @Override
                public void onChanged(LoginResponse loginResponse) {
                    Log.d("SignUpActivity", "Observer triggered. UserBody: " + loginResponse);
                    if (loginResponse != null) {
                        Toast.makeText(LoginActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing success toast");
                    } else {
                        Toast.makeText(LoginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing failure toast");
                    }
                }
            });
        });
    }
}