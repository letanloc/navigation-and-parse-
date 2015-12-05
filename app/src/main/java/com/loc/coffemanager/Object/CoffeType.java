package com.loc.coffemanager.Object;

/**
 * Created by loc on 16/11/2015.
 */
public class CoffeType {
    private int CoffeeTypeId;
    private String Title;
    private  int Active;
    public  CoffeType(){

    }
    public CoffeType(int coffeeTypeId, String title) {
        CoffeeTypeId = coffeeTypeId;
        Title = title;
    }

    public int getCoffeeTypeId() {
        return CoffeeTypeId;
    }

    public void setCoffeeTypeId(int coffeeTypeId) {
        CoffeeTypeId = coffeeTypeId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
