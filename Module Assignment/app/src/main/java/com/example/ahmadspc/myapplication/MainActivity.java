package com.example.ahmadspc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mod1.NewClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NewClass newClass= new NewClass();

    }
}
