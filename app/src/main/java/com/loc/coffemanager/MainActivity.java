package com.loc.coffemanager;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.loc.coffemanager.Coffee.frament_coffetype;
import com.loc.coffemanager.data.pref;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.appbar)
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        per = new pref(this);
        ActionBar();
        InitNavigation();
    }

    public void ActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
//        if (!per.getIsLogin()) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_coffee_white_36dp);
            actionBar.setDisplayHomeAsUpEnabled(true);

//        }

    }

    pref per;

    public void InitNavigation() {

        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
//        if (!per.getIsLogin()) {
            navigationView.setVisibility(View.GONE);
            navigationView.setEnabled(false);

//
//        }


        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        //First fragment
        setFragment(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.edtLogin:
                startActivity(new Intent(MainActivity.this, Login.class));

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (per.getIsLogin()) {
            MenuItem edtLogin = (MenuItem) menu.findItem(R.id.edtLogin);
            edtLogin.setVisible(false);
        }


        return true;
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_inbox:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
//                            case R.id.item_navigation_drawer_starred:
//                                menuItem.setChecked(true);
//                                setFragment(1);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_sent_mail:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_drafts:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_settings:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//                                startActivity(intent);
//                                return true;
//                            case R.id.ite m_navigation_drawer_help_and_feedback:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
                        }
                        return true;
                    }
                });
    }


    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                frament_coffetype inboxFragment = new frament_coffetype();
                fragmentTransaction.replace(R.id.fragment, inboxFragment);
                fragmentTransaction.commit();
                break;
            case 1:
//                fragmentManager = getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                StarredFragment starredFragment = new StarredFragment();
//                fragmentTransaction.replace(R.id.fragment, starredFragment);
//                fragmentTransaction.commit();
                break;
        }
    }
}
