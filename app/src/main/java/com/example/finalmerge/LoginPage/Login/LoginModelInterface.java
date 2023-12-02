package com.example.finalmerge.LoginPage.Login;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

public interface LoginModelInterface{
    void signIn(String email, String password, OnCompleteListener<AuthResult> onCompleteListener);
    void getUserType(String uid, OnSuccessListener<Integer> onSuccessListener, OnFailureListener OnFailureListener);
}
