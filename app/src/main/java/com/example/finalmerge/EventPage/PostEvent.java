package com.example.finalmerge.EventPage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostEvent extends AppCompatActivity {


    Button homebutton, schedulebutton;

    TextInputEditText text_title, date, text_description, participats;

    DatabaseReference eventDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_post);

        schedulebutton = findViewById(R.id.schedule_button);
        homebutton = findViewById(R.id.home_button);

        text_title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        text_description = findViewById(R.id.description);
        participats = findViewById(R.id.participation);
        eventDbRef = FirebaseDatabase.getInstance().getReference().child("ScheuldEvent");



        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });

        schedulebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = text_description.getText().toString();
                String title = text_title.getText().toString();
                String participants = participats.getText().toString();

                //int num_participants = Integer.parseInt(participants);
                if(TextUtils.isEmpty(title)){
                    Toast.makeText(PostEvent.this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    Toast.makeText(PostEvent.this, "Description cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }


                // check date & participation condition


                // implements Post Object and add to firebase

                Event event = new Event(title, description);
                addEvent(event);

            }
        });
    }

    private void addEvent(Event event) {


        //FirebaseDatabase database = FirebaseDatabase.getInstance().getReference();
        //DatabaseReference myRef = database.child("ScheduleEvent").push();

        // add post data to firebase database
        eventDbRef.push().setValue(event).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(PostEvent.this, "data inserted", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostEvent.this, "data not inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }

}