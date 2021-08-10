package com.ce17b019.inventoryapp.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDbHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "inventory.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = InventoryDbHelper.class.getCanonicalName();

    public InventoryDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(itemcontract.StockEntry.CREATE_TABLE_STOCK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void insertItem(items item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(itemcontract.StockEntry.COLUMN_NAME, item.getProductName());
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY1, item.getQuantity1());
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY2, item.getQuantity1());
        long id = db.insert(itemcontract.StockEntry.TABLE_NAME, null, values);
    }



    public Cursor readStock() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                itemcontract.StockEntry._ID,
                itemcontract.StockEntry.COLUMN_NAME,
                itemcontract.StockEntry.COLUMN_QUANTITY1,
                itemcontract.StockEntry.COLUMN_QUANTITY2

        };
        Cursor cursor = db.query(
                itemcontract.StockEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }



    public Cursor readItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                itemcontract.StockEntry._ID,
                itemcontract.StockEntry.COLUMN_NAME,
                itemcontract.StockEntry.COLUMN_QUANTITY1,
                itemcontract.StockEntry.COLUMN_QUANTITY2,


        };

        String selection = itemcontract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                itemcontract.StockEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }



    public void updateItem(long currentItemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY1, quantity);
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY2, quantity);
        String selection = itemcontract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(itemcontract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }



    public void sellOneItem(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity -1;
        }
        ContentValues values = new ContentValues();
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY1, newQuantity);
        values.put(itemcontract.StockEntry.COLUMN_QUANTITY1, newQuantity);
        String selection = itemcontract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };
        db.update(itemcontract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }
}
