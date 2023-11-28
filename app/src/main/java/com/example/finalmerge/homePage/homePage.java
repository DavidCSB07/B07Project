package com.example.finalmerge.homePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalmerge.ComplaintsPage.ComplaintsForm;
import com.example.finalmerge.LoginPage.Login;
import com.example.finalmerge.R;
import com.example.finalmerge.EventPage.ScheduleEvent;


public class homePage extends AppCompatActivity {

    Button Events, Complaints, Announcement, POSt, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);

        Events = findViewById(R.id.Events);
        Complaints = findViewById(R.id.Complaints);
        Announcement = findViewById(R.id.Announcement);
        POSt = findViewById(R.id.POSt);
        Logout = findViewById(R.id.Logout);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        Complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComplaintsForm.class);
                startActivity(intent);
                finish();
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScheduleEvent.class);
                startActivity(intent);
                finish();
            }
        });



    }
}