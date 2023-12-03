package com.example.finalmerge.LoginPage.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.LoginPage.AdminRegister.AdminRegisterView;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

public class LoginView extends AppCompatActivity {

    private ProgressBar progressBar; //id of 'stuff' in layout
    private LoginPresenter presenter;
    private TextView passwordErrorMessage;
    private TextView emailErrorMessage;

    //Check if acc is signed in
    /*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), homePage.class);
            startActivity(intent);
            finish();
        }
    }
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_login);

        progressBar = findViewById(R.id.progressBar);
        passwordErrorMessage=findViewById(R.id.PasswordInputMessage);
        emailErrorMessage=findViewById(R.id.EmailInputMessage);

        presenter = new LoginPresenter(new LoginModel(), this);
    }

    public void onLoginClick(View view) {
        presenter.checkInput();
    }
    public void onStudentRegisterClick(View view) {
        presenter.onStudentRegisterClick();
    }
    public void onAdminRegisterClick(View view) {
        presenter.onAdminRegisterClick();
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

    /*
    public void displayLoginError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }*/


    public void displayEmailError(String message) {
        emailErrorMessage.setText(message);
    }
    public void displayPasswordError(String message) {
        passwordErrorMessage.setText(message);
    }


    public void navigateToStudentRegister() {
        Intent intent = new Intent(getApplicationContext(), AdminRegisterView.class);
        startActivity(intent);
        finish();
    }

    public void navigateToAdminRegister() {
        Intent intent = new Intent(getApplicationContext(), com.example.finalmerge.LoginPage.AdminRegister.AdminRegisterView.class);
        startActivity(intent);
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