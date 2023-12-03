package com.example.finalmerge.LoginPage.Login;

import android.text.TextUtils;

public class LoginPresenter {

    LoginModel model;
    LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void onLoginClick(String email, String password) {
        view.displayProgressBar();

        if (TextUtils.isEmpty(email)) {
            view.displayLoginError("Email cannot be empty");
            return;
        }

        if(TextUtils.isEmpty(password)){
            view.displayLoginError("Password cannot be empty");
            return;
        }
        else if (password.length()<6) {
            view.displayLoginError("Password must be at least 6 characters");
            return;
        }
        model.signInWithEmailAndPassword(email, password, this);
    }

    public void onSignInStatus(int userType) {
        view.hideProgressBar();
        if (userType == 0) {
            view.displayLoginSuccess("Admin Login Successful");
        } else if (userType == 1) {
            view.displayLoginSuccess("Student Login Successful");
        } else {
            view.displayLoginError("Please try again.");
        }
    }

    public void onSignInError(String errorMessage) {
        view.hideProgressBar();
        view.displayLoginError(errorMessage);
    }

    public void onStudentRegisterClick() {
        view.navigateToStudentRegister();
    }

    public void onAdminRegisterClick() {
        view.navigateToAdminRegister();
    }
}
