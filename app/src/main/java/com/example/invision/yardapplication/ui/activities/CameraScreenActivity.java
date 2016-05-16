package com.example.invision.yardapplication.ui.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.invision.yardapplication.R;

import java.util.ArrayList;

import adapters.cameraListAdapter;
import models.Interchange;

/**
 * Created by Junaid-Invision on 5/14/2016.
 */
public class CameraScreenActivity extends BaseActivity implements android.hardware.Camera.PictureCallback,SurfaceHolder.Callback {

    private android.hardware.Camera mCamera;
    private SurfaceView mCameraSurfaceView;
    private SurfaceHolder mCameraPreviewHolder;
    private ImageView CameraImageHolder;
    private ImageView imageCaptureButton;
    private Button doneButton;
    private RecyclerView interchangeImageCollection;
    private cameraListAdapter interchangeImageAdapter;
    private byte[] imageData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_screen);
        setUpComponents();
        setUPListeners();
    }

    @Override
    public void setUpComponents() {

        imageCaptureButton = (ImageView)findViewById(R.id.image_capture_button);
        //CameraImageHolder = (ImageView)findViewById(R.id.cameraImageHolder);
        mCameraSurfaceView = (SurfaceView) findViewById(R.id.camera_preview);
        mCameraPreviewHolder = mCameraSurfaceView.getHolder();
        mCameraPreviewHolder.addCallback(this);
        doneButton = (Button)findViewById(R.id.done_button);
        interchangeImageCollection = (RecyclerView)findViewById(R.id.interchange_list_collection);
        interchangeImageAdapter = new cameraListAdapter(this,new ArrayList<Interchange>());
        interchangeImageCollection.setAdapter(interchangeImageAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        manager.setStackFromEnd(true);
        interchangeImageCollection.setLayoutManager(manager);
        doneButton.setVisibility(View.INVISIBLE);





    }

    @Override
    public void setUPListeners() {

        imageCaptureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCamera.takePicture(null,null,CameraScreenActivity.this);
            }
        });


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCamera.startPreview();
//                CameraImageHolder.setVisibility(View.GONE);

                HomeScreenActivity.freshInterChanges = interchangeImageAdapter.getInterchangeList();
                CameraScreenActivity.this.finish();
               // doneButton.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        Log.d("Surface Changed Called", "Changed ");

        if (mCamera == null) {
            try {
                mCamera = android.hardware.Camera.open();
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
            } catch (Exception e) {

                Log.e("Exception Occured ", "unable to Open Camera ");
            }


        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onPictureTaken(byte[] data, android.hardware.Camera camera) {


        //mCamera.stopPreview();
        final byte[] cameraImageData = data;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(cameraImageData, 0, cameraImageData.length);
                // CameraImageHolder.setVisibility(View.VISIBLE);
                //CameraImageHolder.setImageBitmap(bitmap);
                imageData = cameraImageData;


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                doneButton.setVisibility(View.VISIBLE);
                Interchange interchange = new Interchange();
                interchange.setImage(imageData);
                interchangeImageAdapter.addItem(interchange);
            }
        }.execute();

        mCamera.startPreview();

    }

    @Override
    protected void onResume() {
        super.onResume();

//        if (mCamera == null)
//        {
//            try {
//                mCamera = android.hardware.Camera.open();
//                mCamera.setPreviewDisplay(mCameraSurfaceView.getHolder());
//                mCamera.startPreview();
//            } catch (Exception e)
//            {
//
//                Log.e("Exception Occured ","unable to Open Camera ");
//            }
//
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mCamera != null)
        {
            mCamera.release();
            mCamera = null;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setResult(RESULT_OK);
    }
}
