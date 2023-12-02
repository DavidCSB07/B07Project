package com.example.finalmerge.LoginPage.Login;

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

import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginView extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonLog;
    ProgressBar progressBar; //id of 'stuff' in layout
    TextView StudentRegister;
    TextView AdminRegister;
    DatabaseReference LoginDbRef;
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
                progressBar.setVisibility(View.VISIBLE);
                presenter.setViewText(email, password);
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    LoginDbRef = FirebaseDatabase.getInstance().getReference();
                                    String uid = task.getResult().getUser().getUid();
                                    LoginDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            int userType = snapshot.getValue(Integer.class);
                                            if(userType == 0) {
                                                Toast.makeText(getApplicationContext(), "login Successful as Admin", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), homePage.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else if(userType == 1) {
                                                Toast.makeText(getApplicationContext(), "login Successful as Student", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), homePage.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else {
                                                Toast.makeText(getApplicationContext(), "Please Delete account something went wrong", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginView.this, "LoginView fail.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public void setOutputText(String resultText){
        Toast.makeText(LoginView.this, resultText, Toast.LENGTH_SHORT).show();
    }
}