package com.example.finalmerge.RetrieveAnn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalmerge.R;
import com.example.finalmerge.homePage.adapters.AnnAdapter;
import com.example.finalmerge.homePage.models.Announcements;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class annlist extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    AnnAdapter adapter;
    ArrayList<Announcements> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annlist);

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