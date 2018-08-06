package com.example.android.inventoryapp;

import android.annotation.SuppressLint;
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

import com.example.android.inventoryapp.data.ProductContract;
import com.example.android.inventoryapp.data.ProductContract.ProductEntry;

import java.text.NumberFormat;

public class DetailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * Identifier for the product data loader.
     */
    private static final int EXISTING_PRODUCT_LOADER = 0;

    /**
     * Content URI for the existing product (null if it's a new product).
     */
    private Uri mCurrentProductUri;

    /**
     * TextView field to enter the product's name.
     */
    private TextView mProductNameTextView;

    /**
     * TextView field to enter the product's price.
     */
    private TextView mPriceTextView;

    /**
     * TextView field to enter the product's quantity.
     */
    private TextView mQuantityTextView;

    /**
     * TextView field to enter the product's supplier name.
     */
    private TextView mSupplierNameTextView;

    /**
     * TextView field to enter the product's supplier phone number.
     */
    private TextView mSupplierPhoneTextView;

    /**
     * Button to increase the quantity.
     */
    private ImageButton mIncreaseButton;

    /**
     * Button to decrease the quantity.
     */
    private ImageButton mDecreaseButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Examine the intent that was used to launch this activity.
        Intent intent = getIntent();
        mCurrentProductUri = intent.getData();

        //Initialize a loader to read the product data from the database
        // and display the current values in the editor.
        getLoaderManager().initLoader(EXISTING_PRODUCT_LOADER, null, this);

        // Find all relevant views.
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
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        getMenuInflater().inflate(R.menu.menu_detailed_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu.
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option.
            case R.id.action_edit:
                // Create new intent to go to {@link EditorActivity}.
                Intent intent = new Intent(DetailsActivity.this, EditorActivity.class);
                // Send the data for the URI with the intent.
                intent.setData(mCurrentProductUri);
                // Launch the {@link EditorActivity} to display the data for the current product.
                startActivity(intent);
                return true;
            // Respond to a click on the "Delete" menu option.
            case R.id.action_delete:
                // Pop up confirmation dialog for deletion.
                showDeleteConfirmationDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Since the editor shows all product attributes, define a projection that contains
        // all columns from the product table.
        String[] projection = new String[]{
                ProductContract.ProductEntry._ID,
                ProductContract.ProductEntry.COLUMN_PRODUCT_NAME,
                ProductEntry.COLUMN_PRODUCT_PRICE,
                ProductEntry.COLUMN_PRODUCT_QUANTITY,
                ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_PHONE};

        // This loader will execute the ContentProvider's query method on a background thread.
        return new CursorLoader(this, // Parent activity context.
                mCurrentProductUri,               // Query the content URI for the current product.
                projection,                   // The columns to include int he resulting cursor.
                null,                // No selection clause.
                null,            // No selection arguments.
                null);              // Default sort order.
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        // Bail early if the cursor is null or there is less than 1 row in the cursor.
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor).
        if (cursor.moveToFirst()) {
            // Find and read the book attributes from the Cursor for the current book.
            String name = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME));
            double price = cursor.getDouble(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE));
            String supplierName = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME));
            String supplierPhone = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_SUPPLIER_PHONE));
            final int quantity = cursor.getInt(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY));
            final int id = cursor.getInt(cursor.getColumnIndex(ProductEntry._ID));

            setTitle(name);

            // Context initialised for increase and decrease buttons to work.
            final Context context = this;

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
                    // This increases the items' stock quantity by one.
                    int bookQuantity = quantity + 1;
                    // This sets up the values to change.
                    ContentValues values = new ContentValues();
                    // This changes the values.
                    values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, bookQuantity);
                    // This points to which row needs changing.
                    String selection = ProductEntry._ID + "+?";
                    // This points to which database item on the list to change.
                    Uri currentBook = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, id);
                    // This points to which column needs changing.
                    String[] selectionArgs = new String[]{String.valueOf(id)};
                    //This updates the database via the content resolver.
                    context.getContentResolver().update(currentBook, values, selection, selectionArgs);

                }
            });

            mDecreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // If there is no more stock display toast message else decrease quantity by 1.
                    if (quantity == 0) {
                        Toast.makeText(context, R.string.no_stock, Toast.LENGTH_SHORT).show();
                    } else {
                        // This decreases the items' stock quantity.
                        int bookQuantity = quantity - 1;
                        // This sets up the values to change.
                        ContentValues values = new ContentValues();
                        // This changes the values.
                        values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, bookQuantity);
                        // This points to which row needs changing.
                        String selection = ProductEntry._ID + "+?";
                        // This points to which database item on the list to change.
                        Uri currentBook = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, id);
                        // This points to which column needs changing.
                        String[] selectionArgs = new String[]{String.valueOf(id)};
                        //This updates the database via the content resolver.
                        context.getContentResolver().update(currentBook, values, selection, selectionArgs);
                    }
                }
            });
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    /********************************** ALL HELPER METHODS ****************************************/

    /**
     * Perform the deletion of the product in the database.
     */
    private void deleteProduct() {
        // Call the ContentResolver to delete the product at the given content URI.
        int rowsDeleted = getContentResolver().delete(mCurrentProductUri, null,
                null);

        // Show a toast message depending on whether or not the delete was successful.
        if (rowsDeleted == 0) {
            // If no rows were deleted, then there was an error with the delete.
            Toast.makeText(this, getString(R.string.editor_delete_product_failed),
                    Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the delete was successful and we can display a toast.
            Toast.makeText(this, getString(R.string.editor_delete_product_successful),
                    Toast.LENGTH_SHORT).show();
        }

        // Close the activity.
        finish();
    }

    /**
     * The alert confirmation when user presses the delete button.
     */
    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the product.
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
}
