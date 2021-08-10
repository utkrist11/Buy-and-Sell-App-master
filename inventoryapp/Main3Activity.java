package com.ce17b019.inventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.Arrays;

public class Main3Activity extends AppCompatActivity {



    String str1;
    String str2;
    int position;
    DataManager dm;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dm = new DataManager(this);
        db = dm.getReadableDatabase();


        TextView tv1=(TextView) findViewById(R.id.textView);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent1);
            }
        });

        final Button login =(Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.editText);
                EditText et2 = (EditText) findViewById(R.id.editText1);

                str1= et1.getText().toString();
                str2= et2.getText().toString();


                DataManager dm = new DataManager(Main3Activity.this);
                SQLiteDatabase  db = dm.getReadableDatabase();
                String projections[] = {"firstname","username","email","password","conformpassword"};
                Cursor c = db.query("login", projections,null,null,null,null,null);
                Log.d("COUNT", Arrays.toString(c.getColumnNames()));



                c.moveToFirst();
                Log.d("first",c.getString(1));
                while (!c.isAfterLast()){

                    if(c.getString(1).equals(str1)){
                        Log.d("entered if","hello");
                        Log.d(str1, c.getString(1));
                        position = c.getPosition();
                        break;
                    }else {
                        Log.d(str1,c.getString(1));
                        c.moveToNext();


                    }

                }
                c.moveToPosition(position);

                String username=c.getString(1);
                Log.d("user", username);
                String password = c.getString(3);
                Log.d("pwd", password);





                if(str1.equals(username) && str2.equals(password)  ){

                    Intent intent2 = new Intent(Main3Activity.this,MainActivity.class);

                    startActivity(intent2);
                }
                else if(str1.equals("vendor1")&&str2.equals("1") ){
                    Intent intent6 = new Intent(Main3Activity.this,Main2Activity.class);

                    String projection[] = {"name","quantity"};
                    Cursor c1 = db.query("item",projection,null,null,null,null,null);
                    c1.moveToPosition(0);

                    intent6.putExtra("item1" ,Integer.parseInt(c1.getString(1)));

                    c1.moveToPosition(1);
                    intent6.putExtra("item2" ,Integer.parseInt(c1.getString(1)));


                    intent6.putExtra("tag1" ,1);
                    intent6.putExtra("tag4" ,1);

                    startActivity(intent6);

                }
                else if(str1.equals("vendor2")&&str2.equals("2")){
                    Intent intent6 = new Intent(Main3Activity.this,Main2Activity.class);

                    String projection[] = {"name","quantity"};
                    Cursor c1 = db.query("item",projection,null,null,null,null,null);
                    c1.moveToPosition(2);
                    intent6.putExtra("item1" ,Integer.parseInt(c1.getString(1)));

                    c1.moveToPosition(3);
                    intent6.putExtra("item2" ,Integer.parseInt(c1.getString(1)));


                    intent6.putExtra("tag1" ,2);
                    intent6.putExtra("tag4" ,2);
                    startActivity(intent6);
                }
                else if(str1.equals("vendor3")&&str2.equals("3")){
                    Intent intent6 = new Intent(Main3Activity.this,Main2Activity.class);

                    String projection[] = {"name","quantity"};
                    Cursor c1 = db.query("item",projection,null,null,null,null,null);
                    c1.moveToPosition(4);
                    intent6.putExtra("item1" ,Integer.parseInt(c1.getString(1)));

                    c1.moveToPosition(5);
                    intent6.putExtra("item2" ,Integer.parseInt(c1.getString(1)));

                    intent6.putExtra("tag1" ,3);
                    intent6.putExtra("tag4" ,3);
                    startActivity(intent6);
                }
                else if(str1.equals("vendor4")&&str2.equals("4")){
                    Intent intent6 = new Intent(Main3Activity.this,Main2Activity.class);

                    String projection[] = {"name","quantity"};
                    Cursor c1 = db.query("item",projection,null,null,null,null,null);
                    c1.moveToPosition(6);
                    intent6.putExtra("item1" ,Integer.parseInt(c1.getString(1)));

                    c1.moveToPosition(7);
                    intent6.putExtra("item2" ,Integer.parseInt(c1.getString(1)));


                    intent6.putExtra("tag1" ,4);
                    intent6.putExtra("tag4" ,4);
                    startActivity(intent6);
                }
                else if(str1.equals("vendor5")&&str2.equals("5")){
                    Intent intent6 = new Intent(Main3Activity.this,Main2Activity.class);

                    String projection[] = {"name","quantity"};
                    Cursor c1 = db.query("item",projection,null,null,null,null,null);
                    c1.moveToPosition(8);
                    intent6.putExtra("item1" ,Integer.parseInt(c1.getString(1)));

                    c1.moveToPosition(9);
                    intent6.putExtra("item2" ,Integer.parseInt(c1.getString(1)));

                    intent6.putExtra("tag1" ,5);
                    intent6.putExtra("tag4" ,5);
                    startActivity(intent6);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public void showData(Cursor c){
        while (c.moveToNext()){
            Log.i(c.getString(1), c.getString(2));
        }
    }
}
