package com.example.financecompanion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditTransactionActivity extends AppCompatActivity {

    private EditText titleField, amountField;
    private Button updateBtn;
    private DatabaseReference dbRef;
    private String transactionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaction);

        titleField = findViewById(R.id.titleField);
        amountField = findViewById(R.id.amountField);
        updateBtn = findViewById(R.id.updateBtn);

        transactionId = getIntent().getStringExtra("id");
        String title = getIntent().getStringExtra("title");
        String amount = getIntent().getStringExtra("amount");

        titleField.setText(title);
        amountField.setText(amount);

        dbRef = FirebaseDatabase.getInstance().getReference("Transactions").child(transactionId);

        updateBtn.setOnClickListener(v -> {
            String newTitle = titleField.getText().toString();
            String newAmount = amountField.getText().toString();

            if(newTitle.isEmpty() || newAmount.isEmpty()){
                Toast.makeText(EditTransactionActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            dbRef.child("title").setValue(newTitle);
            dbRef.child("amount").setValue(Double.parseDouble(newAmount));

            Toast.makeText(EditTransactionActivity.this, "Transaction Updated", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
