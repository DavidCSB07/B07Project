package com.example.finalmerge.EventPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalmerge.EventPage.Adapter.EventAdapter;
import com.example.finalmerge.EventPage.Model.Event;
import com.example.finalmerge.R;

import java.util.ArrayList;
import java.util.List;

public class EventPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_recycleview);

        RecyclerView recyclerview = findViewById(R.id.recycleView);

        List<Event> items = new ArrayList<Event>();
        items.add(new Event("David", "David@gmail.com"));
        items.add(new Event("Javid", "Javid@gmail.com"));
        items.add(new Event("Lynn", "Lynn@gmail.com"));
        items.add(new Event("Jess", "Jess@gmail.com"));
        items.add(new Event("Hillary", "Hill@gmail.com"));

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new EventAdapter(getApplicationContext(), items));
    }
}