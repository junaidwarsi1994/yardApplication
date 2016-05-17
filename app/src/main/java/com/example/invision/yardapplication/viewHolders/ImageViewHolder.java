package com.example.invision.yardapplication.viewHolders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.invision.yardapplication.R;

import com.example.invision.yardapplication.util.Utils;

/**
 * Created by Junaid-Invision on 5/16/2016.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {


    public ImageView displayImage;
    private byte[] imageData;
    private Bitmap image;
    public ImageViewHolder(View itemView) {
        super(itemView);
        displayImage = (ImageView)itemView.findViewById(R.id.image_list_item);
        displayImage.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    public void setImage(byte[]  data)
    {
        imageData = data;
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                image  = BitmapFactory.decodeByteArray(imageData,0,imageData.length);
                // Bitmap ScaledBitmap = Bitmap.createBitmap(bitmap,0,0,displayImage.getWidth(),displayImage.getHeight());


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                displayImage.setImageBitmap(Utils.scaleBitmap(image,displayImage.getWidth(),displayImage.getHeight()));


            }
        }.execute();

    }

}
