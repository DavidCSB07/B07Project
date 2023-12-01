package com.example.finalmerge.AnnouncementPage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.text.DateFormat;

public class PostAnnouncement extends AppCompatActivity {
    TextInputEditText annSubject, annDes;
    TextView annDate;
    Button post_btn, home_btn;
    DatabaseReference AnnouncementDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_post);

        //set field

        annSubject = findViewById(R.id.annSubject);
        annDes = findViewById(R.id.annDes);
        annDate = findViewById(R.id.annDate);
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        annDate.setText(date);
        home_btn = findViewById(R.id.home_btn);
        post_btn = findViewById(R.id.post_btn);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = annSubject.getText().toString();
                String description = annDes.getText().toString();

                //Check if TextInput is empty
                if(TextUtils.isEmpty(subject)){
                    Toast.makeText(PostAnnouncement.this, "Subject cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    Toast.makeText(PostAnnouncement.this, "Description cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                Announcements announcements = new Announcements(subject, description, date);
                addAnnouncement  (announcements, subject);
            }
        });{
            String subject = annSubject.getText().toString();
            String description = annDes.getText().toString();

            //Check if TextInput is empty
            if(TextUtils.isEmpty(subject)){
                Toast.makeText(PostAnnouncement.this, "Subject cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(description)){
                Toast.makeText(PostAnnouncement.this, "Description cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            Announcements announcements = new Announcements(subject, description, date);
            addAnnouncement  (announcements, subject);
        }
    }

    private void addAnnouncement(Announcements announcements, String subject) {
        AnnouncementDbRef = FirebaseDatabase.getInstance().getReference();
        AnnouncementDbRef.child("Announcement").push().setValue(announcements).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(PostAnnouncement.this, "Announcement is post", Toast.LENGTH_SHORT).show();
            }
        });


    }
}