package com.example.finalmerge.LoginPage.Login;

import android.text.TextUtils;

public class LoginPresenter {

    private LoginModel model;
    private LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void checkInput() {
        view.displayProgressBar();
        String email= view.getEmail();
        String password=view.getPassword();

        if (TextUtils.isEmpty(email)) {
            view.displayEmailError("Email cannot be empty");
            return;
        }
        if(TextUtils.isEmpty(password)){
            view.displayPasswordError("Password cannot be empty");
            return;
        }
        else if (password.length()<6) {
            view.displayPasswordError("Password must be at least 6 characters");
            return;
        }
        model.signInWithEmailAndPassword(email, password, this);
    }


    public void onSignInSuccess(int userType) {
        view.hideProgressBar();
        if (userType == 0) {
            view.buildLoginSuccess("Student Login Successful");
        } else if (userType == 1) {
            view.buildLoginSuccess("Admin Login Successful");
        } else {
            view.displayEmailError("Please try again.");
        }
    }

    public void onSignInError(String errorMessage) {
        view.hideProgressBar();
        view.displayEmailError(errorMessage);
    }

    public void onStudentRegisterClick() {
        view.navigateToStudentRegister();
    }

    public void onAdminRegisterClick() {
        view.navigateToAdminRegister();
    }


}
