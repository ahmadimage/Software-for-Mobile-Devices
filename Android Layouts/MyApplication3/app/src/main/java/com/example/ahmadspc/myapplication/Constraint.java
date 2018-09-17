package com.example.ahmadspc.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Constraint extends Activity {

    Button btn;
    TextView textView;
    TextView textView2;
    String password;
    String mail;
    CheckBox b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        btn = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.editText);
        //textView.getText().toString();
        textView2=(TextView) findViewById(R.id.editText2);
        b1=(CheckBox)findViewById(R.id.checkBox3);
        b1.isChecked();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(!b1.isChecked())
                {

                    Toast.makeText(getApplicationContext(), "Please Accept Terms and Agreements", Toast.LENGTH_SHORT).show();
                }
                else if(textView.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter an email address", Toast.LENGTH_SHORT).show();
                }
                else if(textView2.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter a password", Toast.LENGTH_SHORT).show();
                }
                else if(textView2.getText().toString().length()<=7)
                {
                    Toast.makeText(getApplicationContext(), "Password must be more than 7 characters", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(getApplicationContext(), "Email: " + textView.getText().toString() + " Password: " + textView2.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    }


