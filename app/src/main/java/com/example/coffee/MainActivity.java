package com.example.coffee;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    // Figure out if the user wants whipped cream topping
    CheckBox whippedCreamCheckBox;

    // Figure out if the user wants chocolate topping
    CheckBox chocolateCheckBox;

    // Holds toppings prices
    Map<String, String> toppingsPrice = new HashMap<>();

    // Holds list of toppings
    ArrayList<String> toppingsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addingToppingPrices();
        initFindViewsById();
    }

    /**
     * this method finds view by id and initialize it
     * @return void
     */
    private void initFindViewsById() {
        whippedCreamCheckBox = findViewById(R.id.checkbox_whipped_cream);
        chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(MainActivity.this, "You can't have more than 100 cups!", Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(MainActivity.this, "You can't have less than 1 cup!", Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        boolean hasChocolate = chocolateCheckBox.isChecked();

        String customerName = getCustomerName();

        // Calculate the price
        int price = calculatePrice();

        if (customerName != null) {
            getStatusOfCheckBoxes();
            // Display the order summary on the screen
            String message = createOrderSummary(price, hasWhippedCream, hasChocolate, customerName);
            displayMessage(message);
        }
    }

    /**
     *
     */
    private void addingToppingPrices() {
        toppingsPrice.put("Whipped Cream", "1.2");
        toppingsPrice.put("Chocolate", "1.3");
        toppingsPrice.put("Mocha", "1.7");
        toppingsPrice.put("French Vanilla", "1.1");
        toppingsPrice.put("Double Mocha", "2.4");
        toppingsPrice.put("Blue Berry", "1.9");
        toppingsPrice.put("Salted Caramel", "1.9");
    }

    /**
     * This method returns topping price
     * @param topping string
     * @return String topping price
     */
    private String getToppingPrice(String topping) {
        return toppingsPrice.get(topping);
    }

    /**
     *
     * @param topping
     * @return
     */
    private int findToppingInList(String topping) {
        return toppingsList.indexOf(topping);
    }

    /**
     * This method adds topping to list of toppings
     * @param topping
     * @return boolean
     */
    private boolean addToppingToList(String topping) {
        if(findToppingInList(topping) == -1) {
            toppingsList.add(topping);
            return true;
        }
        return false;
    }

    /**
     * This method remove topping from the topping list
     * @param topping String
     * @return boolean
     */
    private boolean removeToppingFromList(String topping) {
        if(findToppingInList(topping) >= 0) {
            toppingsList.remove(topping);
            return true;
        }
        return false;
    }

    /**
     *
     */
    private void getStatusOfCheckBoxes() {
        if(whippedCreamCheckBox.isChecked()) {
            Log.v("MainActivity", "Toppings " + whippedCreamCheckBox.getText());
            Log.v("MainActivity", "Toppings Whipped Cream" + whippedCreamCheckBox.isChecked());
        }
        if(whippedCreamCheckBox.isChecked() == false) {
            Log.v("MainActivity", "Toppings " + whippedCreamCheckBox.getText());
            Log.v("MainActivity", "Toppings - Whipped Cream " + whippedCreamCheckBox.isChecked());
        }
    }

    /**
     * This method gets the customer name
     *
     * @return String customer name
     */
    private String getCustomerName() {
        // Getting customer name from edit text
        EditText customerName = findViewById(R.id.customer_name_edit_text);

        if (customerName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_LONG).show();
            return null;
        }
        return customerName.getText().toString();
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @param customerName    customer name
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String customerName) {
        String priceMessage = "";
        priceMessage += "\nName: " + customerName;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.text_total_qty);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_tv);
        orderSummaryTextView.setText(message);
    }
}