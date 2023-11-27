package com.example.finalmerge.ScheduleEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.finalmerge.R;
import com.example.finalmerge.ScheduleEvent.models.Event;
import com.example.finalmerge.homePage.homePage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScheduleEvent extends AppCompatActivity {


    Button button, createbutton;

    TextInputEditText text_title, date, text_description, participats;

    DatabaseReference eventDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_event);

        createbutton = findViewById(R.id.scheudle_button);
        button = findViewById(R.id.home_button);

        text_title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        text_description = findViewById(R.id.description);
        participats = findViewById(R.id.participation);
        eventDbRef = FirebaseDatabase.getInstance().getReference().child("ScheduleEvent");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });

        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = text_description.getText().toString();
                String title = text_title.getText().toString();
                String participants = participats.getText().toString();

                //int num_participants = Integer.parseInt(participants);
                if(TextUtils.isEmpty(title)){
                    Toast.makeText(ScheduleEvent.this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    Toast.makeText(ScheduleEvent.this, "Description cannot be empty", Toast.LENGTH_SHORT).show();
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

        //String key = myRef.getKey();
        //post.setPostKey(key);

        // add post data to firebase database
        eventDbRef.push().setValue(event).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ScheduleEvent.this, "data inserted", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ScheduleEvent.this, "data not inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}