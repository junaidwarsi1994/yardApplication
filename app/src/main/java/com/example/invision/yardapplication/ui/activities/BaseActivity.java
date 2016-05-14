package com.example.invision.yardapplication.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Junaid-Invision on 5/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {


    public abstract void setUpComponents ();
    public abstract void setUPListeners ();


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setUpComponents();
        setUPListeners();
    }
}
