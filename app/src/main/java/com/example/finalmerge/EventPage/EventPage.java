package com.example.finalmerge.EventPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalmerge.EventPage.Adapter.EventAdapter;
import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_recycleview);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("ScheduleEvent");
        recyclerview = findViewById(R.id.recycleView);

        List<Event> items = new ArrayList<Event>();
        items.add(new Event("David", "David@gmail.com"));
        items.add(new Event("Javid", "Javid@gmail.com"));
        items.add(new Event("Lynn", "Lynn@gmail.com"));
        items.add(new Event("Jess", "Jess@gmail.com"));
        items.add(new Event("Hillary", "Hill@gmail.com"));

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new EventAdapter(getApplicationContext(), items));
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventsList = new ArrayList<>();
                for(DataSnapshot Eventsnapshot : snapshot.getChildren()){

                    Event event = Eventsnapshot.getValue(Event.class);
                    eventsList.add(event);
                }

                eventAdapter = new EventAdapter(getApplicationContext(), eventsList);
                recyclerview.setAdapter(eventAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       }
     */
}
