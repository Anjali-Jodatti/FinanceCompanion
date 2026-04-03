package com.example.financecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signupBtn);

        loginBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        signupBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SignupActivity.class)));
    }
}
