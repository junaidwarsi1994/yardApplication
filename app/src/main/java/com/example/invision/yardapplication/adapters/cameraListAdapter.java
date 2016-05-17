package com.example.invision.yardapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.invision.yardapplication.R;

import java.util.List;

import com.example.invision.yardapplication.models.TruckInterchange;
import com.example.invision.yardapplication.viewHolders.ImageViewHolder;

/**
 * Created by Junaid-Invision on 5/16/2016.
 */
public class cameraListAdapter extends RecyclerView.Adapter<ImageViewHolder>{

    Context context;
    List<TruckInterchange> interchangeList;

    public cameraListAdapter (Context c , List<TruckInterchange> data)
    {
        context = c ;
        interchangeList= data;
    }



    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.picture_item,null,false);
        ImageViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        TruckInterchange interchange = interchangeList.get(position);
        holder.setImage (interchange.getImage());

    }

    @Override
    public int getItemCount() {
        return interchangeList.size();
    }

    public void addItem (TruckInterchange interchange)
    {
        interchangeList.add(interchange);
        notifyDataSetChanged();
    }


    public List<TruckInterchange> getInterchangeList() {
        return interchangeList;
    }
}
