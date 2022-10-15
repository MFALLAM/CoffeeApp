package com.example.coffee;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int price = 5;
    private int qty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

    }

    private void display(int number) {
        TextView txtView = findViewById(R.id.text_total_qty);
        txtView.setText("" + number);
    }

    public void increment(View view) {
        qty = qty + 1;
        display(qty);
        displayPrice(qty * price);
    }

    public void decrement(View view) {
        if ((qty - 1) >= 1) {
            qty = qty - 1;
            display(qty);
            displayPrice(qty * price);
        }
    }

    private void displayPrice(int number) {
        TextView txtView = findViewById(R.id.text_total_price);
        txtView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}