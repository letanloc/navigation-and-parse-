package com.loc.coffemanager.Object;

/**
 * Created by loc on 16/11/2015.
 */
public class objectcoffee {
    private int id;
    private String Title;
    private String Image;
    private int CoffeeType_Id;  
    private String DateTime;
    private String Content;
    private double Price;

    public objectcoffee() {
    }


    public objectcoffee(int id, String title, String image, int coffeeType_Id, String dateTime, String content, double price) {
        this.id = id;
        Title = title;
        Image = image;
        CoffeeType_Id = coffeeType_Id;
        DateTime = dateTime;
        Content = content;
        Price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getCoffeeType_Id() {
        return CoffeeType_Id;
    }

    public void setCoffeeType_Id(int coffeeType_Id) {
        CoffeeType_Id = coffeeType_Id;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
