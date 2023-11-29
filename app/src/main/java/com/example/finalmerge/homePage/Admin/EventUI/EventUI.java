package com.example.finalmerge.homePage.Admin.EventUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.PostEvent;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.Admin.Admin_homePage;

public class EventUI extends AppCompatActivity {

    Button viewEvent, postEvent, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_event);

        //set field

        viewEvent = findViewById(R.id.ViewEvent);
        postEvent = findViewById(R.id.PostEvent);
        home = findViewById(R.id.home);

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
                Intent intent = new Intent(getApplicationContext(), Admin_homePage.class);
                startActivity(intent);
                finish();
            }
        });


    }
}