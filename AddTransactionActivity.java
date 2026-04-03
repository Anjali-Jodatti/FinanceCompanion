package com.example.financecompanion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTransactionActivity extends AppCompatActivity {

    private EditText titleField, amountField;
    private Button saveBtn;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        titleField = findViewById(R.id.titleField);
        amountField = findViewById(R.id.amountField);
        saveBtn = findViewById(R.id.saveBtn);

        dbRef = FirebaseDatabase.getInstance().getReference("Transactions");

        saveBtn.setOnClickListener(v -> {
            String title = titleField.getText().toString();
            String amount = amountField.getText().toString();

            if(title.isEmpty() || amount.isEmpty()){
                Toast.makeText(AddTransactionActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String id = dbRef.push().getKey();
            Transaction t = new Transaction(id, title, Double.parseDouble(amount));
            dbRef.child(id).setValue(t);

            Toast.makeText(AddTransactionActivity.this, "Transaction Added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
