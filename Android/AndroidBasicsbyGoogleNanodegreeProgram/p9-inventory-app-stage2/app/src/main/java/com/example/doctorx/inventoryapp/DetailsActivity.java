package com.example.doctorx.inventoryapp;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorx.inventoryapp.data.ProductContract.ProductEntry;

import java.text.NumberFormat;

public class DetailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /** Identifier for the book data loader */
    private static final int EXISTING_PRODUCT_LOADER = 0;

    /** Content URI for the existing book (null if it's a new book). */
    private Uri mCurrentProductUri;

    /** TextView field to enter the product's name. */
    private TextView mProductNameTextView;

    /** TextView field to enter the product's price. */
    private TextView mPriceTextView;

    /** TextView field to enter the product's quantity. */
    private TextView mQuantityTextView;

    /** TextView field to enter the product's supplier name. */
    private TextView mSupplierNameTextView;

    /** TextView field to enter the product's supplier phone number. */
    private TextView mSupplierPhoneTextView;

    /** Button to increase the quantity. */
    private ImageButton mIncreaseButton;

    /** Button to decrease the quantity. */
    private ImageButton mDecreaseButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Examine the intent that opened this activity.
        Intent intent = getIntent();
        mCurrentProductUri = intent.getData();

        // Initialize a Loader to read the Product data from the database and display the current values in the editor.
        getLoaderManager().initLoader(EXISTING_PRODUCT_LOADER, null, null);

        // Finding all relevant views.
        mProductNameTextView = findViewById(R.id.detailed_view_product_name);
        mPriceTextView = findViewById(R.id.detailed_view_product_price);
        mQuantityTextView = findViewById(R.id.detailed_view_product_quantity);
        mSupplierNameTextView = findViewById(R.id.detailed_view_supplier_name);
        mSupplierPhoneTextView = findViewById(R.id.detailed_view_supplier_phone);
        mIncreaseButton = findViewById(R.id.detailed_view_increase_quantity);
        mDecreaseButton = findViewById(R.id.detailed_view_decrease_quantity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Intent intent = new Intent(DetailsActivity.this, EditorActivity.class);
                intent.setData(mCurrentProductUri);
                startActivity(intent);
                return true;
            case R.id.action_delete:
                showDeleteConfirmationDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Defining the Projection for all columns from the book table.
        String[] projection = new String[] {
                ProductEntry._ID,
                ProductEntry.COLUMN_PRODUCT_NAME,
                ProductEntry.COLUMN_PRODUCT_PRICE,
                ProductEntry.COLUMN_PRODUCT_QUANTITY,
                ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                ProductEntry.COLUMN_PRODUCT_SUPPLIER_PHONE
        };

        // This loader will execute the ContentProvider's query method on a background thread.
        return new CursorLoader(this, mCurrentProductUri, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        // Bail early if the cursor is null or there is less than 1 row in the cursor.
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor).
        if (cursor.moveToFirst()) {
            // Find and read the Product attributes from the Cursor for the current book.
            String name = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME));
            double price = cursor.getDouble(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE));
            String supplierName = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME));
            String supplierPhone = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_SUPPLIER_PHONE));
            final int quantity = cursor.getInt(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY));
            final int id = cursor.getInt(cursor.getColumnIndex(ProductEntry._ID));

            setTitle(name);

            // Context Intialization for increase && decrease button to work.
            final Context context = this;

            // Add local currency to the price.
            NumberFormat format = NumberFormat.getCurrencyInstance();

            // Update the views on the screen with the values from the database.
            mProductNameTextView.setText(name);
            mPriceTextView.setText(format.format(Double.valueOf(price)));
            mQuantityTextView.setText(Integer.toString(quantity));
            mSupplierNameTextView.setText(supplierName);
            mSupplierPhoneTextView.setText(supplierPhone);
            mIncreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increases items' stock quantity by one.
                    int productQuantity = quantity + 1;

                    // Setting up the values for change.
                    ContentValues values = new ContentValues();
                    values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, productQuantity);
                    String selection = ProductEntry._ID + "=?";
                    Uri currentProduct = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, id);
                    String[] selectionArgs = new String[] {String.valueOf(id)};
                    context.getContentResolver().update(currentProduct, values, selection, selectionArgs);
                }
            });
            mDecreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // if stock = 1 display toast msg else decrease by 1.
                    if (quantity > 1) {
                        Toast.makeText(context, R.string.no_stock, Toast.LENGTH_SHORT).show();
                    } else {
                        int bookQuantity = quantity - 1;
                        ContentValues values = new ContentValues();
                        values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, bookQuantity);
                        String selection = ProductEntry._ID + "+?";
                        Uri currentProduct = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, id);
                        String[] selectionArgs = new String[]{String.valueOf(id)};
                        context.getContentResolver().update(currentProduct, values, selection, selectionArgs);
                    }
                }
            });
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    /*********************************** ALL HELPER METHODS ***************************************/

    /**
     * Alert the user for using delete button.
     */
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the Product.
                deleteProduct();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog and continue editing.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog.
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Perform the Deletion of the Product on the Database.
     */
    private void deleteProduct() {
        // Call the ContentResolver to delete the Product at the given URI.
        int rowsDeleted = getContentResolver().delete(mCurrentProductUri, null, null);

        // Show Toast Msg based on the deletion status
        if (rowsDeleted != 0) {
            Toast.makeText(this, getString(R.string.editor_delete_product_failed),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.editor_delete_book_successful),
                    Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
