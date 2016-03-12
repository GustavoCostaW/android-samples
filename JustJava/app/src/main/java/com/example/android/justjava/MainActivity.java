package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {


    int value = 2;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(quantity * value);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        EditText txtname = (EditText)findViewById(R.id.name);

        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number) + " Cream? " + checkbox.isChecked() + " " + txtname.getText().toString());

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "gustavo.costa.w@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "content");
        intent.putExtra(Intent.EXTRA_TEXT,NumberFormat.getCurrencyInstance().format(number)+" Cream? "+checkbox.isChecked() + " "+txtname.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity);
        quantityTextView.setText("" + number);
    }
}