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

        eventsList = new ArrayList<>();
        eventAdapter = new EventAdapter(this, eventsList);

        recyclerview = findViewById(R.id.recycleView);
        recyclerview.setHasFixedSize(true);

        eventsList.add(new Event("title", "description"));
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(eventAdapter);


        /*
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    //Event event = dataSnapshot.getValue(Event.class);
                    //eventsList.add(event);
                }
                //eventAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         */




    }

}
