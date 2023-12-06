package com.example.finalmerge.LoginPage.AdminRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.LoginPage.Login.LoginView;
import com.example.finalmerge.R;
import com.google.android.material.textfield.TextInputEditText;

public class AdminRegisterView extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonReg;
    ProgressBar progressBar; //id of 'stuff' in layout
    TextView loginNow;
    AdminRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_admin_register);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        buttonReg = findViewById(R.id.register_button);
        loginNow = findViewById(R.id.LoginNow);

        progressBar = findViewById(R.id.progressBar);

        presenter = new AdminRegisterPresenter(new AdminRegisterModel(),this);

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginNowClick();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRegisterClick();
            }
        });
    }

    public void displayProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void displayStatusMessage(String statusMessage) {
        Toast.makeText(getApplicationContext(), statusMessage, Toast.LENGTH_SHORT).show();
    }

    public void navigateToLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginView.class);
        startActivity(intent);
        finish();
    }

    public String getEmail() {
        return String.valueOf(editTextEmail.getText());
    }

    public String getPassword() {
        return String.valueOf(editTextPassword.getText());

    }



}