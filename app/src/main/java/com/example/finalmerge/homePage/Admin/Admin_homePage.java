package com.example.finalmerge.homePage.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.ComplaintsPage.PostComplaint;
import com.example.finalmerge.EventPage.PostEvent;
import com.example.finalmerge.LoginPage.Login;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.Admin.AnnouncementUI.AnnouncementUI;

public class Admin_homePage extends AppCompatActivity {


    Button Announcement, Events, Complaints, POSt, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_admin);

        Announcement = findViewById(R.id.Announcement);
        Events = findViewById(R.id.Events);
        Complaints = findViewById(R.id.Complaints);
        POSt = findViewById(R.id.POSt);
        Logout = findViewById(R.id.Logout);

        /*
        Admin home Page intent:

        Announcement -> AnnouncementUI -> AnnouncementPage.class or PostAnnouncement
        Event -> EventPage.class(Rating and Comments --> retrieve from RSVP) + ScheduleEvent
        Complaint -> ComplaintForm.class + ComplaintPage
        ?? POSt -> ... ??
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
                Intent intent = new Intent(getApplicationContext(), AnnouncementUI.class);
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

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostEvent.class);
                startActivity(intent);
                finish();
            }
        });
    }
}