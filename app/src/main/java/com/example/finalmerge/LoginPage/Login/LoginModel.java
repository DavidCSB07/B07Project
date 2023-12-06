package com.example.finalmerge.LoginPage.Login;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginModel {
    FirebaseAuth mAuth;
    DatabaseReference LoginDbRef;

    public LoginModel() {
        mAuth = FirebaseAuth.getInstance();
        LoginDbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void signInWithEmailAndPassword(String email, String password, LoginPresenter presenter) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                presenter.hideProgressBar();
                if (task.isSuccessful()) {
                    String uid = task.getResult().getUser().getUid();
                    LoginDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int userType = snapshot.getValue(Integer.class);
                            presenter.onLoginSuccess(userType);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                else {
                    presenter.onLoginError("Email or password is incorrect");
                }
            }
        });
    }
}
