package com.example.finalmerge.LoginPage.Model;

public class UserInfo {

    String Uid;

    String email;

    String password;

    String userName;

    int userType;

    public UserInfo() {
    }

    public UserInfo(String uid, String email, String password, int userType) {
        Uid = uid;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
