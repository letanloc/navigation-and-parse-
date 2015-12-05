package com.loc.coffemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loc.coffemanager.Application.controllerApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

public class changeprodus extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.title)
    TextView txtTitle;
    @Bind(R.id.txtPrice)
    TextView txtPrice;
    @Bind(R.id.tru)
    Button btntru;
    @Bind(R.id.cong)
    Button cong;
    @Bind(R.id.textView2)
    TextView soluong;
    int tong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeprodus);
        ButterKnife.bind(this);
        btntru.setOnClickListener(this);
        cong.setOnClickListener(this);
        txtTitle.setText(controllerApplication.itemcoffe.getTitle());
        txtPrice.setText(controllerApplication.itemcoffe.getPrice() + "");
        Button listOder = (Button) findViewById(R.id.button3);
        listOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order();
                order.setObjectcoffee(controllerApplication.itemcoffe);
                order.setSoluong(Integer.valueOf(soluong.getText() + ""));
//                        order.setObjectcoffee(D);
                startActivity(new Intent(changeprodus.this, Cart.class));
            }
        });
    }


    @Override
    public void onClick(View v) {
        int a = (Integer.valueOf((soluong.getText() + "")));
        switch (v.getId()) {

            case R.id.tru:

                if (a > 1) {
                    a--;
                    soluong.setText((a) + "");
                }
                break;
            case R.id.cong:

                if (a <= 50) {
                    a++;
                    soluong.setText((a) + "");
                }
                break;

        }
    }
}
