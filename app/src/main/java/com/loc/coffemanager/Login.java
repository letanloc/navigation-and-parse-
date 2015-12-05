package com.loc.coffemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loc.coffemanager.Application.controllerApplication;
import com.loc.coffemanager.data.pref;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.edtUsername)
    MaterialEditText username;
    @Bind(R.id.edtPass)
    MaterialEditText password;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.viw)
    View viw;
    @Bind(R.id.txtDangki)
    TextView txtDangki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);
        btnLogin.setOnClickListener(this);
        txtDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,CreateNewUser.class));
            }
        });
//        GetObject();
//        DemoExample();
//        getDemoV3();
    }

    public void init() {


    }

    boolean boo = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String stusername = username.getText() + "";
                String StPassword = password.getText() + "";


                if (stusername.trim().equals("")) {
                    username.setError("Tên đăng nhập rổng");

                } else if (StPassword.trim().equals("")) {

                    password.setError("Mật khẩu rổng");

                } else {

                    progressBar.setVisibility(View.VISIBLE);
                    viw.setVisibility(View.INVISIBLE);
                    ParseUser.logInInBackground(stusername, StPassword, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if (user != null) {

                                Toast.makeText(Login.this, "Xin chào " + user.getString("username"), Toast.LENGTH_SHORT).show();

                                controllerApplication.UserI = user.getInt("UserId");
                                pref perf =new pref(Login.this);
                                perf.Login();
                                if (user.getInt("RoleId") == 0) {

                                } else if (user.getInt("RoleId") == 1) {


                                } else if (user.getInt("RoleId") == 2) {
                                    startActivity(new Intent(Login.this, MainActivity.class));

                                }
                                finish();


                            } else {
                                Toast.makeText(Login.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                            }

                            username.setText("");
                            password.setText("");
                            viw.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
                break;
            case R.id.txtDangki:

                break;
        }
    }


    public void getDemoV3() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("username", "letanloc");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.get(0).get("username") + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }

    public void GetObject() {
         /*ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
         query.fromLocalDatastore();
         query.getInBackground("4i6j1yWR2O", new GetCallback<ParseObject>() {
             public void done(ParseObject object, ParseException e) {
                 if (e == null) {
                     // object will be your game score
                     Log.e("sEssawaa",object.getString("username"));
                     Toast.makeText(Login.this, "Hellod", Toast.LENGTH_SHORT).show();
                 } else {
                     // something went wrong

                 }
             }
         });
*/

//        ParseObject object = ParseObject.createWithoutData("_User", "1");
//        object.fetchFromLocalDatastoreInBackground(new GetCallback<ParseObject>() {
//            public void done(ParseObject object, ParseException e) {
//                if (e == null) {
//                    Log.e("sEssawaa",object.getString("username"));
//                    Toast.makeText(Login.this, "Hellod", Toast.LENGTH_SHORT).show();
//                    // object will be your game score
//                } else {
//                    // something went wrong
//                }
//            }
//        });

    }

    private void DemoExample() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("owner", ParseUser.getCurrentUser());

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {

                    for (ParseObject Data : objects) {
                        Log.e("Datalist demo", Data.getString("username"));
                    }

                } else {
                    Log.e("Errorq1", e.toString());
                    Log.e("Infors", "eror");
                }
                Log.e("Infors", "Not  think");
            }
        });

    }
}
