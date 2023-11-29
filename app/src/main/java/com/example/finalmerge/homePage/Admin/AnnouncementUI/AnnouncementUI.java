package com.example.finalmerge.homePage.Admin.AnnouncementUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.AnnouncementPage;
import com.example.finalmerge.AnnouncementPage.PostAnnouncement;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.Admin.Admin_homePage;

public class AnnouncementUI extends AppCompatActivity {

    Button viewAnnouncement, postAnnouncement, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_announcement);

        //setButton by id

        viewAnnouncement = findViewById(R.id.ViewAnnouncement);
        postAnnouncement = findViewById(R.id.PostAnnouncement);
        home = findViewById(R.id.home);

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
                Intent intent = new Intent(getApplicationContext(), Admin_homePage.class);
                startActivity(intent);
                finish();
            }
        });



    }
}