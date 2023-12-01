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
    FirebaseDatabase firebaseDatabase;
    AnnAdapter adapter;
    ArrayList<Announcements> announcementList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_page);

        recyclerView = findViewById(R.id.annList);
        database = FirebaseDatabase.getInstance().getReference("Announcement");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        announcementList = new ArrayList<>();
        //testing
        announcementList.add(new Announcements("subject", "description", "Thursday, November 30, 2023"));


        adapter = new AnnAdapter(this, announcementList);
        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Announcements announcements = dataSnapshot.getValue(Announcements.class);
                    announcementList.add(announcements);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
