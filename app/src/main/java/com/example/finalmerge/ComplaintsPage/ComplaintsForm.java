package com.example.finalmerge.ComplaintsPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalmerge.ComplaintsPage.Model.Complaint;
import com.example.finalmerge.R;

// firebase
import com.example.finalmerge.homePage.Student.Student_homePage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintsForm extends AppCompatActivity {
    EditText editEmail;
    EditText editSubject;
    EditText editComplaint;
    Button buttonSubmitComplaint;
    Button buttonCancel;

    DatabaseReference complaintsDBRef;

    //Intent returnHome=new Intent(ComplaintsForm.this, LandingPage.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_form);

        editEmail=findViewById(R.id.editEmail);
        editSubject=findViewById(R.id.editSubject);
        editComplaint=findViewById(R.id.editComplaint);
        buttonSubmitComplaint=findViewById(R.id.buttonSubmitComplaint);

        buttonCancel = findViewById(R.id.buttonCancel);

        // intent-->return to menu/landing page
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnHome = new Intent(getApplicationContext(), Student_homePage.class);
                startActivity(returnHome);
                finish();
            }
        });

        complaintsDBRef=FirebaseDatabase.getInstance().getReference().child("Complaint");

        buttonSubmitComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertComplaintsData();
            }
        });


    }

    private void insertComplaintsData() {

        String email=editEmail.getText().toString();
        String subject=editSubject.getText().toString();
        String complaint=editComplaint.getText().toString();

        // check validity
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(ComplaintsForm.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(subject)) {
            Toast.makeText(ComplaintsForm.this, "Subject cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(complaint)) {
            Toast.makeText(ComplaintsForm.this, "Complaint cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Complaint complaints =new Complaint(email, subject, complaint);
        //addSucessListener
        complaintsDBRef.push().setValue(complaints);
        Toast.makeText(ComplaintsForm.this, "Complaint Submitted", Toast.LENGTH_SHORT).show();
        Intent returnHome = new Intent(ComplaintsForm.this, Student_homePage.class);
        startActivity(returnHome);
        finish();
    }
}