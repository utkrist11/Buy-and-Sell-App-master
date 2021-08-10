package com.ce17b019.inventoryapp.sampledata;

import android.provider.BaseColumns;

public class itemcontract {


        public itemcontract () {
        }

        public static final class StockEntry implements BaseColumns {

            public static final String TABLE_NAME = "stock";
            public static final String COLUMN_NAME = "name";
            public static final String _ID = BaseColumns._ID;
            public static final String COLUMN_QUANTITY1 = "quantity1";
            public static final String COLUMN_QUANTITY2 = "quantity2";



            public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                    itemcontract.StockEntry.TABLE_NAME + "(" +
                    itemcontract.StockEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    itemcontract.StockEntry.COLUMN_NAME + " TEXT NOT NULL," +
                    itemcontract.StockEntry.COLUMN_QUANTITY1 + " INTEGER NOT NULL DEFAULT 0," +
                    itemcontract.StockEntry.COLUMN_QUANTITY2 + " INTEGER NOT NULL DEFAULT 0," + ");";
        }

    }
