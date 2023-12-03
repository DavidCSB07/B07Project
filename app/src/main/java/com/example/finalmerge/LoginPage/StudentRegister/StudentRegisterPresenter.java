package com.example.finalmerge.LoginPage.StudentRegister;

public class StudentRegisterPresenter {
    StudentRegisterModel model;
    StudentRegisterView view;

    public StudentRegisterPresenter(StudentRegisterView view, StudentRegisterModel model) {
        this.model = model;
        this.view = view;
    }

    public void OnRegisterClicked(String email, String password){
        view.showProgressBar();
        model.createUserWithEmailAndPassword(email, password, this);
    }

    public void RegisterStatus(String statusMessage){
        view.hideProgressBar();
        view.showCreateAccountStatus(statusMessage);
    }

}
