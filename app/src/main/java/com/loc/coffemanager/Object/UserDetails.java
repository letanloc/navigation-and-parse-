package com.loc.coffemanager.Object;

/**
 * Created by loc on 15/11/2015.
 */
public class UserDetails {
    private String FirstName;
    private String Lastname;
    private byte[] Avatar;
    private String Email;
    private String Phone;
    private int userId;
    private String Address;
    private String City;
    private  int Gender;
    public UserDetails() {

    }

    public UserDetails(String firstName, String lastname, byte[] avatar, String email, String phone, int userId, String address, String city, int gender) {
        FirstName = firstName;
        Lastname = lastname;
        Avatar = avatar;
        Email = email;
        Phone = phone;
        this.userId = userId;
        Address = address;
        City = city;
        Gender = gender;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public byte[] getAvatar() {
        return Avatar;
    }

    public void setAvatar(byte[] avatar) {
        Avatar = avatar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }
}
