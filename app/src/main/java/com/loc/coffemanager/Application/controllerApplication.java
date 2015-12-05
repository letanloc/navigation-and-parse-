package com.loc.coffemanager.Application;

import android.app.Application;
import android.content.Context;

import com.loc.coffemanager.Coffee.Coffelist;
import com.loc.coffemanager.Object.CoffeType;
import com.loc.coffemanager.Object.User;
import com.loc.coffemanager.Object.objectcoffee;
import com.loc.coffemanager.Order;
import com.parse.Parse;

import java.util.ArrayList;

/**
 * Created by loc on 15/11/2015.
 */
public class controllerApplication extends Application {

    public static int UserI;
    private static Context context;
    public static String APPLICATION_ID = "fRejnDxRS4hNmqjaHOo2iVp1dfCJMeV53t0eLvwG";
    public static String CLIENT_ID = "4z4R44nneXikhRLOuOzCNnNqaN7h8RwCTHGGgiJx";
    public static ArrayList<CoffeType> listCoffeType;
    public static ArrayList<objectcoffee> list;
    public static ArrayList<Order> listOder;
    public static objectcoffee itemcoffe;

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, APPLICATION_ID, CLIENT_ID);
        itemcoffe = new objectcoffee();
        listOder = new ArrayList<>();
        controllerApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return controllerApplication.context;
    }


}
