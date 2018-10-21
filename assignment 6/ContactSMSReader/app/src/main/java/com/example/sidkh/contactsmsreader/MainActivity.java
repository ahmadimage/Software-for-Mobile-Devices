package com.example.sidkh.contactsmsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button forCont, forSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forCont=(Button) findViewById(R.id.forContacts);
        forCont.setOnClickListener(this);
        forSms = (Button) findViewById(R.id.forSMS);
        forSms.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forContacts:
                Intent intent = new Intent(this, Contact.class);
                startActivity(intent);
                break;
            case R.id.forSMS:
                Intent intent2 = new Intent(this, SMS.class);
                startActivity(intent2);
                break;
        }

    }
}
