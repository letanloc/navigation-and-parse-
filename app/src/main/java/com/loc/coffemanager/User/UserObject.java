package com.loc.coffemanager.User;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.loc.coffemanager.Object.UserDetails;
import com.loc.coffemanager.R;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by loc on 15/11/2015.
 */
public class UserObject {
    static Context context;
    UserDetails userDetails;

    public UserObject(Context context) {
        this.context = context;
        userDetails = new UserDetails();
    }

    public void UserInforbyUserId(int Id) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("UserDetailts");
        query.whereEqualTo("userId", Id + "");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    userDetails.setUserId(list.get(0).getInt("userId"));
                    userDetails.setPhone(list.get(0).getString("Phone"));
                    userDetails.setLastname(list.get(0).getString("LastName"));
                    userDetails.setFirstName(list.get(0).getString("FirstName"));
                    userDetails.setEmail(list.get(0).getString("Email"));
                    userDetails.setCity(list.get(0).getString("City"));
                    // userDetails.setAvatar(list.get(0).getString("Avatar"));


                    userDetails.setAddress(list.get(0).getString("Address"));
                } else {
                    Log.e("Erro_getIfor", e.toString());

                }
            }
        });

    }

    public static void InserNewUserDetails(UserDetails m) {
        ParseObject gameScore = new ParseObject("UserDetailts");
        gameScore.put("Address", m.getAddress());
        gameScore.put("Email", m.getEmail());
        gameScore.put("FirstName", m.getFirstName());
        gameScore.put("LastName", m.getLastname());
        gameScore.put("Phone", m.getPhone());
        gameScore.put("userId", m.getUserId());

        ParseFile file = new ParseFile(m.getFirstName() + "_" + m.getLastname() + "_" + m.getUserId() + ".png", m.getAvatar());
        file.saveInBackground();

        List<ParseObject> lis = new ArrayList<>();
        ParseObject parsetParseObject = null;
        ParseObject imgupload = new ParseObject("UserDetailts");
        imgupload.put("Avatar", file);
        imgupload.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

                if (e == null) {
                    Toast.makeText(context, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

                }

            }
        });


//        imgupload.saveInBackground(parsetParseObject,new SaveCallback(){
//
//
//            @Override
//            public void done(ParseException e) {
//
//            }
//        });
//        gameScore.saveEventually();


    }


    public void UpdateImage(ImageView imageView) {
//         Drawable b = (Drawable) imageView.getDrawable();
//         Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),imageView.getDrawable());

         /*--*/


/// tạo một class

    }

}
