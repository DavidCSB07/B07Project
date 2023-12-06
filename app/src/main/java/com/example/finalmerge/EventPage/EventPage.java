package com.example.finalmerge.EventPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.EventPage.Adapter.EventAdapter;
import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventPage extends AppCompatActivity {

    RecyclerView recyclerview;
    EventAdapter eventAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Event> eventsList;

    Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_page);

        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("ScheduleEvent");

        eventsList = new ArrayList<>();
        eventAdapter = new EventAdapter(this, eventsList);

        recyclerview = findViewById(R.id.EventList);
        recyclerview.setHasFixedSize(true);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(eventAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Event event = dataSnapshot.getValue(Event.class);
                    eventsList.add(event);
                }
                eventAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }

}
