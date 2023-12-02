package com.example.finalmerge.LoginPage.Login;

import com.google.firebase.auth.FirebaseAuth;

public class LoginModel {
    FirebaseAuth mAuth;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
    }
}
