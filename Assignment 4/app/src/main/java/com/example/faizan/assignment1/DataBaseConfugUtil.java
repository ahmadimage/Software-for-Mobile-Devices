package com.example.faizan.assignment1;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DataBaseConfugUtil extends OrmLiteConfigUtil {


    public static void main(String[] args) throws IOException, SQLException {

        // Provide the name of .txt file which you have already created and kept in res/raw directory
        writeConfigFile("ormlite_config.txt");
    }



}
