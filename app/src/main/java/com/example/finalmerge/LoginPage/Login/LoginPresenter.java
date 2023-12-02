package com.example.finalmerge.LoginPage.Login;

import android.text.TextUtils;

public class LoginPresenter {
    LoginView view;
    LoginModel model;

    public LoginPresenter(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    public void validateCredentials(String email, String password){
        model.authenticateLogin(email, password);

    }

    private void Login(String email, String password){

    }

    public void setViewText(String email, String password){
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            view.setOutputText("Fields cannot be empty.");
        }
    }




}
