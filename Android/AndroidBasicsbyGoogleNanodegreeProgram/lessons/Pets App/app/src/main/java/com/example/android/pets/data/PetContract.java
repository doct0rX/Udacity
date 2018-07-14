package com.example.android.pets.data;

import android.provider.BaseColumns;

public final class PetContract {

    public static abstract class PetEntry implements BaseColumns {

        public final static String TABLE_NAME = "pets";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_BET_NAME = "name";
        public final static String COLUMN_BET_BREED = "breed";
        public final static String COLUMN_BET_GENDER = "gender";
        public final static String COLUMN_BET_WIGHT = "weight";

        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE     = 1;
        public final static int GENDER_FEMALE   = 2;
    }
}
