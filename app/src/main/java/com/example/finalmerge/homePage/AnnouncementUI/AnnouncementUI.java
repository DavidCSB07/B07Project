package com.example.finalmerge.homePage.AnnouncementUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.AnnouncementPage;
import com.example.finalmerge.AnnouncementPage.PostAnnouncement;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AnnouncementUI extends AppCompatActivity {

    Button viewAnnouncement, postAnnouncement, home;
    DatabaseReference AnnouncementUIDbRef;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_announcement);

        //set field
        viewAnnouncement = findViewById(R.id.ViewAnnouncement);
        postAnnouncement = findViewById(R.id.PostAnnouncement);
        home = findViewById(R.id.home);



        /*
        AnnouncementUI intent:
        Admin:
        AnnouncementUI -> AnnouncementPage.class + PostAnnouncement.class
        home -> homePage.class
        Student:
        AnnouncementUI -> AnnouncementPage.class
        home -> homePage.class
         */

        AnnouncementUIDbRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();
        AnnouncementUIDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 0 is student, 1 is admin
                int userType = snapshot.getValue(Integer.class);
                    if(userType == 0){
                        //student
                        viewAnnouncement.setVisibility(View.VISIBLE);
                        postAnnouncement.setVisibility(View.GONE);
                    }
                    if(userType == 1){
                        //admin
                        viewAnnouncement.setVisibility(View.VISIBLE);
                        postAnnouncement.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


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