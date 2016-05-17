package com.example.invision.yardapplication;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by Junaid-Invision on 5/17/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }
}
