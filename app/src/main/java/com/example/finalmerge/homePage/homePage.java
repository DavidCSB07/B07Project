package com.example.finalmerge.homePage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.finalmerge.R;


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