package com.loc.coffemanager.Coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.loc.coffemanager.Adapter.Adapter_CoffeeType;
import com.loc.coffemanager.Application.controllerApplication;
import com.loc.coffemanager.Object.CoffeType;
import com.loc.coffemanager.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by loc on 15/11/2015.
 */
public class frament_coffetype extends Fragment {
    View v;
    @Bind(R.id.gridView)
    GridView grCoffeType;
    Adapter_CoffeeType adapter_coffeeType;
    @Bind(R.id.progressBar2)
    ProgressBar progressBar;
    public static int IdCoffeeType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frament_coffetype, container, false);
        ButterKnife.bind(this, v);
        progressBar.setVisibility(View.GONE);
        if (controllerApplication.listCoffeType == null) {
            LoadQuizType();

        } else {
            adapter_coffeeType = new Adapter_CoffeeType(getActivity(), controllerApplication.listCoffeType);
            grCoffeType.setAdapter(adapter_coffeeType);
        }
        grCoffeType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                frament_coffetype.IdCoffeeType = controllerApplication.listCoffeType.get(position).getCoffeeTypeId();
                Log.e("IdType", frament_coffetype.IdCoffeeType + "");
                startActivity(new Intent(getActivity(),Coffelist.class));

            }
        });
        return v;
    }

    public void LoadQuizType() {
        progressBar.setVisibility(View.VISIBLE);
        ParseQuery query = new ParseQuery("CoffeeType");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {

                    controllerApplication.listCoffeType = new ArrayList<CoffeType>();
                    for (ParseObject parseObject : objects) {
                        CoffeType c = new CoffeType();
                        c.setCoffeeTypeId(parseObject.getInt("CoffeeType_id"));
                        c.setTitle(parseObject.getString("Title"));
                        controllerApplication.listCoffeType.add(c);
                    }

                    adapter_coffeeType = new Adapter_CoffeeType(getActivity(), controllerApplication.listCoffeType);
                    grCoffeType.setAdapter(adapter_coffeeType);
                } else {
                    Log.e("Errorq1", e.toString());
                    Log.e("Infors", "eror");
                }
                //Log.e("Infors", "Not  think");
                progressBar.setVisibility(View.GONE);
            }


        });


    }
String Json = "{[]}";

}
