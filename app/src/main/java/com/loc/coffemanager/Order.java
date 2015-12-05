package com.loc.coffemanager;

import com.loc.coffemanager.Object.objectcoffee;

/**
 * Created by loc on 05/12/2015.
 */
public class Order {
    objectcoffee objectcoffee;
    int soluong;
    double tonggia;


    public Order() {


    }


    public Order(com.loc.coffemanager.Object.objectcoffee objectcoffee, int soluong, double tonggia) {
        this.objectcoffee = objectcoffee;
        this.soluong = soluong;
        this.tonggia = tonggia;
    }

    public com.loc.coffemanager.Object.objectcoffee getObjectcoffee() {
        return objectcoffee;
    }

    public void setObjectcoffee(com.loc.coffemanager.Object.objectcoffee objectcoffee) {
        this.objectcoffee = objectcoffee;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getTonggia() {
        return tonggia;
    }

    public void setTonggia(double tonggia) {
        this.tonggia = tonggia;
    }
}
