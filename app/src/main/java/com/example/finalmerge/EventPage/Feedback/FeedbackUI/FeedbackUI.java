package com.example.finalmerge.EventPage.Feedback.FeedbackUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.Feedback.FeedbackPage;
import com.example.finalmerge.EventPage.Feedback.PostFeedback;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FeedbackUI extends AppCompatActivity {

    Button viewFeedback, postFeedback, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_feedback);

        //set field
        viewFeedback = findViewById(R.id.ViewFeedback);
        postFeedback = findViewById(R.id.PostFeedback);
        back = findViewById(R.id.back);

        //check userType
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference FeedbackUIDbRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();

        //set Visibility base on userType (0 --> student, 1 --> admin)
        FeedbackUIDbRef.child("RegisterInfo").child(uid).child("userType").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 0 is student, 1 is admin
                int userType = snapshot.getValue(Integer.class);
                if(userType == 0){
                    //student
                    viewFeedback.setVisibility(View.GONE);
                    postFeedback.setVisibility(View.VISIBLE);
                }
                if(userType == 1){
                    //admin
                    viewFeedback.setVisibility(View.VISIBLE);
                    postFeedback.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        viewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FeedbackPage.class);
                startActivity(intent);
                finish();
            }
        });

        postFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostFeedback.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
