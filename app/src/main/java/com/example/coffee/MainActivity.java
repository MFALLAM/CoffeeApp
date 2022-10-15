package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(1);
        displayPrice(2 * price);
    }

    private void display(int number) {
        TextView txtView = findViewById(R.id.text_total_qty);
        txtView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView txtView = findViewById(R.id.text_total_price);
        txtView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}