package com.example.android.inventoryapp;

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

import com.example.android.inventoryapp.data.ProductContract;
import com.example.android.inventoryapp.data.ProductDbHelper;

import java.text.NumberFormat;

/**
 * {@link ProductCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of product data as its data source. This adapter knows
 * how to create list items for each row of product data in the {@link Cursor}.
 */
public class ProductCursorAdapter extends CursorAdapter {

    /**
     * Initialise the private variables
     */
    private TextView mNameTextView;
    private TextView mPriceTextView;
    private TextView mQuantityTextView;
    private Button mSaleButton;     // For Product quantity.

    /**
     * Constructs a new {@link ProductCursorAdapter}.
     *
     * @param context The context.
     * @param cursor  The cursor from which to get the data.
     */
    public ProductCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context.
     * @param cursor  The cursor from which to get the data. The cursor is already.
     *                moved to the correct position.
     * @param parent The parent to which the new view is attached to the newly created list
     *               item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in the list_item.xml.
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the product data (in the current row pointed to by the cursor) to the given
     * list item layout.
     *
     * @param view      Existing view, returned earlier by newView() method.
     * @param context   app context.
     * @param cursor    The cursor from which to get the data. The cursor is already moved to the
     *                  correct row.
     */
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Find individual views that we want to modify in the list item layout.
        mNameTextView = view.findViewById(R.id.name);
        mPriceTextView = view.findViewById(R.id.price);
        mQuantityTextView = view.findViewById(R.id.quantity_in_stock);
        mSaleButton = view.findViewById(R.id.sale_button);

        // Find and read the product attributes from the Cursor for the current product.
        String productName = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_NAME));
        String productPrice = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_PRICE));
        final String mProductQuantity = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_QUANTITY));
        final int id = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry._ID));

        // Currency of the price
        NumberFormat format = NumberFormat.getCurrencyInstance();

        // Update the TextViews with the attribute for the current product.
        mNameTextView.setText(productName);
        mPriceTextView.setText(format.format(Double.valueOf(productPrice)));
        mQuantityTextView.setText(String.valueOf(mProductQuantity));
        mSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If there is no more stock display toast message else decrease quantity by 1.
                if (Integer.parseInt(mProductQuantity) == 0) {
                    Toast.makeText(context, R.string.no_stock, Toast.LENGTH_SHORT).show();
                } else {
                    // This decreases the items' stock quantity.
                    int quantity = Integer.parseInt(mProductQuantity) - 1;
                    // This sets up the values to change.
                    ContentValues values = new ContentValues();
                    // This changes the values.
                    values.put(ProductContract.ProductEntry.COLUMN_PRODUCT_QUANTITY, quantity);
                    // This points to which row needs changing.
                    String selection = ProductContract.ProductEntry._ID + "+?";
                    // This points to which database item on the list to change.
                    Uri currentProduct = ContentUris.withAppendedId(ProductContract.ProductEntry.CONTENT_URI, id);
                    // This points to which column needs changing.
                    String[] selectionArgs = new String[]{String.valueOf(id)};
                    //This updates the database via the content resolver.
                    context.getContentResolver().update(currentProduct, values, selection, selectionArgs);
                }
            }
        });
    }
}
