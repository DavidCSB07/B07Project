package com.example.finalmerge.homePage.ComplaintUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.ComplaintsPage.ComplaintPage;
import com.example.finalmerge.ComplaintsPage.PostComplaint;
import com.example.finalmerge.R;

public class ComplaintUI extends AppCompatActivity {

    Button viewComplaint, postComplaint, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_complaints);
        /*
        UI intent:
        Admin:
        ComplaintUI -> ComplaintPage.class
        home -> homePage.class
        Student:
        ComplaintUI -> ComplaintPage.class + PostComplaint.class
        home -> homePage.class
         */
        //set field
        viewComplaint = findViewById(R.id.ViewComplaints);
        postComplaint = findViewById(R.id.PostComplaints);
        home = findViewById(R.id.home);

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
                Intent intent = new Intent(getApplicationContext(), com.example.finalmerge.homePage.homePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}