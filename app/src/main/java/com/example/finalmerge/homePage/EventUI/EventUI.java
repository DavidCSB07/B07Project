package com.example.finalmerge.homePage.EventUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.PostEvent;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventUI extends AppCompatActivity {

    Button viewEvent, postEvent, home;
    DatabaseReference EventUIDbRef;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_event);
        viewEvent = findViewById(R.id.ViewEvent);
        postEvent = findViewById(R.id.PostEvent);
        home = findViewById(R.id.home);
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


        mAuth = FirebaseAuth.getInstance();
        EventUIDbRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();

        //set Visibility base on userType (0 --> student, 1 --> admin)
        EventUIDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 0 is student, 1 is admin
                int userType = snapshot.getValue(Integer.class);
                if(userType == 0){
                    //student
                    viewEvent.setVisibility(View.VISIBLE);
                    postEvent.setVisibility(View.GONE);
                }
                if(userType == 1){
                    //admin
                    viewEvent.setVisibility(View.VISIBLE);
                    postEvent.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


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