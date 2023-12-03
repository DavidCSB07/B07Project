package com.example.finalmerge.LoginPage.Login;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginModel {
    private FirebaseAuth mAuth;
    private DatabaseReference LoginDbRef;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
        LoginDbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void signInWithEmailAndPassword(String email, String password, final LoginPresenter presenter) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String uid = task.getResult().getUser().getUid();
                        LoginDbRef.child("RegisterInfo").child(uid).child("userType")
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int userType = snapshot.getValue(Integer.class);
                                        presenter.onSignInSuccess(userType);
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        presenter.onSignInFailure("Database error");
                                    }
                                });
                    } else {
                        presenter.onSignInFailure("Login failed");
                    }
                });
    }

}
