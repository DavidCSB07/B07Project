package com.example.finalmerge.homePage.AnnouncementUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.AnnouncementPage;
import com.example.finalmerge.AnnouncementPage.PostAnnouncement;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AnnouncementUI extends AppCompatActivity {

    Button viewAnnouncement, postAnnouncement, home;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_announcement);
        /*
        AnnouncementUI intent:
        Admin:
        AnnouncementUI -> AnnouncementPage.class + PostAnnouncement.class
        home -> homePage.class
        Student:
        AnnouncementUI -> AnnouncementPage.class
        home -> homePage.class
         */

        //set field
        viewAnnouncement = findViewById(R.id.ViewAnnouncement);
        postAnnouncement = findViewById(R.id.PostAnnouncement);
        home = findViewById(R.id.home);
        FirebaseUser currentUser = mAuth.getCurrentUser();


        viewAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnnouncementPage.class);
                startActivity(intent);
                finish();
            }
        });

        postAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostAnnouncement.class);
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