package edu.orangecoastcollege.cs273.pdavis11.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * The secondary activity and second controllers. Displays the calculationsLoads the TextViews with
 * string data from OrderActivity, button returns to previous
 *
 * @author Phillip Davis
 * @version 1.0
 */
public class SummaryActivity extends AppCompatActivity {

    /**
     * Creates TextViews with string data from Order Activity
     *
     * @param savedInstanceState loads a saved instance if there is one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Receive intent from OrderActivity
        // Populate TextView with the data

        Intent intent = getIntent();
        String totalOrder = intent.getStringExtra("totalAmount");
        String orderSummary = intent.getStringExtra("orderPriceSummary");

        // References to TextViews
        TextView mTotalTextView = (TextView) findViewById(R.id.totalTextView);
        TextView mItemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);

        // Set to TextViews
        mTotalTextView.setText(totalOrder);
        mItemsOrderedTextView.setText(orderSummary);
     }

    /**
     * Returns user to OrderActivity
     *
     * @param v reads button click
     */
    public void returnToPrevious(View v) { finish();}
}
