package com.example.finalmerge.PostAnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.finalmerge.homePage.MainActivity;
import com.example.finalmerge.homePage.models.Announcements;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

import com.example.finalmerge.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAnnouncement extends AppCompatActivity {
    Button post_btn, home_btn;
    TextInputEditText subject, ann_description;
    DatabaseReference announcementDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_announcement);

        post_btn = findViewById(R.id.post_btn);
        home_btn = findViewById(R.id.home_btn);

        subject = findViewById(R.id.subject);
        ann_description = findViewById(R.id.ann_description);
        announcementDbRef = FirebaseDatabase.getInstance().getReference("https://cscb0-13f6b-default-rtdb.firebaseio.com/");

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                change the directed class later
                startActivity(intent);
                finish();
            }
        });

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String annSubject = subject.getText().toString();
                String annDescription = ann_description.getText().toString();
                if(TextUtils.isEmpty(annSubject)){
                    Toast.makeText(PostAnnouncement.this, "Announcement subject cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(annDescription)){
                    Toast.makeText(PostAnnouncement.this, "Announcement description cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                insertAnnouncement();
            }
        });
    }

    private void insertAnnouncement() {
        String id = announcementDbRef.push().getKey();
        String annSubject = subject.getText().toString();
        String annDescription = ann_description.getText().toString();
        Announcements announcements  = new Announcements(id, annSubject, annDescription);
        announcementDbRef.push().setValue(announcements);
        Toast.makeText(PostAnnouncement.this,"Inserted", Toast.LENGTH_LONG).show();
    }
}
