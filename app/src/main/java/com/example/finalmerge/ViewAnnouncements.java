package com.example.finalmerge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.finalmerge.homePage.models.Announcements;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAnnouncements extends AppCompatActivity {
    ListView listView;
    List<Announcements> announcementList;
    DatabaseReference announcementDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_announcements);

        listView = findViewById(R.id.ListView);
        announcementList = new ArrayList<>();
        announcementDbRef = FirebaseDatabase.getInstance().getReference("https://cscb0-13f6b-default-rtdb.firebaseio.com/");
        announcementDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                announcementList.clear();

                for (DataSnapshot announcementDataSnap : dataSnapshot.getChildren()){
                    Announcements announcements = announcementDataSnap.getValue(Announcements.class);
                    announcementList.add(announcements);
                }
                ListAdapter adapter = new ListAdapter(ViewAnnouncements.this, announcementList);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
            }
        });

    }
}