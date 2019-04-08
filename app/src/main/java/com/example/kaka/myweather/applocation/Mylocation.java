package com.example.kaka.myweather.applocation;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class Mylocation extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        OkGo.getInstance().init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
    public static Context getContext(){
        return mContext;
    }
}
