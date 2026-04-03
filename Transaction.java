package com.example.financecompanion;

public class Transaction {
    public String id;
    public String title;
    public double amount;

    public Transaction() {
        // Default constructor required for Firebase
    }

    public Transaction(String id, String title, double amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }
}
