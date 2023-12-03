package com.example.finalmerge.LoginPage.AdminRegister;

import androidx.annotation.NonNull;

import com.example.finalmerge.LoginPage.Model.UserInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminRegisterModel {

    private final FirebaseAuth mAuth;
    private final DatabaseReference registerDbRef;

    public AdminRegisterModel() {
        mAuth = FirebaseAuth.getInstance();
        registerDbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void createUserWithEmailAndPassword(String email, String password, AdminRegisterPresenter presenter){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        presenter.hideProgressBar();
                        presenter.registerUser(email, password, task);
                    }
                });
    }

    public void writeToDB(String email, String password,@NonNull Task<AuthResult> task) {
        String uid = task.getResult().getUser().getUid();
        UserInfo userinfo = new UserInfo(uid, email, password, 1);

        registerDbRef.child("RegisterInfo").child(uid).setValue(userinfo);
    }
}
