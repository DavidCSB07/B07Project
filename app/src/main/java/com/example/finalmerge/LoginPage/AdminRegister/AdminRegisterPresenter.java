package com.example.finalmerge.LoginPage.AdminRegister;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class AdminRegisterPresenter {
    AdminRegisterModel model;
    AdminRegisterView view;

    public AdminRegisterPresenter(AdminRegisterModel model, AdminRegisterView view) {
        this.model = model;
        this.view = view;
    }

    public void onRegisterClick(){
        String email=view.getEmail();
        String password=view.getPassword();
        view.displayProgressBar();

        if (TextUtils.isEmpty(email)) {
            view.hideProgressBar();
            view.displayStatusMessage("Email cannot be empty");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            view.hideProgressBar();
            view.displayStatusMessage("Password cannot be empty");
            return;
        }
        model.createUserWithEmailAndPassword(email, password, this);
    }

    public void onLoginNowClick() {
        view.navigateToLogin();
    }

    public void registerUser(String email, String password, @NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            view.displayStatusMessage("Account created.");
            model.writeToDB(email, password, task);
        }
        else {
            view.displayStatusMessage("Register failed.");

        }
    }

    public void hideProgressBar() {
        view.hideProgressBar();
    }
}
