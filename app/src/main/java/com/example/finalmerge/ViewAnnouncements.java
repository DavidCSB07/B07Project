package com.example.finalmerge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalmerge.homePage.models.Announcements;
import com.google.firebase.database.ChildEventListener;
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
        announcementDbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey){
                //toast notification when a new announcement is added
                Toast.makeText(ViewAnnouncements.this, "A new announcement has been added.",Toast.LENGTH_SHORT).show();

                Announcements announcements = dataSnapshot.getValue(Announcements.class);
                announcementList.add(announcements);
                ListAdapter adapter = new ListAdapter(ViewAnnouncements.this, announcementList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
}