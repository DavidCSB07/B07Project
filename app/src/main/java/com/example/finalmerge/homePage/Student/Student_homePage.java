package com.example.finalmerge.homePage.Student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.AnnouncementPage;
import com.example.finalmerge.ComplaintsPage.PostComplaint;
import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.LoginPage.Login;
import com.example.finalmerge.R;


public class Student_homePage extends AppCompatActivity {

    Button Announcement, Events, Complaints, POSt, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_student);

        Announcement = findViewById(R.id.Announcement);
        Events = findViewById(R.id.Events);
        Complaints = findViewById(R.id.Complaints);
        POSt = findViewById(R.id.POSt);
        Logout = findViewById(R.id.Logout);

        /*
        Student home Page intent:

        Announcement -> AnnouncementPage.class
        Event -> EventPage.class
        Complaint -> ComplaintForm.class
        POSt -> ...
        Logout -> Login.class

         */
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


        Announcement.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnnouncementPage.class);
                startActivity(intent);
                finish();
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });

        Complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostComplaint.class);
                startActivity(intent);
                finish();
            }
        });

        POSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to POStPage
            }
        });



    }
}