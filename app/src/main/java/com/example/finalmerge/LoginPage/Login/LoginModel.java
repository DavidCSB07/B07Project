package com.example.finalmerge.LoginPage.Login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LoginModel {
    FirebaseAuth mAuth;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
    }
}
