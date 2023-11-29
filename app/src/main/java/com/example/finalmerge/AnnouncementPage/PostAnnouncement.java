package com.example.finalmerge.AnnouncementPage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAnnouncement extends AppCompatActivity {
    TextInputEditText annSubject, annDes;
    Button post_btn, home_btn;
    DatabaseReference AnnouncementDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_post);

        //set field

        annSubject = findViewById(R.id.annSubject);
        annDes = findViewById(R.id.annDes);

        post_btn = findViewById(R.id.post_btn);

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

                Announcements announcements = new Announcements(subject, description);
                addAnnouncement  (announcements, subject);
            }
        });
    }

    private void addAnnouncement(Announcements announcements, String subject) {
        AnnouncementDbRef = FirebaseDatabase.getInstance().getReference();
        AnnouncementDbRef.child("Announcement").child(subject).setValue(announcements).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(PostAnnouncement.this, "Announcement is post", Toast.LENGTH_SHORT).show();
            }
        });


    }
}