package com.example.finalmerge.ComplaintsStudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalmerge.R;

// firebase
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Complaints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);

        showComplaintsForm();
    }

    private void showComplaintsForm() {
        return;
    }

    }