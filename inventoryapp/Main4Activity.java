package com.ce17b019.inventoryapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button b1 = (Button) findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText e1 =(EditText) findViewById(R.id.editText2);
                String firstname= e1.getText().toString();
                EditText e2 =(EditText) findViewById(R.id.editText3);
                String username= e2.getText().toString();
                EditText e3 =(EditText) findViewById(R.id.editText4);
                String email= e3.getText().toString();
                EditText e4 =(EditText) findViewById(R.id.editText5);
                String password= e4.getText().toString();
                EditText e5 =(EditText) findViewById(R.id.editText6);
                String conformpassword= e5.getText().toString();

                DataManager dm = new DataManager(Main4Activity.this);
                SQLiteDatabase db = dm.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("firstname",firstname);
                values.put("username",username);
                values.put("email",email);
                values.put("password",password);
                values.put("conformpassword",conformpassword);
                long row = db.insert("login",null,values);
                Log.d("number", Long.toString(row));





                Intent intent3 = new Intent(Main4Activity.this,Main3Activity.class);
//                intent3.putExtra("firstname",firstname);
//                intent3.putExtra("username",username);
//                intent3.putExtra("email",email);
//                intent3.putExtra("password",password);
//                intent3.putExtra("conformpassword",conformpassword);
//                intent3.putExtra("tag",1);
//                Log.d("hi", username);
                startActivity(intent3);



            }
        });
    }

}
