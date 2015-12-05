package com.loc.coffemanager.Coffee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by loc on 23/11/2015.
 */
public class Fra extends Fragment  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ParseObject parseObject =new ParseObject("");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
