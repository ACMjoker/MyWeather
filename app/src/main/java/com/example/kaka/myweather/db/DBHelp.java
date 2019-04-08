package com.example.kaka.myweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.bean.ProvinceBean;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBHelp extends OrmLiteSqliteOpenHelper {
    private static DBHelp dbHelp = null;
    public static DBHelp getInstance(Context context){
        if(dbHelp == null){
            dbHelp = new DBHelp(context);
        }
        return dbHelp;
    }
    private DBHelp(Context context) {
        super(context, "weather.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,ProvinceBean.class);
            TableUtils.createTable(connectionSource, CityBean.class);
            TableUtils.createTable(connectionSource, DistrictBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,ProvinceBean.class,true);
            TableUtils.createTable(connectionSource,ProvinceBean.class);
            TableUtils.dropTable(connectionSource,CityBean.class,true);
            TableUtils.createTable(connectionSource,CityBean.class);
            TableUtils.dropTable(connectionSource,DistrictBean.class,true);
            TableUtils.createTable(connectionSource,DistrictBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
