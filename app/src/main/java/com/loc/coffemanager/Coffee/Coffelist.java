package com.loc.coffemanager.Coffee;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;

import com.loc.coffemanager.Adapter.CoffeListAdapter;
import com.loc.coffemanager.Adapter.reclickimplements;
import com.loc.coffemanager.Application.controllerApplication;
import com.loc.coffemanager.MainActivity;
import com.loc.coffemanager.Object.objectcoffee;
import com.loc.coffemanager.R;
import com.loc.coffemanager.Until.HidingScrollListener;
import com.loc.coffemanager.Until.Recy.MyScrollListener;
import com.loc.coffemanager.changeprodus;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Coffelist extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar aToolbar;
    CoffeListAdapter recyclerAdapter;
    ArrayList<objectcoffee> list;

    //    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffelist);
        ButterKnife.bind(this);
        initToolbar();
        initRecyclerView();
        initListCoffee(frament_coffetype.IdCoffeeType + "");

//        recyclerAdapter = new CoffeListAdapter(list);
//        recyclerView.setAdapter(recyclerAdapter);
//        recyclerView.setOnScrollListener(new HidingScrollListener() {
//            @Override
//            public void onHide() {
//                hideViews();
//            }
//
//            @Override
//            public void onShow() {
//                showViews();
//            }
//        });

        recyclerAdapter = new CoffeListAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.setOnScrollListener(new MyScrollListener(this) {
            @Override
            public void onMoved(int distance) {
                aToolbar.setTranslationY(-distance);
            }
        });

        recyclerView.addOnItemTouchListener(new reclickimplements(Coffelist.this, new reclickimplements.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                controllerApplication.itemcoffe = list.get(position);
                startActivity(new Intent(Coffelist.this, changeprodus.class));


            }
        }));
    }

    private void initToolbar() {
        setSupportActionBar(aToolbar);
        setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        aToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void hideViews() {
        aToolbar.animate().translationY(-aToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

    }

    private void showViews() {
        aToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    public void initListCoffee(String CoffeId) {
        list = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Coffee");
        query.whereEqualTo("CoffeeTypeId", 1);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    try {
                        Log.e("SETERRREE", scoreList.size() + "  " + scoreList.get(0).getString("Coffee_Title"));
                        for (int i = 0; i < scoreList.size(); i++) {
                            ParseObject p = scoreList.get(i);
                            objectcoffee objectcoffee = new objectcoffee();
                            objectcoffee.setTitle(p.getString("Coffee_Title"));
                            objectcoffee.setCoffeeType_Id(p.getInt("CoffeeTypeId"));
                            objectcoffee.setPrice(p.getDouble("Coffee_Price"));
                            objectcoffee.setContent(p.getString("content"));
                            objectcoffee.setId(p.getInt("Coffee_Id"));
                            objectcoffee.setImage(p.getString("Avatar"));
                            Log.e("SETERRREE", scoreList.size() + "  " + scoreList.get(i).getString("Coffee_Title"));
                            list.add(objectcoffee);
                        }
                        recyclerAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(recyclerAdapter);
                    } catch (Exception ez) {
                        Log.e("Exetxtxt", ez.toString());

                    }
                    Log.e("SSSSSSSSSS", list.size() + "");


                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                .openDrawer(GravityCompat.START);
                startActivity(new Intent(Coffelist.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.coffeelist, menu);
        return true;
    }
}
