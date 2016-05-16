package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.invision.yardapplication.R;

import java.util.ArrayList;
import java.util.List;

import models.Interchange;
import viewHolders.ImageViewHolder;

/**
 * Created by Junaid-Invision on 5/16/2016.
 */
public class HomeListAdapter extends RecyclerView.Adapter<ImageViewHolder> {


    private Context context;
    List<Interchange> interchangeList;

    public HomeListAdapter (Context c)
    {
        context = c ;
        interchangeList = new ArrayList<Interchange>();

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.home_picture_item,null,false);
        ImageViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        Interchange interchange  = interchangeList.get(position);
        holder.setImage(interchange.getImage());

    }

    @Override
    public int getItemCount() {
        return interchangeList.size();
    }


    public void addItem (Interchange interchange)
    {
        interchangeList.add(interchange);
        notifyDataSetChanged();
    }
}
