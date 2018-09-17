package com.example.ahmadspc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickButton1(View V){

        Intent i= new Intent(this, Relative.class);
        startActivity(i);



    }

    public void onClickButton2(View V)
    {
        Intent j= new Intent(this, Constraint.class);
        startActivity(j);

    }



}
