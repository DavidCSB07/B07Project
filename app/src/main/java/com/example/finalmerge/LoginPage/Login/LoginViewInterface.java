package com.example.finalmerge.LoginPage.Login;

public interface LoginViewInterface {
    void showProgress();
    void hideProgress();
    void showError(String message);
    void navigateToHomePage(String userType);

}
