package com.loc.coffemanager.Adapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loc.coffemanager.Object.objectcoffee;
import com.loc.coffemanager.R;

import java.util.ArrayList;

/**
 * Created by loc on 16/11/2015.
 */
public class CoffeListAdapter extends RecyclerView.Adapter<CoffeListAdapter.ViewHolder> {
    ArrayList<objectcoffee> list;
    Activity activity;

    public CoffeListAdapter(ArrayList<objectcoffee> list) {
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coffeelist, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int position) {
        h.txtTitle.setText(list.get(position).getTitle());
        h.txtPrice.setText(list.get(position).getPrice() + "đ");
        if (list.get(position).getContent().length() >= 28) {
            h.txtContent.setText(list.get(position).getContent().substring(0, 21) + "[........]");
        } else {
            h.txtContent.setText(list.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder  {
//        public IMyViewHolderClicks mListener;
        TextView txtTitle, txtContent, txtPrice;
        ImageView ImgItem, imgContent;

        private ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) v.findViewById(R.id.txtTitle);
            txtContent = (TextView) v.findViewById(R.id.txtContent);
            txtPrice = (TextView) v.findViewById(R.id.txtPrice);
        }

    }

}
