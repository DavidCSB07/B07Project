package com.example.finalmerge.AnnouncementPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.AnnouncementPage.Adapter.AnnAdapter;
import com.example.finalmerge.AnnouncementPage.Model.Announcements;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
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
    Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_page);

        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.annList);
        database = FirebaseDatabase.getInstance().getReference("Announcement");

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        announcementList = new ArrayList<>();
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
