package com.example.bookingticket.SignupPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookingticket.LoginPage.LoginActivity;
import com.example.bookingticket.Model.User.UserBody;
import com.example.bookingticket.R;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel viewModel;
    private EditText ed1, ed2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);
        btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {
            String username = ed1.getText().toString().trim();
            String password = ed2.getText().toString().trim();
            UserBody userBody = new UserBody(username, password);
            viewModel.register(userBody);

            // Observe here, after calling register
            viewModel.getData().observe(this, new Observer<UserBody>() {
                @Override
                public void onChanged(UserBody userBody) {
                    Log.d("SignUpActivity", "Observer triggered. UserBody: " + userBody);
                    if (userBody != null) {
                        Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing success toast");
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing failure toast");
                    }
                }
            });
        });

    }

}

