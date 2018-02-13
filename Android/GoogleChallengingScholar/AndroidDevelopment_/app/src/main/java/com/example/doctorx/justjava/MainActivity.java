package com.example.doctorx.justjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.NumberFormat;

import static com.example.doctorx.justjava.R.string.order_summary_name;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
//    boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = findViewById(R.id.name);
        String hisName = name.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
//        Log.v("MainActivity", "Has Whipped Cream: "+ hasWhippedCream);
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(hisName, price, hasWhippedCream, hasChocolate));

        // Email intent
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));    // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order to: " + hisName);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(hisName, price, hasWhippedCream, hasChocolate));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * increment method
     */
    public void increment(View View) {
        if (quantity == 100) {
            Toast.makeText(this, "you can not have more than 100 coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * decrement method
     */
    public void decrement(View View) {
        if (quantity == 1) {
            Toast.makeText(this, "you can not have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * Calculates the price of the order.
     *
     * @param whippedCream is whether he wants a whipped cream or not
     * @param hasChocolate is whether he wants a chocolate or not
     *
     * @return total price
     */
    private int calculatePrice(boolean whippedCream, boolean hasChocolate) {
        int basePrice = 5;

        // Add $1 if user wants Whipped Cream
        if (whippedCream) { basePrice += 1; }

        // Add $2 if user wants the chocolate
        if (hasChocolate) { basePrice += 2; }

        return quantity * basePrice;
    }

    /**
     * Checkbox
     */
//    public void checkBox (View view) {
//        checked = true;
//    }

    /***
     * Return a Summery on screen
     *
     * @param name name of customer
     * @param price for price variable
     * @param whippedCheckBox is whether he wants a whipped cream or not
     * @param chocolateCheckBox is whether he wants a chocolate or not
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean whippedCheckBox, boolean chocolateCheckBox) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped Cream? " + whippedCheckBox;
        priceMessage += "\nAdd Chocolate? " + chocolateCheckBox;
        priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n" + getString(R.string.order_summary_price, price);
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
}