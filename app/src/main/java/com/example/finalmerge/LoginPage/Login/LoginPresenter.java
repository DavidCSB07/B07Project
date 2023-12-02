package com.example.finalmerge.LoginPage.Login;

public class LoginPresenter {
    LoginView view;
    LoginModel model;

    public LoginPresenter(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    public void onLoginClicked(String email, String password) {
        view.showProgressBar();
        // Call the signIn method in the Model
        model.signInWithEmailAndPassword(email, password, new LoginModel.OnSignInListener() {
            @Override
            public void onSignInSuccess(int userType) {
                view.hideProgressBar();
                if (userType == 0) {
                    view.showLoginSuccessAsAdmin();
                } else if (userType == 1) {
                    view.showLoginSuccessAsStudent();
                } else {
                    view.showLoginError("Please try again.");
                }
            }

            @Override
            public void onSignInFailure(String errorMessage) {
                onSignInFailure(errorMessage);
                view.hideProgressBar();
                view.showLoginError(errorMessage);
            }
        });
    }

}
