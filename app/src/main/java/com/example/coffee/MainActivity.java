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

    // Holds the minimum of qty
    private int quantity = 0;

    // Holds topping price
    private double toppingPrice = 0;

    // Holds the price of the cup of coffee
    final private double pricePerCup = 5;

    // Figure out if the user wants whipped cream topping
    CheckBox whippedCreamCheckBox;

    // Figure out if the user wants chocolate topping
    CheckBox chocolateCheckBox;

    // Figure out of the user want mocha topping
    CheckBox mochaCheckbox;

    // Figure out of the user want french vanilla topping
    CheckBox frenchVanilla;

    // Figure out of the user want double mocha topping
    CheckBox doubleMocha;

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
     *
     * @return void
     */
    private void initFindViewsById() {
        whippedCreamCheckBox = findViewById(R.id.checkbox_whipped_cream);
        chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        mochaCheckbox = findViewById(R.id.Mocha_checkbox);
        frenchVanilla = findViewById(R.id.french_vanilla_checkbox);
        doubleMocha = findViewById(R.id.double_mocha_checkbox);
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
     *
     * @param topping string as a key
     * @return double topping price
     */
    private double getToppingPrice(String topping) {
        return Double.parseDouble(toppingsPrice.get(topping));
    }

    /**
     * Calculate topping price
     *
     * @param price (double) total price of topping(s)
     * @param flag  (boolean) if true increment the topping price else decrement topping price from topping price
     * @return (double) total price of added toppings
     */
    private double calculateToppingPrice(double price, boolean flag) {
        
        if (flag == true) {
            toppingPrice = price + toppingPrice;
            Log.v("MainActivity", "Toppings price is ->" + price);
            Log.v("MainActivity", "Toppings calculated price ->" + toppingPrice);
            return toppingPrice;
        } else {
            toppingPrice = price - toppingPrice;
            return toppingPrice;
        }
    }

    /**
     * @param topping
     * @return
     */
    private int findToppingInList(String topping) {
        return toppingsList.indexOf(topping);
    }

    /**
     * This method adds topping to list of toppings
     *
     * @param topping
     * @return boolean
     */
    private boolean addToppingToList(String topping) {
        if (findToppingInList(topping) == -1) {
            toppingsList.add(topping);
            return true;
        }
        return false;
    }

    /**
     * This method remove topping from the topping list
     *
     * @param topping String
     * @return boolean
     */
    private boolean removeToppingFromList(String topping) {
        if (findToppingInList(topping) >= 0) {
            toppingsList.remove(topping);
            return true;
        }
        return false;
    }

    /**
     * This method retrieve checkboxes status
     */
    private void getStatusOfCheckBoxes() {
        if (whippedCreamCheckBox.isChecked()) {
            addToppingToList(whippedCreamCheckBox.getText().toString());
            calculateToppingPrice(getToppingPrice(whippedCreamCheckBox.getText().toString()), true);
        }
        if (whippedCreamCheckBox.isChecked() == false) {
            removeToppingFromList(whippedCreamCheckBox.getText().toString());
            calculateToppingPrice(getToppingPrice(whippedCreamCheckBox.getText().toString()), false);
        }
        if (chocolateCheckBox.isChecked()) {
            addToppingToList(chocolateCheckBox.getText().toString());
            calculateToppingPrice(getToppingPrice(chocolateCheckBox.getText().toString()), true);
        }
        if (chocolateCheckBox.isChecked() == false) {
            removeToppingFromList(chocolateCheckBox.getText().toString());
            calculateToppingPrice(getToppingPrice(chocolateCheckBox.getText().toString()), false);
        }
        if (mochaCheckbox.isChecked()) {
            addToppingToList(mochaCheckbox.getText().toString());
            calculateToppingPrice(getToppingPrice(mochaCheckbox.getText().toString()), true);
        }
        if (mochaCheckbox.isChecked() == false) {
            removeToppingFromList(mochaCheckbox.getText().toString());
            calculateToppingPrice(getToppingPrice(mochaCheckbox.getText().toString()), false);
        }
        if (frenchVanilla.isChecked()) {
            addToppingToList(frenchVanilla.getText().toString());
            calculateToppingPrice(getToppingPrice(frenchVanilla.getText().toString()), true);
        }
        if (frenchVanilla.isChecked() == false) {
            removeToppingFromList(frenchVanilla.getText().toString());
            calculateToppingPrice(getToppingPrice(frenchVanilla.getText().toString()), false);
        }
        if (doubleMocha.isChecked()) {
            addToppingToList(doubleMocha.getText().toString());
            calculateToppingPrice(getToppingPrice(doubleMocha.getText().toString()), true);
        }
        if (doubleMocha.isChecked() == false) {
            removeToppingFromList(doubleMocha.getText().toString());
            calculateToppingPrice(getToppingPrice(doubleMocha.getText().toString()), false);
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
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String customerName = getCustomerName();

        // Calculate the price
        double price = calculatePrice();
        Log.v("MainActivity", "SubmitOrder() -> Toppings price -> " + price);
        if (customerName != null) {
            getStatusOfCheckBoxes();
            // Display the order summary on the screen
            String message = createOrderSummary(price, customerName);
            displayMessage(message);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private double calculatePrice() {
        Log.v("MainActivity", "calculatedPrice() -> Toppings price -> " + toppingPrice);
        Log.v("MainActivity", "calculatedPrice() -> Toppings price last -> " + (quantity * pricePerCup) + toppingPrice);
        return (quantity * pricePerCup) + toppingPrice;
    }

    /**
     * Create summary of the order.
     *
     * @param price        of the order
     * @param customerName customer name
     * @return text summary
     */
    private String createOrderSummary(double price, String customerName) {
        String priceMessage = "";
        priceMessage += "\nName: " + customerName;
        priceMessage += "\nToppings Added ";
        priceMessage += "\n" + toppingsList.toString();
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