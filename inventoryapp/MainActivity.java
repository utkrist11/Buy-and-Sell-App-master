package com.ce17b019.inventoryapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dm = new DataManager(this);
        final SQLiteDatabase db1 = dm.getWritableDatabase();








        Button b1;
        Button b2;
        Button b3;
        Button b4;
        Button b5;

        b1 =(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(MainActivity.this ,Main2Activity.class);

                String projection[] = {"name","quantity"};
                Cursor c = db1.query("item",projection,null,null,null,null,null);
                c.moveToPosition(0);
                intent4.putExtra("item1" ,Integer.parseInt(c.getString(1)));
                Log.d("item1jksdhsjdsd" ,c.getString(1));

                c.moveToPosition(1);
                intent4.putExtra("item2" ,Integer.parseInt(c.getString(1)));

                intent4.putExtra("tag",0);
                intent4.putExtra("tag3",1);
                startActivity(intent4);



            }
        });

        b2 =(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(MainActivity.this ,Main2Activity.class);

                String projection[] = {"name","quantity"};
                Cursor c = db1.query("item",projection,null,null,null,null,null);

                c.moveToPosition(2);
                intent4.putExtra("item1" ,Integer.parseInt(c.getString(1)));
                c.moveToPosition(3);
                intent4.putExtra("item2" ,Integer.parseInt(c.getString(1)));

                intent4.putExtra("tag",0);
                intent4.putExtra("tag3",2);

                startActivity(intent4);



            }
        }); b3 =(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(MainActivity.this ,Main2Activity.class);

                String projection[] = {"name","quantity"};
                Cursor c = db1.query("item",projection,null,null,null,null,null);

                c.moveToPosition(4);
                intent4.putExtra("item1" ,Integer.parseInt(c.getString(1)));
                c.moveToPosition(5);
                intent4.putExtra("item2" ,Integer.parseInt(c.getString(1)));

                intent4.putExtra("tag",0);
                intent4.putExtra("tag3",3);

                startActivity(intent4);



            }
        }); b4 =(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(MainActivity.this ,Main2Activity.class);

                String projection[] = {"name","quantity"};
                Cursor c = db1.query("item",projection,null,null,null,null,null);

                c.moveToPosition(6);
                intent4.putExtra("item1" ,Integer.parseInt(c.getString(1)));
                c.moveToPosition(7);
                intent4.putExtra("item2" ,Integer.parseInt(c.getString(1)));

                intent4.putExtra("tag",0);
                intent4.putExtra("tag3",4);

                startActivity(intent4);



            }
        }); b5 =(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent4 = new Intent(MainActivity.this ,Main2Activity.class);

                String projection[] = {"name","quantity"};
                Cursor c = db1.query("item",projection,null,null,null,null,null);

                c.moveToPosition(8);
                intent4.putExtra("item1" ,Integer.parseInt(c.getString(1)));
                c.moveToPosition(9);
                intent4.putExtra("item2" ,Integer.parseInt(c.getString(1)));

                intent4.putExtra("tag",0);
                intent4.putExtra("tag3",5);

                startActivity(intent4);



            }
        });



    }


}
