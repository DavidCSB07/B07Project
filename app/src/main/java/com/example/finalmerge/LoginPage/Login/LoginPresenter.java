package com.example.finalmerge.LoginPage.Login;

public class LoginPresenter {

    private LoginModel model;
    private LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void checkInput() {
        String email= view.getEmail();
        String password=view.getPassword();

        if(email.equals("")) {
            view.displayError("Email cannot be empty");
        }
        if (password.equals("")) {
            view.displayError("Password cannot be empty");
        }
        else if (password.length() < 6) {
            view.displayError("Password must be at least 6 characters");
        }

        if (!(email.equals("")) && password.length()>=6) {
            model.signInWithEmailAndPassword(email, password, this);
        }
    }

    public void onLoginSuccess(int userType) {
        if (userType == 0) {
            view.buildLoginSuccess("Student Login Successful");
        } else if (userType == 1) {
            view.buildLoginSuccess("Admin Login Successful");
        } else {
            view.displayError("Please try again");
        }
    }

    public void onLoginError(String errorMessage) {
        view.displayError(errorMessage);
    }

    public void onStudentRegisterClick() {
        view.navigateToStudentRegister();
    }

    public void onAdminRegisterClick() {
        view.navigateToAdminRegister();
    }


    public void hideProgressBar() {
        view.hideProgressBar();
    }

    public void displayProgressBar() {
        view.displayProgressBar();
    }
}

