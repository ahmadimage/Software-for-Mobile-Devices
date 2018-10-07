package com.example.faizan.assignment1;

import com.j256.ormlite.field.DatabaseField;

public class Data {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
    public String email;

    @DatabaseField
    public String Password;


    public Data() {
    }


    public Data(int id, String email, String password) {
        this.id = id;
        this.email = email;
        Password = password;
    }
}
