package com.ce17b019.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataManager extends SQLiteOpenHelper   {


    public DataManager(Context context) {
        super(context, "item.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table item(_id integer primary key autoincrement,name text not null ,quantity text not null)");
        db.execSQL("create table login(_id integer primary key autoincrement,firstname text not null,username text not null ,email text not null ,password text not null,conformpassword text not null )");

        ContentValues values = new ContentValues();
        values.put("firstname","hi");
        values.put("username","hi");
        values.put("email","hi");
        values.put("password","hi");
        values.put("conformpassword","hi");
        db.insert("login",null,values);

        ContentValues values1 = new ContentValues();
        values1.put("name","item1");
        values1.put("quantity",50);
        db.insert("item",null,values1);
        ContentValues values2 = new ContentValues();
        values2.put("name","item2");
        values2.put("quantity",45);
        db.insert("item",null,values2);
        ContentValues values3 = new ContentValues();
        values3.put("name","item3");
        values3.put("quantity",10);
        db.insert("item",null,values3);
        ContentValues values4 = new ContentValues();
        values4.put("name","item4");
        values4.put("quantity",25);
        db.insert("item",null,values4);
        ContentValues values5 = new ContentValues();
        values5.put("name","item5");
        values5.put("quantity",110);
        db.insert("item",null,values5);
        ContentValues values6 = new ContentValues();
        values6.put("name","item6");
        values6.put("quantity",65);
        db.insert("item",null,values6);
        ContentValues values7 = new ContentValues();
        values7.put("name","item7");
        values7.put("quantity",60);
        db.insert("item",null,values7);
        ContentValues values8 = new ContentValues();
        values8.put("name","item8");
        values8.put("quantity",35);
        db.insert("item",null,values8);
        ContentValues values9 = new ContentValues();
        values9.put("name","item9");
        values9.put("quantity",5);
        db.insert("item",null,values9);
        ContentValues values10 = new ContentValues();
        values10.put("name","item10");
        values10.put("quantity",4);
        db.insert("item",null,values10);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop  table if exists item");
//        onCreate(db);
    }
}


