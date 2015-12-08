package com.loc.coffemanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.loc.coffemanager.Object.User;
import com.loc.coffemanager.Object.UserDetails;
import com.loc.coffemanager.Until.CircleTransform;
import com.loc.coffemanager.User.UserObject;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.picasso.Picasso;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.FutureTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.drakeet.materialdialog.MaterialDialog;

public class CreateNewUser extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.edtUsername)
    MaterialEditText edtUsername;
    @Bind(R.id.edtPassword)
    MaterialEditText edtPasswor;
    @Bind(R.id.edtRetypepassword)
    MaterialEditText edtRetypepassword;
    @Bind(R.id.edtFirstname)
    MaterialEditText edtFirstname;
    @Bind(R.id.edtLastname)
    MaterialEditText edtLastName;
    @Bind(R.id.edtEmail)
    MaterialEditText edtEmail;
    @Bind(R.id.edtPhone)
    MaterialEditText edtPhone;
    @Bind(R.id.raNam)
    RadioButton raNam;
    @Bind(R.id.raNu)
    RadioButton raNu;
    @Bind(R.id.btnDangKy)
    Button btnDangky;
    @Bind(R.id.spCyti)
    BetterSpinner betterSpinner;
    @Bind(R.id.edtAddress)
    MaterialEditText edtAddress;
    @Bind(R.id.imgUser)
    ImageView img;
    @Bind(R.id.progressBar3)
    ProgressBar progressBar;
    @Bind(R.id.layout)
    View layout;
    ;
    MaterialDialog mMaterialDialog;
    int myuserId = 1;
    public static int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
//        SetSpinner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Đăng ký");
        btnDangky.setOnClickListener(this);

        Picasso.with(this).load(R.drawable.coffeetype).placeholder(this.getResources().getDrawable(R.drawable.coffeetype)).transform(new CircleTransform()).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
    }


    public void getAvatar() {
//         ParseQuery<>//
        ParseQuery query = new ParseQuery("UserDetailts");
//         query.getInBackground()
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {


//                for (ParseObject object : objects) {
                    ParseFile fileObject = objects.get(0).getParseFile("Avatar");
                        if(fileObject!=null){
                            fileObject.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    Log.e("Sâsas",data.toString()+"");
                                    Bitmap bmp = BitmapFactory
                                            .decodeByteArray(
                                                    data, 0,
                                                    data.length);

                                    // Get the ImageView from
                                    // main.xml
//                            ImageView image = (ImageView) findViewById(R.id.image);

                                    // Set the Bitmap into the
//                             ImageView
                                    img.setImageBitmap(bmp);
//

                                }
                            });



                        }



//                            .get("ImageFile");
                }


//            }
        });


    }




//    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                Picasso.with(this).load(uri).transform(new CircleTransform()).into(img);

//                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SetSpinner() {
        String stSp[] = {
                "Hồ Chí Minh"
        };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stSp);
        betterSpinner.setAdapter(arrayAdapter);
    }

    public void ParseUpdate() {
        final String stUsername = edtUsername.getText() + "";
        final String stPassword = edtPasswor.getText() + "";
        String stRetypePassword = edtRetypepassword.getText() + "";
        final String stFirstname = edtFirstname.getText() + "";
        final String stLastname = edtLastName.getText() + "";
        final String stEmail = edtEmail.getText() + "";
        final String stAdderess = edtAddress.getText() + "";
        final String stPhone = edtPhone.getText() + "";

//
        if (TextUtils.isEmpty(stUsername)) {
            edtUsername.setError("Tên đăng nhập rồng");
        } else if (TextUtils.isEmpty(stPassword)) {
//            stPassword.trim().equals("")
            edtPasswor.setError("mật khẩu rổng");
        } else if (TextUtils.isEmpty(stRetypePassword)) {
            edtRetypepassword.setError("Chưa nhập lại mật khẩu");
        } else if (stFirstname.trim().equals("")) {
            edtFirstname.setError("Tên của bạn rổng");
        } else if (stLastname.trim().equals("")) {
            edtLastName.setError("họ của bạn rổng");
        } else if (stEmail.trim().equals("")) {
            edtEmail.setError("Email Của bạn rổng");
        } else if (stAdderess.trim().equals("")) {
            edtAddress.setError("Địa chỉ của bạn rổng");
        } else if (stPhone.trim().equals("")) {
            edtPhone.setError("Bạn chưa nhập số điện thoại");
        } else {
            if (stUsername.length() < 5) {
                edtUsername.setError("Tên đăng  nhập quá ngắn");
            } else if (stPassword.length() < 4) {
                edtPasswor.setError("Mật khẩu quá ngắn");
            } else if (!stPassword.trim().equals(stRetypePassword)) {
                edtRetypepassword.setError("Mật khẩu không trùng khớp");
            } else if (TextUtils.isEmpty(stEmail) && android.util.Patterns.EMAIL_ADDRESS.matcher(stEmail).matches()) {
                edtEmail.setError("Email của bạn không chính xác");
            } else if (stAdderess.length() < 7) {
                edtAddress.setError("Địa chỉ không chỉnh xác");
            } else if ((stPhone.length() < 10) || (stPhone.length() > 11)) {
                edtPhone.setError("Số điện thoại không chính xác");
            } else {

                // thuwhc hien lock out

                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                final User user = new User();
                final UserDetails m = new UserDetails();
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
                ParseQuery query = new ParseQuery("_User");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        progressBar.setVisibility(View.VISIBLE);
                        layout.setVisibility(View.INVISIBLE);
//
                        if (e == null) {
                            Log.e("SSSS", "gssasaas");
                            myuserId = objects.size() + 1;

                            user.setUserId(myuserId);
                            user.setPassword(stPassword);
                            user.setUsername(stUsername);
                            user.setRoleId(2);
//                        /*================*/
                            m.setAddress(stAdderess);
                            m.setPhone(stPhone);
                            m.setFirstName(stFirstname);
                            m.setLastname(stLastname);
                            m.setUserId(myuserId);
                            m.setCity(betterSpinner.getText().toString());
                            m.setEmail(stEmail);
                            int gender = (raNam.isChecked() ? 1 : 0);
                            m.setGender(gender);

                            Bitmap imgeBitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imgeBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            byte[] image = stream.toByteArray();
                            m.setAvatar(image);

                            ParseUser puser = new ParseUser();
                            puser.setUsername(user.getUsername());
                            puser.setPassword(user.getPassword());
                            puser.put("RoleId", 2);
                            puser.put("UserId", myuserId);
                            puser.signUpInBackground(new SignUpCallback() {
                                public void done(ParseException e) {
                                    if (e == null) {

                                        ParseObject UserDetails = new ParseObject("UserDetailts");
                                        UserDetails.put("Address", m.getAddress());
                                        UserDetails.put("Email", m.getEmail());
                                        UserDetails.put("FirstName", m.getFirstName());
                                        UserDetails.put("LastName", m.getLastname());
                                        UserDetails.put("Phone", m.getPhone());
                                        UserDetails.put("userId", m.getUserId());
                                        UserDetails.put("City", m.getCity());
                                        UserDetails.put("Gender", m.getGender());
                                        ParseFile file = new ParseFile(m.getFirstName() + "_" + m.getLastname() + "_" + m.getUserId() + ".png", m.getAvatar());
                                        file.saveInBackground();
                                        UserDetails.put("Avatar", file);
                                        UserDetails.saveInBackground(new SaveCallback() {
                                            //                                Log.e("ssasa","sss");
                                            @Override
                                            public void done(ParseException e) {
                                                if (e == null) {

                                                    Log.e("ssasa", "sss");
                                                } else {
                                                    Log.e("ssasa", e.toString());

                                                }
                                            }
                                        });

                                    } else {


                                        if ((e.toString()).trim().contains("already taken")) {
                                            Toast.makeText(CreateNewUser.this, "Tên đang nhập đã tồn tại", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                }

                            });
                        } else {

                            Log.e("SSSS", e.toString());
                        }
                        edtPasswor.setText("");
                        edtUsername.setText("");
                        edtPhone.setText("");
                        edtAddress.setText("");
                        edtLastName.setText("");
                        edtFirstname.setText("");
                        edtEmail.setText("");
                        edtRetypepassword.setText("");
                        startActivity(new Intent(CreateNewUser.this, MainActivity.class));
                        finish();
                        progressBar.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDangKy:
//                ParseUpdate();
//                Demo();
                ParseUpdate();
                break;

        }

    }


    public void InsetUser(final User m, final UserDetails details) {

// other fields can be set just like with ParseObject
//        user.put("phone", "650-253-0000");

//        user.signUpInBackground(new SignUpCallback() {
//            public void done(ParseException e) {
////                if (e == null) {
////
////                    ParseObject gameScore = new ParseObject("UserDetailts");
////                    gameScore.put("Address", details.getAddress());
////                    gameScore.put("Email", details.getEmail());
////                    gameScore.put("FirstName", details.getFirstName());
////                    gameScore.put("LastName", details.getLastname());
////                    gameScore.put("Phone", details.getPhone());
////                    gameScore.put("userId", details.getUserId());
////                    gameScore.put("City", details.getCity());
////                    gameScore.put("Gender", details.getGender());
////                    ParseFile file = new ParseFile(details.getFirstName() + "_" + details.getLastname() + "_" + details.getUserId() + ".png", details.getAvatar());
////                    file.saveInBackground();
////                    gameScore.put("Avatar", file);
////                    gameScore.saveInBackground(new SaveCallback() {
////                        @Override
////                        public void done(ParseException e) {
////
////                            if (e == null) {
////                                Toast.makeText(CreateNewUser.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
////
////                            } else {
////                                Toast.makeText(CreateNewUser.this, "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
////
////                            }
////
////                        }
////                    });
////
////                } else {
////                    // Sign up didn't succeed. Look at the ParseException
////                    // to figure out what went wrong
////                }
//            }
//        });

//        currentUser.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                currentUser.setUsername("ssssss");
//                currentUser.setPassword(m.getPassword());
//                currentUser.put("RoleId", m.getRoleId());
//                currentUser.put("UserId",m.getUserId());
//            }
//        });
//username

////        currentUser.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    UserDetails ms = details;
////
////                    ParseObject gameScore = new ParseObject("UserDetailts");
////                    gameScore.put("Address", ms.getAddress());
////                    gameScore.put("Email", ms.getEmail());
////                    gameScore.put("FirstName", ms.getFirstName());
////                    gameScore.put("LastName", ms.getLastname());
////                    gameScore.put("Phone", ms.getPhone());
////                    gameScore.put("userId", ms.getUserId());
////                    gameScore.put("City", ms.getCity());
////                    gameScore.put("Gender", ms.getGender());
////                    ParseFile file = new ParseFile(ms.getFirstName() + "_" + ms.getLastname() + "_" + ms.getUserId() + ".png", ms.getAvatar());
////                    file.saveInBackground();
////                    gameScore.put("Avatar", file);
////                    gameScore.saveInBackground(new SaveCallback() {
////                        @Override
////                        public void done(ParseException e) {
////
////                            if (e == null) {
////                                Toast.makeText(CreateNewUser.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
////
////                            } else {
////                                Toast.makeText(CreateNewUser.this, "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
////
////                            }
////
////                        }
////                    });
//
//
//                }else {
//
//                    Log.e("SSAS",e.toString());
//                }
//            }
//        });


    }

    public void Demo() {

        ParseUser user = new ParseUser();
        user.setUsername("myname");
        user.setPassword("my pass");
        user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
        user.put("phone", "650-253-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
}
