package com.loc.coffemanager.data;

import android.app.Activity;
import android.content.SharedPreferences;

import com.loc.coffemanager.MainActivity;

/**
 * Created by loc on 05/12/2015.
 */
public class pref {
    SharedPreferences pref;


    public pref(Activity activity) {
        pref = activity.getSharedPreferences("data", 0);
    }

    SharedPreferences.Editor editor;

    String Ilogin = "login";

    public void Login() {
        editor =pref.edit();
        editor.putBoolean(Ilogin, true);
        editor.commit();

    }


    public void UserLogin() {
        editor.clear();
        editor.commit();

    }

    public boolean getIsLogin() {

        return pref.getBoolean(Ilogin, false);
    }

    public void UserProfile() {


    }


}
