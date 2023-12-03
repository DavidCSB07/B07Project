package com.example.finalmerge.LoginPage.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.LoginPage.AdminRegister.AdminRegisterView;
import com.example.finalmerge.LoginPage.StudentRegister.StudentRegisterView;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.android.material.textfield.TextInputEditText;

public class LoginView extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonLog;
    ProgressBar progressBar; //id of 'stuff' in layout
    TextView StudentRegister;
    TextView AdminRegister;
    LoginPresenter presenter;

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

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonLog = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progressBar);
        StudentRegister = findViewById(R.id.StudentRegister);
        AdminRegister = findViewById(R.id.AdminRegister);
        presenter = new LoginPresenter(new LoginModel(), this);

        StudentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStudentRegisterClick();
            }
        });

        AdminRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAdminRegisterClick();
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                presenter.onLoginClick(email, password);
            }
        });
    }

    public void displayProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void displayLoginSuccess(String successMessage) {
        Toast.makeText(getApplicationContext(), successMessage, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), homePage.class);
        startActivity(intent);
        finish();
    }

    public void displayLoginError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void navigateToStudentRegister() {
        Intent intent = new Intent(getApplicationContext(), StudentRegisterView.class);
        startActivity(intent);
        finish();
    }

    public void navigateToAdminRegister() {
        Intent intent = new Intent(getApplicationContext(), AdminRegisterView.class);
        startActivity(intent);
        finish();
    }
}