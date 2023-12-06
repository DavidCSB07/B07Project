package com.example.finalmerge.LoginPage.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.LoginPage.AdminRegister.AdminRegisterView;
import com.example.finalmerge.LoginPage.StudentRegister.StudentRegisterView;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

public class LoginView extends AppCompatActivity {

    private ProgressBar progressBar; //id of items in layout
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_login);

        progressBar = findViewById(R.id.progressBar);

        presenter = new LoginPresenter(new LoginModel(), this);
    }

    public void onStudentRegisterClick(View view) {
        presenter.onStudentRegisterClick();
    }
    public void onAdminRegisterClick(View view) {
        presenter.onAdminRegisterClick();
    }

    public void onLoginClick(View view) {
        presenter.displayProgressBar();
        presenter.checkInput();
    }


    public void displayProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void buildLoginSuccess(String successMessage) {
        Toast.makeText(getApplicationContext(), successMessage, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), homePage.class);
        startActivity(intent);
        finish();
    }

    public void displayError(String message) {
        Toast.makeText(LoginView.this, message, Toast.LENGTH_SHORT).show();    }

    public void navigateToStudentRegister() {
        Intent toStudentRegister = new Intent(getApplicationContext(), StudentRegisterView.class);
        startActivity(toStudentRegister);
        finish();
    }

    public void navigateToAdminRegister() {
        Intent toAdminRegister = new Intent(getApplicationContext(), AdminRegisterView.class);
        startActivity(toAdminRegister);
        finish();
    }

    public String getEmail() {
        EditText editTextEmail = findViewById(R.id.email);
        return editTextEmail.getText().toString();
    }
    public String getPassword() {
        EditText editTextPassword = findViewById(R.id.password);
        return editTextPassword.getText().toString();
    }
}