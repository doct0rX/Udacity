package com.example.doctorx.inventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class ProductContract {

    /** To prevent someone from accidentally instantiating the contract class, give it an empty constructor. */
    private ProductContract() {}


    /** The "Content authority" to be used for the URI */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryapp";

    /** Base for all URI's which the app will use to contact the content provider. */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /** Possible path appended to base content URI for possible URI's.*/
    public static final String PATH_PRODUCT = "products";

    /**
     * Inner class that defines constant values for the products database table.
     * Each entry in the table represents a single product.
     */
    public static abstract class ProductEntry implements BaseColumns {

        /** The content URI to access the product data in the provider. */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCT);

        /** The MIME type of the {@link #CONTENT_URI} for a list of products. */
        public static final String CONTENT_LIST_TYPE =  ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;

        /** The MIME type of the {@link #CONTENT_URI} for a single product */
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;

        /** Name of database table for products. */
        public static final String TABLE_NAME = "products";


        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_PRODUCT_PRICE = "price";
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";
        public static final String COLUMN_PRODUCT_SUPPLIER_NAME = "supplier";
        public static final String COLUMN_PRODUCT_SUPPLIER_PHONE = "phone";
    }
}
