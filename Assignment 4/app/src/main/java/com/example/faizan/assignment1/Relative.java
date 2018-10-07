package com.example.faizan.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Relative extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Register;
    private Button Home;
    private RadioButton Radio;
    private RadioGroup RadioGroup;
    private CheckBox checkbox;


    private String gender;
    private String email;
    private String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);


        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);

        email=Email.getText().toString();
        pass=Password.getText().toString();

        Register = (Button) findViewById(R.id.Register);
        Home = (Button) findViewById(R.id.home);

        checkbox=(CheckBox)findViewById(R.id.checkBox);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relative.this, MainActivity.class);
                startActivity(intent);
            }
        });



        RadioGroup=(RadioGroup)findViewById(R.id.RadioGroup);
        RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Radio=(RadioButton)findViewById(checkedId);
                switch(Radio.getId())
                {
                    case R.id.Male:
                    {
                        gender=Radio.getText().toString();
                    }
                    case R.id.Female:
                    {
                        gender=Radio.getText().toString();
                    }
                }
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkbox.isChecked()) {
                    Toast.makeText(Relative.this, "User must accept terms and condiotions", Toast.LENGTH_LONG).show();
                }
                else if (Email.getText().toString().isEmpty()) {
                    Toast.makeText(Relative.this, "Enter Email", Toast.LENGTH_LONG).show();

                }
                else if (Password.getText().toString().isEmpty()) {
                    Toast.makeText(Relative.this, "Enter Password", Toast.LENGTH_LONG).show();

                }
                else if(checkbox.isChecked())
                {
                    Toast.makeText(Relative.this, Email.getText().toString() + " " + Password.getText().toString() + " " + gender, Toast.LENGTH_LONG).show();
                }

            }

        });
    }
}
