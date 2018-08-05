package com.example.doctorx.inventoryapp.data;

import android.provider.BaseColumns;

public class ProductContract {

    private ProductContract() {}

    public static abstract class ProductEntry implements BaseColumns {

        public static final String TABLE_NAME = "products";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_PRODUCT_PRICE = "price";
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";
        public static final String COLUMN_PRODUCT_SUPPLIER = "supplier";
        public static final String COLUMN_PRODUCT_PHONE = "phone";
    }
}
