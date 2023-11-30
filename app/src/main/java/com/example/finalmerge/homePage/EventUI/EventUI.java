package com.example.finalmerge.homePage.EventUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.PostEvent;
import com.example.finalmerge.R;

public class EventUI extends AppCompatActivity {

    Button viewEvent, postEvent, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_event);
        /*
        EventUI intent:
        Admin:
        EventUI -> ScheduleEvent.class + EventPage.class(Rating and Comments --> retrieve from RSVP)
        home -> homePage.class
        Student:
        EventUI -> EventPage.class(-->RSVP)
        home -> homePage.class
         */
        //set field
        viewEvent = findViewById(R.id.ViewEvent);
        postEvent = findViewById(R.id.PostEvent);
        home = findViewById(R.id.home);

        //set Visibility base on userType (0 --> student, 1 --> admin)



        viewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });

        postEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostEvent.class);
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