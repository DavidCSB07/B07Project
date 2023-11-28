package com.example.finalmerge.ComplaintsPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalmerge.ComplaintsPage.Adapter.ComplaintAdapter;
import com.example.finalmerge.ComplaintsPage.Model.Complaint;
import com.example.finalmerge.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewComplaints extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    ComplaintAdapter complaintAdapter;
    ArrayList<Complaint> complaintList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);

        recyclerView = findViewById(R.id.ComplaintsList);
        database = FirebaseDatabase.getInstance().getReference("Complaint");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        complaintList = new ArrayList<>();
        complaintList.add(new Complaint("email", "subject", "description"));
        complaintList.add(new Complaint("email2", "subject2", "description2"));
        complaintList.add(new Complaint("email3", "subject3", "description3"));

        complaintAdapter = new ComplaintAdapter(this, complaintList);
        recyclerView.setAdapter(complaintAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Complaint complaint = dataSnapshot.getValue(Complaint.class);
                    complaintList.add(complaint);
                }
                complaintAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}