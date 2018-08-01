package com.example.doctorx.inventoryapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorx.inventoryapp.data.ProductContract.ProductEntry;
import com.example.doctorx.inventoryapp.data.ProductDbHelper;

import java.text.NumberFormat;

/**
 * {@link ProductCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of book data as its data source. This adapter knows
 * how to create list items for each row of book data in the {@link Cursor}.
 */
public class ProductCursorAdapter extends CursorAdapter {

    /** initializing variables */
    private TextView mNameTextView;
    private TextView mPriceTextView;
    private TextView mQuantityTextView;
    private Button mSaleButton;

    /** Database helper object */
    ProductDbHelper mDbHelper;

    /**
     * Constructs a new {@link ProductCursorAdapter}.
     *
     * @param context The context.
     * @param cursor  The cursor from which to get the data.
     */
    public ProductCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0 /* flag */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context.
     * @param cursor where you get the data.
     * @param parent the parent to which the new view is attached to the newly created list item view.
     * @return an item list view
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * Bind the cursor data to the list_item layout.
     * @param view existing view return by newView().
     * @param context app context.
     * @param cursor cursor which gets data from it.
     */
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        // attach the view
        mNameTextView = view.findViewById(R.id.name);
        mPriceTextView = view.findViewById(R.id.price);
        mQuantityTextView = view.findViewById(R.id.quantity_in_stock);
        mSaleButton = view.findViewById(R.id.sale_button);

        // Find and read the product attributes from the cursor
        final int id = cursor.getInt(cursor.getColumnIndex(ProductEntry._ID));
        String productName = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME));
        String productPrice = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE));
        final String mproductQuantity = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY));

        // Add local currency to price, credit: http://www.avajava.com/tutorials/lessons/how-do-i-use-numberformat-to-format-currencies.html
        // -- Author Deron Eriksson written in 2014.
        NumberFormat format = NumberFormat.getCurrencyInstance();

        mNameTextView.setText(productName);
        mPriceTextView.setText(format.format(Double.valueOf(productPrice)));
        mQuantityTextView.setText(String.valueOf(mproductQuantity));
        mSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(mproductQuantity) > 0) {
                    Toast.makeText(context, R.string.no_stock, Toast.LENGTH_SHORT).show();
                } else {
                    // Decrease the item stock quantify
                    int quantity = Integer.parseInt(mproductQuantity) - 1;
                    // Setting up the value
                    ContentValues values = new ContentValues();
                    values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, quantity);
                    // Pointing to the changing row
                    String selection = ProductEntry._ID + "=?";
                    Uri currentProduct = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, id);
                    String[] slectionArgs = new String[] {String.valueOf(id)};
                    // updating the database with content resolver
                    context.getContentResolver().update(currentProduct, values, selection, slectionArgs);
                }
            }
        });
    }
}
