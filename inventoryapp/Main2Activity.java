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
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int number,number1;
    TextView tv12,tv2,tv7,tv10,tv8,tv11 ;
    Button b11,b12,b7,b8;
    Button b9,b10,b13,b14,b15;
    TextView tv22,tv21;
    int tag2,tag3,tag4;


    ImageView view1,view2;

    DataManager dm;

    SQLiteDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dm = new DataManager(this);
        db = dm.getWritableDatabase();



        Intent intent4 =getIntent();

        int item1 = intent4.getIntExtra("item1",-1);
        tv2 =  (TextView)findViewById(R.id.textView2);
        tv2.setText(Integer.toString(item1));
        int item2 = intent4.getIntExtra("item2",-1);
        tv12 = (TextView) findViewById(R.id.textView12);
        tv12.setText(Integer.toString(item2));



        int tag = intent4.getIntExtra("tag",-1);
         tag3 = intent4.getIntExtra("tag3",-1);
        if(tag==0){

            b7 = (Button) findViewById(R.id.button7);
            b7.setVisibility(View.INVISIBLE);
            b8 = (Button) findViewById(R.id.button8);
            b8.setVisibility(View.INVISIBLE);
            b11 = (Button) findViewById(R.id.button11);
            b11.setVisibility(View.INVISIBLE);
            b12 = (Button) findViewById(R.id.button12);
            b12.setVisibility(View.INVISIBLE);

        }

        Intent intent6 = getIntent();
        tag2 = intent6.getIntExtra("tag1",-1);
        tag4 = intent6.getIntExtra("tag4",-1);
        if(tag2==1 ||tag2==2 ||tag2==3 ||tag2==4 ||tag2==5){
            b9 = (Button) findViewById(R.id.button9);
            b9.setVisibility(View.INVISIBLE);
            b10 = (Button) findViewById(R.id.button10);
            b10.setVisibility(View.INVISIBLE);
            b13 = (Button) findViewById(R.id.button13);
            b13.setVisibility(View.INVISIBLE);
            b14 = (Button) findViewById(R.id.button14);
            b14.setVisibility(View.INVISIBLE);
            b15 = (Button) findViewById(R.id.button15);
            b15.setVisibility(View.INVISIBLE);
            tv8 = (TextView) findViewById(R.id.textView8);
            tv8.setVisibility(View.INVISIBLE);
            tv11 = (TextView) findViewById(R.id.textView11);
            tv11.setVisibility(View.INVISIBLE);
            tv21 = (TextView) findViewById(R.id.textView21);
            tv21.setVisibility(View.INVISIBLE);
            tv22 = (TextView) findViewById(R.id.textView22);
            tv22.setVisibility(View.INVISIBLE);

        }

        view1 = (ImageView) findViewById(R.id.imageView);
        view2 = (ImageView) findViewById(R.id.imageView1);
        tv7 = (TextView) findViewById(R.id.textView7);
        tv10 = (TextView) findViewById(R.id.textView10);
        tv21 = (TextView) findViewById(R.id.textView21);
        tv22 = (TextView) findViewById(R.id.textView22);

        if(tag3==1 || tag4==1){
            tv7.setText("Chocolate");
            tv10.setText("Icecream");
            tv21.setText("$20");
            tv22.setText("$30");
            view1.setImageResource(R.drawable.index1);
            view2.setImageResource(R.drawable.index3);

        }else if (tag3==2 || tag4==2){
            tv7.setText("Apple");
            tv10.setText("Mango");
            tv21.setText("$15");
            tv22.setText("$10");
            view1.setImageResource(R.drawable.index4);
            view2.setImageResource(R.drawable.index5);
        }else if (tag3==3 || tag4==3){
            tv7.setText("Potato");
            tv10.setText("Carrot");
            tv21.setText("$4");
            tv22.setText("$3");
            view1.setImageResource(R.drawable.index6);
            view2.setImageResource(R.drawable.index7);
        }else if (tag3==4 || tag4==4){
            tv7.setText("Quartz");
            tv10.setText("Rado");
            tv21.setText("$200");
            tv22.setText("$300");
            view1.setImageResource(R.drawable.index8);
            view2.setImageResource(R.drawable.index9);
        }else if (tag3==5 || tag4==5){
            tv7.setText("Predator");
            tv10.setText("hp pavilion");
            tv21.setText("$3000");
            tv22.setText("$2400");
            view1.setImageResource(R.drawable.index10);
            view2.setImageResource(R.drawable.index11);
        }



    Button mycart = (Button) findViewById(R.id.button15);
        mycart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv8 = (TextView) findViewById(R.id.textView8);
                tv11 = (TextView) findViewById(R.id.textView11);
                tv7 = (TextView) findViewById(R.id.textView7);
                tv10 = (TextView) findViewById(R.id.textView10);

                Intent intent5 = new Intent(Main2Activity.this,Main5Activity.class);
                intent5.putExtra("item1",tv7.getText().toString());
                intent5.putExtra("item2",tv10.getText().toString());
                intent5.putExtra("q1",tv8.getText().toString());
                intent5.putExtra("q2",tv11.getText().toString());

                startActivity(intent5);


            }
        });







    }

    public void add(View view){
        tv2 = (TextView) findViewById(R.id.textView2);
        String str1 =tv2.getText().toString();
        int a = Integer.parseInt(str1);

        TextView tv8 = (TextView) findViewById(R.id.textView8);
        number = Integer.parseInt(tv8.getText().toString());




        if(a>0){
            number+=1;
            ContentValues values = new ContentValues();
            values.put("quantity",Integer.toString(a-1));
            String[] projection = {"name","quantity"};
            Log.d("tag111", Integer.toString(tag3));
//            Log.d("helklsdo","sdfiuhsduig");
//
//            String projections[] = {"name","quantity"};
//            Cursor c = db.query("login", projections,null,null,null,null,null);
//            c.moveToPosition(0);
//            Log.d("lkndfklgdjfkl",c.getString(1));


            if(tag3==1 || tag4==1){

                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }

            tv2.setText(Integer.toString(a-1));
        }
        else{
            tv2.setText(Integer.toString(a));
            ContentValues values = new ContentValues();
            values.put("quantity",Integer.toString(a));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }
        }
        tv8.setText(Integer.toString(number));



    }
    public void substract(View view) {
        tv2 = (TextView) findViewById(R.id.textView2);
        String str1 =tv2.getText().toString();
        int a = Integer.parseInt(str1);


        TextView tv8 = (TextView) findViewById(R.id.textView8);
        number = Integer.parseInt(tv8.getText().toString());
        if(number>0) {
            tv2.setText(Integer.toString(a + 1));

            ContentValues values = new ContentValues();
            values.put("quantity",Integer.toString(a+1));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }

        }else{
            tv2.setText(Integer.toString(a));

            ContentValues values = new ContentValues();
            values.put("quantity",Integer.toString(a));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }
        }
        if (number == 0) {
            number = 0;
        } else {
            number -= 1;
        }
        tv8.setText(Integer.toString(number));




    }

    public void add1(View view){
        tv12= (TextView) findViewById(R.id.textView12);
        String str2 =tv12.getText().toString();
        int b = Integer.parseInt(str2);

        TextView tv11 = (TextView) findViewById(R.id.textView11);

        ContentValues values = new ContentValues();


        if(b>0){
            number1+=1;

            values.put("quantity",Integer.toString(b-1));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }
            tv12.setText(Integer.toString(b-1));
        }
        else{

            values.put("quantity",Integer.toString(b));
            String[] projection = {"name","quantity"};

            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }

            tv12.setText(Integer.toString(b));
        }
        tv11.setText(Integer.toString(number1));

    }
    public void substract1(View view) {
        tv12= (TextView) findViewById(R.id.textView12);
        String str2 =tv12.getText().toString();
        int b = Integer.parseInt(str2);

        TextView tv11 = (TextView) findViewById(R.id.textView11);
        number1 = Integer.parseInt(tv11.getText().toString());

        ContentValues values = new ContentValues();


        if(number1>0) {
            values.put("quantity",Integer.toString(b+1));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }
            tv12.setText(Integer.toString(b + 1));
        }else{

            values.put("quantity",Integer.toString(b));
            String[] projection = {"name","quantity"};


            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }
            tv12.setText(Integer.toString(b));
        }
        if (number1 == 0) {
            number1 = 0;
        } else {
            number1 -= 1;
        }
        tv11.setText(Integer.toString(number1));


    }

    public void admin_add1(View view){
        tv2 = (TextView) findViewById(R.id.textView2);
        String str1 =tv2.getText().toString();
        int a = Integer.parseInt(str1);

        ContentValues values = new ContentValues();
        values.put("quantity",Integer.toString(a+1));
        String[] projection = {"name","quantity"};


        if(tag3==1 || tag4==1){
            db.update("item",values,"name =?",new String[]{"item1"});
        }else if (tag3==2 || tag4==2){
            db.update("item",values,"name =?",new String[]{"item3"});
        }else if (tag3==3 || tag4==3){
            db.update("item",values,"name =?",new String[]{"item5"});
        }else if (tag3==4 || tag4==4){
            db.update("item",values,"name =?",new String[]{"item7"});
        }else if (tag3==5 || tag4==5){
            db.update("item",values,"name =?",new String[]{"item9"});
        }

        tv2.setText(Integer.toString(a + 1));

    }
    public void admin_substract1(View view){
        tv2 = (TextView) findViewById(R.id.textView2);
        String str1 =tv2.getText().toString();
        int a = Integer.parseInt(str1);

        ContentValues values = new ContentValues();
        if(a>0){

            values.put("quantity",Integer.toString(a-1));
            String[] projection = {"name","quantity"};

            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }
            tv2.setText(Integer.toString(a - 1));

        }else{

            values.put("quantity",Integer.toString(a));
            String[] projection = {"name","quantity"};

            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item1"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item3"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item5"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item7"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item9"});
            }
            tv2.setText(Integer.toString(a));

        }

    }
    public void admin_add2(View view){
        tv12 = (TextView) findViewById(R.id.textView12);
        String str1 =tv12.getText().toString();
        int a = Integer.parseInt(str1);

        ContentValues values = new ContentValues();
        values.put("quantity",Integer.toString(a+1));
        String[] projection = {"name","quantity"};

        if(tag3==1 || tag4==1){
            db.update("item",values,"name =?",new String[]{"item2"});
        }else if (tag3==2 || tag4==2){
            db.update("item",values,"name =?",new String[]{"item4"});
        }else if (tag3==3 || tag4==3){
            db.update("item",values,"name =?",new String[]{"item6"});
        }else if (tag3==4 || tag4==4){
            db.update("item",values,"name =?",new String[]{"item8"});
        }else if (tag3==5 || tag4==5){
            db.update("item",values,"name =?",new String[]{"item10"});
        }
        tv12.setText(Integer.toString(a + 1));

    }
    public void admin_substract2(View view){
        tv12 = (TextView) findViewById(R.id.textView12);
        String str1 =tv12.getText().toString();
        int a = Integer.parseInt(str1);

        ContentValues values = new ContentValues();
        if(a>0){
            values.put("quantity",Integer.toString(a+1));
            String[] projection = {"name","quantity"};

            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }
            tv12.setText(Integer.toString(a - 1));

        }else{
            values.put("quantity",Integer.toString(a));
            String[] projection = {"name","quantity"};
            if(tag3==1 || tag4==1){
                db.update("item",values,"name =?",new String[]{"item2"});
            }else if (tag3==2 || tag4==2){
                db.update("item",values,"name =?",new String[]{"item4"});
            }else if (tag3==3 || tag4==3){
                db.update("item",values,"name =?",new String[]{"item6"});
            }else if (tag3==4 || tag4==4){
                db.update("item",values,"name =?",new String[]{"item8"});
            }else if (tag3==5 || tag4==5){
                db.update("item",values,"name =?",new String[]{"item10"});
            }
            tv12.setText(Integer.toString(a));

        }

    }
}
