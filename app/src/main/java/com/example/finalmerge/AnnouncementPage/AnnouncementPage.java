package com.example.finalmerge.AnnouncementPage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.AnnouncementPage.Adapter.AnnAdapter;
import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnnouncementPage extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    AnnAdapter adapter;
    ArrayList<Announcements> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_page);

        recyclerView = findViewById(R.id.annList);
        database = FirebaseDatabase.getInstance().getReference("Announcements");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new AnnAdapter(this,list);
        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Announcements announcements = dataSnapshot.getValue(Announcements.class);
                    list.add(announcements);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
