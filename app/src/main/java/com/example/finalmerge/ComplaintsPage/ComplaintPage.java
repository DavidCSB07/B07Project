package com.example.finalmerge.ComplaintsPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.ComplaintsPage.Adapter.ComplaintAdapter;
import com.example.finalmerge.ComplaintsPage.Model.Complaint;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComplaintPage extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    ComplaintAdapter complaintAdapter;
    ArrayList<Complaint> complaintList;
    Button home_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints_page);

        home_btn  = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homePage.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.ComplaintsList);
        database = FirebaseDatabase.getInstance().getReference("Complaint");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        complaintList = new ArrayList<>();


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