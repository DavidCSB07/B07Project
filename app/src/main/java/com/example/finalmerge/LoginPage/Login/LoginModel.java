package com.example.finalmerge.LoginPage.Login;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginModel implements LoginModelInterface{
    private FirebaseAuth mAuth;
    private DatabaseReference loginDBRef;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
        loginDBRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void signIn(String email, String password, OnCompleteListener<AuthResult> onCompleteListener) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(onCompleteListener);
    }

    @Override
    public void getUserType(String uid, OnSuccessListener<Integer> onSuccessListener, OnFailureListener OnFailureListener) {
        loginDBRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot){
                Integer userType = snapshot.getValue(Integer.class);
                onSuccessListener.onSuccess(userType);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){
                onFailureListener.onFailure(error.toException());
            }
        });
    }
}
