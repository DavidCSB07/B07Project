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
    ComplaintAdapter adapter;
    ArrayList<Complaint> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);

        recyclerView=findViewById(R.id.ComplaintsList);
        database= FirebaseDatabase.getInstance().getReference("Complaints");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        list.add(new Complaint("email", "subject", "description"));
        list.add(new Complaint("email", "subject", "description"));
        list.add(new Complaint("email", "subject", "description"));
        adapter=new ComplaintAdapter(this,list);
        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Complaint complaint=dataSnapshot.getValue(Complaint.class);
                    list.add(complaint);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}