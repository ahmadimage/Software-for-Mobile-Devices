package com.example.faizan.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHandler extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME="crud";
    private static final int DATABASE_VERSION=1;

    private Dao<Data,Integer> DataDao=null;
    private RuntimeExceptionDao<Data,Integer> DataRunTimeDao=null;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource,Data.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource,Data.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Data,Integer> getDao() throws SQLException {
        if(DataDao==null)
        {
            DataDao=getDao(Data.class);
        }
        return DataDao;

    }

    public RuntimeExceptionDao<Data,Integer>getDataRuntimeExceceptionDao()
    {
        if(DataRunTimeDao==null)
        {
            DataRunTimeDao=getRuntimeExceptionDao(Data.class);
        }
        return DataRunTimeDao;

    }


}
