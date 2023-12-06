package com.example.finalmerge.homePage.ComplaintUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.ComplaintsPage.ComplaintPage;
import com.example.finalmerge.ComplaintsPage.PostComplaint;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ComplaintUI extends AppCompatActivity {

    Button viewComplaint, postComplaint, home;
    DatabaseReference ComplaintUIDbRef;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_complaints);
        viewComplaint = findViewById(R.id.ViewComplaints);
        postComplaint = findViewById(R.id.PostComplaints);
        home = findViewById(R.id.home);
        /*
        UI intent:
        Admin:
        ComplaintUI -> ComplaintPage.class
        home -> homePage.class
        Student:
        ComplaintUI -> PostComplaint.class
        home -> homePage.class
         */
        //set field
        mAuth = FirebaseAuth.getInstance();
        ComplaintUIDbRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();
        ComplaintUIDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 0 is student, 1 is admin
                int userType = snapshot.getValue(Integer.class);
                if(userType == 0){
                    //student
                    viewComplaint.setVisibility(View.VISIBLE);
                    postComplaint.setVisibility(View.GONE);
                }
                if(userType == 1){
                    //admin
                    viewComplaint.setVisibility(View.VISIBLE);
                    postComplaint.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        viewComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComplaintPage.class);
                startActivity(intent);
                finish();
            }
        });

        postComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostComplaint.class);
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}