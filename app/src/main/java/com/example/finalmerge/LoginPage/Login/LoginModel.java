package com.example.finalmerge.LoginPage.Login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.finalmerge.homePage.homePage;
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

    }

    public void authenticateLogin() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    LoginDbRef = FirebaseDatabase.getInstance().getReference();
                    String uid = task.getResult().getUser().getUid();
                    LoginDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int userType = snapshot.getValue(Integer.class);
                            if(userType == 0) {
                                Toast.makeText(getApplicationContext(), "login Successful as Admin", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), homePage.class);
                                startActivity(intent);
                                finish();
                            }
                            else if(userType == 1) {
                                Toast.makeText(getApplicationContext(), "login Successful as Student", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), homePage.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Please Delete account something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(LoginView.this, "LoginView fail.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
