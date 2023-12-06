package com.example.finalmerge.LoginPage;

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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class AdminRegister extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonReg;
    FirebaseAuth mAuth;
    DatabaseReference registerDbRef;
    ProgressBar progressBar; //id of 'stuff' in layout
    TextView loginNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_admin_register);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        buttonReg = findViewById(R.id.register_button);
        loginNow = findViewById(R.id.LoginNow);

        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();


        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
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
                    Toast.makeText(AdminRegister.this, "Enter password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(AdminRegister.this, "Enter email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(AdminRegister.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    String uid = task.getResult().getUser().getUid();
                                    //UserInfo userinfo = new UserInfo(uid, email, password, 1);
                                    //registerDbRef = FirebaseDatabase.getInstance().getReference();
                                    //registerDbRef.child("RegisterInfo").child(uid).setValue(userinfo);
                                } else {
                                    // If sign up fails, display a message to the user.
                                    Toast.makeText(AdminRegister.this, "Register failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}