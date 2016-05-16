package com.example.invision.yardapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.invision.yardapplication.R;

import java.util.List;

import adapters.HomeListAdapter;
import models.Interchange;

/**
 * Created by Junaid-Invision on 5/14/2016.
 */
public class HomeScreenActivity extends BaseActivity {

    private ImageView trailerButton;
    private ImageView tireButton;
    private ImageView truckButton;
    private RecyclerView trailerList;
    private RecyclerView tiresList;
    private RecyclerView truckList;
    public  static List<Interchange> freshInterChanges;
    private boolean trailer = false;
    private boolean truck = false;
    private boolean tires = false;
    private HomeListAdapter tireListAdapter;
    private HomeListAdapter truckListAdapter;
    private HomeListAdapter trailerListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_layout);
        setUpComponents();
        setUPListeners();
    }

    @Override
    public void setUpComponents() {

        trailerButton = (ImageView)findViewById(R.id.trailer_camera_button);
        tireButton = (ImageView)findViewById(R.id.tire_camera_button);
        truckButton = (ImageView)findViewById(R.id.truck_camera_button);
        trailerList = (RecyclerView)findViewById(R.id.trailer_image_list);
        tiresList = (RecyclerView)findViewById(R.id.tires_picture_list);
        truckList = (RecyclerView) findViewById(R.id.truck_picture_list);
        trailerListAdapter = new HomeListAdapter(this);
        truckListAdapter = new HomeListAdapter(this);
        tireListAdapter = new HomeListAdapter(this);


        LinearLayoutManager trailermanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager truckmanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager tiresmanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        trailerList.setLayoutManager(trailermanager);
        truckList.setLayoutManager(truckmanager);
        tiresList.setLayoutManager(tiresmanager);

        trailerList.setAdapter(trailerListAdapter);
        truckList.setAdapter(truckListAdapter);
        tiresList.setAdapter(tireListAdapter);



    }

    @Override
    public void setUPListeners() {
        trailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               trailer = true;
                launchActivity("dummy");



            }
        });

        tireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity("dummy");
                tires = true;


            }
        });

        truckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity("dummy");
                truck = true;
            }
        });

    }


    public void launchActivity (String part){
        Intent cameraActivityIntent = new Intent(this,CameraScreenActivity.class);
        startActivityForResult(cameraActivityIntent,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(trailer == true)
        {
            updateData (trailerListAdapter);
            trailer = false;
        }
        else if (truck == true)
        {
            updateData(truckListAdapter);
            truck = false;
        }
        else if (tires == true)
        {
            updateData (tireListAdapter);
            tires = false;
        }



        Log.d("Result Fetched", "fetched");

    }

    public void updateData (HomeListAdapter adapter)
    {
        if (freshInterChanges != null)
        {
            for (Interchange interchange : freshInterChanges)
            {
                adapter.addItem(interchange);
            }
            freshInterChanges = null;
        }
    }
}
