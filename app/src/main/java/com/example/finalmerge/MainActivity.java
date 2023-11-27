package com.example.finalmerge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button Events, Complaints, Announcement, POSt, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Events = findViewById(R.id.Events);
        Complaints = findViewById(R.id.Complaints);
        Announcement = findViewById(R.id.Announcement);
        POSt = findViewById(R.id.POSt);
        Logout = findViewById(R.id.Logout);

        /*
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScheduleEvent.class);
                startActivity(intent);
                finish();
            }
        });
        */


    }
}