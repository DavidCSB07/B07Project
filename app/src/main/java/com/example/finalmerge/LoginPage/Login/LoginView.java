package com.example.finalmerge.LoginPage.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonLog = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progressBar);
        StudentRegister = findViewById(R.id.StudentRegister);
        AdminRegister = findViewById(R.id.AdminRegister);
        presenter = new LoginPresenter(this, new LoginModel());

        StudentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.finalmerge.LoginPage.StudentRegister.class);
                startActivity(intent);
                finish();
            }
        });


        AdminRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.finalmerge.LoginPage.AdminRegister.class);
                startActivity(intent);
                finish();
            }
        });



        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginView.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginView.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                presenter.onLoginClicked(email, password);

            }
        });
    }

    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void showLoginSuccessAsAdmin() {
        Toast.makeText(getApplicationContext(), "Login successful as Admin", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), homePage.class);
        startActivity(intent);
        finish();
    }

    public void showLoginSuccessAsStudent() {
        Toast.makeText(getApplicationContext(), "Login successful as Student", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), homePage.class);
        startActivity(intent);
        finish();
    }

    public void showLoginError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}