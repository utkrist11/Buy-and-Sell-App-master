package com.ce17b019.inventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    TextView tv13,tv14,tv15,tv16,tv18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent5 =getIntent();
        String item1 = intent5.getStringExtra("item1");
        String item2 = intent5.getStringExtra("item2");
        String q1 = intent5.getStringExtra("q1");
        String q2 = intent5.getStringExtra("q2");

        tv13 = (TextView)findViewById(R.id.textView13);
        tv13.setText(item1);
        tv15 = (TextView)findViewById(R.id.textView15);
        tv15.setText(item2);
        tv14 = (TextView)findViewById(R.id.textView14);
        tv14.setText(q1);
        tv16 = (TextView)findViewById(R.id.textView16);
        tv16.setText(q2);

        int p1 = Integer.parseInt(tv14.getText().toString());
        int p2 = Integer.parseInt(tv16.getText().toString());

        int price = p1*10 + p2*20;

        tv18 = (TextView) findViewById(R.id.textView18);
        tv18.setText("$" +  Integer.toString(price));


    }
}
