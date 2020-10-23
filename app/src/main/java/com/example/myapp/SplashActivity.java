package com.example.myapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SplashActivity extends AppCompatActivity{

    Button btn1;
    TextView txtview;
    TextInputLayout mobile,pass;
    DatabaseHelper dh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtview = (TextView) findViewById(R.id.txt1);
        btn1 = (Button) findViewById(R.id.btn);
        mobile = (TextInputLayout) findViewById(R.id.mob1);
        pass = (TextInputLayout) findViewById(R.id.pass1);
        dh = new DatabaseHelper(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted = dh.insertData(mobile.getEditText().getText().toString(),pass.getEditText().getText().toString());
                if(isinserted==true){
                    Toast too = Toast.makeText(getApplicationContext(), "Successfully Loggedin", Toast.LENGTH_SHORT);
                    too.setGravity(Gravity.BOTTOM,0,25);
                    too.show();
                    Intent i = new Intent(getApplicationContext(),Views.class);
                    startActivity(i);
                }
                else{
                    Toast too = Toast.makeText(getApplicationContext(), "Unsuccessfull Loign", Toast.LENGTH_SHORT);
                    too.setGravity(Gravity.BOTTOM,0,25);
                    too.show();
                }
            }
        });



    }
}

