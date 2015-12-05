package com.loc.coffemanager.Object;

/**
 * Created by loc on 15/11/2015.
 */
public class User {

    private int UserId;
    private String Username;
    private int RoleId;
    private String Password;


    public  User() {


    }

    public User(int userId, String username, int roleId, String password) {
        UserId = userId;
        Username = username;
        RoleId = roleId;
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
