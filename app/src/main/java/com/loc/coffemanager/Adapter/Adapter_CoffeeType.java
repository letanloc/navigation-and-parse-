package com.loc.coffemanager.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loc.coffemanager.Object.CoffeType;
import com.loc.coffemanager.*;
import com.loc.coffemanager.Until.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by loc on 16/11/2015.
 */
public class Adapter_CoffeeType extends BaseAdapter {
    ArrayList<CoffeType> list;
    Activity context;
    ViewHole viewHole;
    public Adapter_CoffeeType(Activity context, ArrayList<CoffeType> list) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View v;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = LayoutInflater.from(context).inflate(R.layout.item_coffeetype, parent, false);
        viewHole = new ViewHole();
        viewHole.img = (ImageView) v.findViewById(R.id.imageView);
        viewHole.txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        Picasso.with(context).load(R.drawable.coffeetype).placeholder(context.getResources().getDrawable(R.drawable.coffeetype)).transform(new CircleTransform()).into(viewHole.img);
        viewHole.txtTitle.setText(list.get(position).getTitle());
        return v;
    }

    class ViewHole {
        ImageView img;
        TextView txtTitle;


    }
}
