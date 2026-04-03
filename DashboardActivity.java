package com.example.financecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button addTransactionBtn, goalsBtn, insightsBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        addTransactionBtn = findViewById(R.id.addTransactionBtn);
        goalsBtn = findViewById(R.id.goalsBtn);
        insightsBtn = findViewById(R.id.insightsBtn);
        aboutBtn = findViewById(R.id.aboutBtn);

        addTransactionBtn.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, AddTransactionActivity.class)));
        goalsBtn.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, GoalsActivity.class)));
        insightsBtn.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, InsightsActivity.class)));
        aboutBtn.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, AboutActivity.class)));
    }
}
