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

    private String createOrderSummary() {
        String priceMessage = "";
        priceMessage += "Name: Mohammed Allam";
        priceMessage += "\n Quantity: " + qty;
        priceMessage += "\n Total: " + price * qty;
        return priceMessage;
    }

    /**
     * This method displays the given quantity on the screen
     * @param numberOfCoffees
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView txtView = findViewById(R.id.text_total_qty);
        txtView.setText("" + numberOfCoffees);
    }

    public void increment(View view) {
        qty = qty + 1;
        displayQuantity(qty);
        displayPrice(qty * price);
    }

    public void decrement(View view) {
        if ((qty - 1) >= 1) {
            qty = qty - 1;
            displayQuantity(qty);
            displayPrice(qty * price);
        }
    }

    private void displayPrice(int number) {
        TextView txtView = findViewById(R.id.order_summary_tv);
        txtView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}