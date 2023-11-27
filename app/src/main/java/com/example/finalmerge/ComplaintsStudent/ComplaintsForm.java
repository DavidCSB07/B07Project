package com.example.finalmerge.ComplaintsStudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalmerge.ComplaintsStudent.Menu.LandingPage;
import com.example.finalmerge.R;

// firebase
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintsForm extends AppCompatActivity {

    EditText editEmail;
    EditText editSubject;
    EditText editComplaint;
    Button buttonSubmitComplaint;
    Button buttonCancel;

    DatabaseReference complaintsDBRef;


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
                Intent intent=new Intent(ComplaintsForm.this, LandingPage.class);
                startActivity(intent);
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

        Complaints complaints=new Complaints(email, subject, complaint);

        complaintsDBRef.push().setValue(complaints);
        Toast.makeText(ComplaintsForm.this, "Complaint Submitted", Toast.LENGTH_SHORT).show();
    }

}