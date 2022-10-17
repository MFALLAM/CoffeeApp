package com.example.coffee;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    final int COFFEE_PRICE = 5;
    int quantity = 0;
    int orderPrice;
    public TextView priceTextView;
    public TextView quantityTextView;
    public TextView orderSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
    }

    private void initializer() {
        quantityTextView = findViewById(R.id.text_total_qty);
        priceTextView = findViewById(R.id.txt_price);
        orderSummaryTextView = findViewById(R.id.order_summary_tv);
    }

    public void submitOrder(View view) {
        String message = createOrderSummary();
        orderSummaryTextView.setText(message);
    }

    /**
     * Create summary of the order.
     */
    private String createOrderSummary() {
        String priceMessage = "";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + orderPrice;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity on the screen
     *
     * @param numberOfCoffees
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView txtView = findViewById(R.id.text_total_qty);
        txtView.setText("" + numberOfCoffees);
    }


    /**
     * This method is called when the + button is clicked and its increase the quantity by 1 and updating the total price order
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, R.string.validation_increase, Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        setQuantity(quantity);
        calculateTotalPrice();
        displayPrice(orderPrice);
    }

    /**
     * This method is called when the - button is clicked and its decrease the quantity by 1 and updating the total price order
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, R.string.validation_decrease, Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        setQuantity(quantity);
        calculateTotalPrice();
        displayPrice(orderPrice);
    }

    private void setQuantity(int newQuantity) {
        Log.v("MainActivity", "newQuantity: ");
        quantityTextView.setText("" + newQuantity);
    }

    private void calculateTotalPrice() {
        int total = 0;
        orderPrice = quantity * (total + COFFEE_PRICE);
        Log.v("MainActivity", "calculateTotalPrice -> new price: ");
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        Log.v("MainActivity", "number: ");
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}