package edu.orangecoastcollege.cs273.pdavis11.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * The first activity and controller. Prompts user the for order and sends data to model
 * for calculations and then sends user to second activity to view the order prices.
 *
 * @author Phillip Davis
 * @version 1.0
 */
public class OrderActivity extends AppCompatActivity {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    // Connections to the view.
    private EditText mDoubleDoubleEditText;
    private EditText mCheeseBurgerEditText;
    private EditText mFrenchFriesEditText;
    private EditText mShakesEditText;
    private EditText mSmallEditText;
    private EditText mMediumEditText;
    private EditText mLargeEditText;
    private Button mOrderButton;

    // Connection to the Model
    private Order mOrder = new Order();

    /**
     * Creates the views doubleDoubleEditText, cheeseBurgerEditText, frenchFriesEditText,
     * shakesEditText, smallEditText, mediumEditText, largeEditText and button orderButton.
     * @param savedInstanceState Loads saved instance if there is one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Use findViewId to connect the controller to each view
        mDoubleDoubleEditText = findViewById(R.id.doubleDoubleEditText);
        mCheeseBurgerEditText = findViewById(R.id.cheeseBurgerEditText);
        mFrenchFriesEditText = findViewById(R.id.frenchFriesEditText);
        mShakesEditText = findViewById(R.id.shakesEditText);
        mSmallEditText = findViewById(R.id.smallEditText);
        mMediumEditText = findViewById(R.id.mediumEditText);
        mLargeEditText = findViewById(R.id.largeEditText);
        mOrderButton = findViewById(R.id.orderButton);
    }


    /**
     * Collects order information and tests it for a non-entry. Sets non entry to 0, and
     * converts user input into strings and sends off for calculations.
     * @param view editTexts from order_activity sent by button click
     */
    public void collectOrderData(View view)
    {
        // Update the Model and Calculate
        if(mDoubleDoubleEditText.getText().toString().length() == 0)
            mOrder.setDoubleDoubles(0);
        else
            mOrder.setDoubleDoubles(Integer.parseInt(mDoubleDoubleEditText.getText().toString()));
        if(mCheeseBurgerEditText.getText().toString().length() == 0)
            mOrder.setCheeseBurgers(0);
        else
            mOrder.setCheeseBurgers(Integer.parseInt(mCheeseBurgerEditText.getText().toString()));
        if(mFrenchFriesEditText.getText().toString().length() == 0)
            mOrder.setFrenchFries(0);
        else
            mOrder.setFrenchFries(Integer.parseInt(mFrenchFriesEditText.getText().toString()));
        if(mShakesEditText.getText().toString().length() == 0)
            mOrder.setShakes(0);
        else
            mOrder.setShakes(Integer.parseInt(mShakesEditText.getText().toString()));
        if(mSmallEditText.getText().toString().length() == 0)
            mOrder.setSmallDrinks(0);
        else
            mOrder.setSmallDrinks(Integer.parseInt(mSmallEditText.getText().toString())) ;
        if(mMediumEditText.getText().toString().length() == 0)
            mOrder.setMediumDrinks(0);
        else
            mOrder.setMediumDrinks(Integer.parseInt(mMediumEditText.getText().toString()));
        if(mLargeEditText.getText().toString().length() == 0)
            mOrder.setLargeDrinks(0);
        else
            mOrder.setLargeDrinks(Integer.parseInt(mLargeEditText.getText().toString()));

    }

    /**
     * Calls collectOrderData() and takes it information. The information is calculated in the model
     * and then attached to a string and formatted. Intention sends the strings to second activty
     * for displaying the order details.
     * @param view editTexts from order_activity sent by button click
     */
    public void orderSummary(View view)
    {
        collectOrderData(view);

        String totalPrice = getString(R.string.order_total) + " " + currency.format(mOrder.calculateTotal());

        String orderSummary = getString(R.string.items_ordered) + " " + mOrder.getNumberItemsOrdered() + "\n"
                + getString(R.string.subtotal) + " " + currency.format(mOrder.calculateSubtotal()) + "\n"
                + getString(R.string.taxation) + " " + currency.format(mOrder.calculateTax());

        // Intents start new activities and can share data with them
        Intent LaunchOrderSummary = new Intent(this, SummaryActivity.class);
        // Put data into the Intent for LoanSummary to receive
        LaunchOrderSummary.putExtra("totalAmount", totalPrice);
        LaunchOrderSummary.putExtra("orderPriceSummary", orderSummary);
        // Start the second activity
        startActivity(LaunchOrderSummary);

        //onRestart();
    }
}
