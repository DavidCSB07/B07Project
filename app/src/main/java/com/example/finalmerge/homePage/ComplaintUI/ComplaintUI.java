package com.example.finalmerge.homePage.ComplaintUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.ComplaintsPage.ComplaintPage;
import com.example.finalmerge.R;

public class ComplaintUI extends AppCompatActivity {

    Button viewComplaints, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_complaints);

        //set field

        viewComplaints = findViewById(R.id.ViewComplaints);
        home = findViewById(R.id.home);

        viewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComplaintPage.class);
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