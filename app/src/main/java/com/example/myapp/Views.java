
package com.example.myapp;


import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Views extends AppCompatActivity {

    RecyclerView rcv;
    DatabaseHelper dh;
    ArrayList<String> user_id,user_mobile;
    UsersAdapter ua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        dh = new DatabaseHelper(this);
        rcv = (RecyclerView) findViewById(R.id.rc);
        user_id = new ArrayList<>();
        user_mobile = new ArrayList<>();
        ua = new UsersAdapter(this,user_id,user_mobile);
        rcv.setAdapter(ua);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        displayData();

    }


        public void displayData(){
        Cursor cv = dh.getAllData();
        if(cv.getCount()==0){
            Toast too = Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT);
            too.setGravity(Gravity.BOTTOM,0,25);
            too.show();
        }
        else{
            while(cv.moveToNext()){
                 user_id.add(cv.getString(0));
                 user_mobile.add(cv.getString(1));
            }
        }

    }
}

