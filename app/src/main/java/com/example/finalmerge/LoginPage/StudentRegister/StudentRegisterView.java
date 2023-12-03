package com.example.finalmerge.LoginPage.StudentRegister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.LoginPage.Login.LoginView;
import com.example.finalmerge.LoginPage.Model.UserInfo;
import com.example.finalmerge.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegisterView extends AppCompatActivity {
    private TextInputEditText editTextEmail, editTextPassword;
    private Button buttonReg;
    ProgressBar progressBar; //id of 'stuff' in layout
    private TextView loginNow;
    private StudentRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_register);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        buttonReg = findViewById(R.id.register_button);
        loginNow = findViewById(R.id.LoginNow);

        progressBar = findViewById(R.id.progressBar);

        presenter = new StudentRegisterPresenter(this, new StudentRegisterModel());

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginView.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                progressBar.setVisibility(View.VISIBLE);
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(StudentRegisterView.this, "Enter password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(StudentRegisterView.this, "Enter email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                presenter.onRegisterClicked(email, password);
            }
        });


    }

    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void showCreateAccountStatus(String statusMessage) {
        Toast.makeText(getApplicationContext(), statusMessage, Toast.LENGTH_SHORT).show();
    }
}