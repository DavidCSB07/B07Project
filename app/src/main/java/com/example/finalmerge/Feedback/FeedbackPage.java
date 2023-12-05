package com.example.finalmerge.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.Feedback.Adapter.FeedbackAdapter;
import com.example.finalmerge.Feedback.Model.FeedBack;
import com.example.finalmerge.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedbackPage extends AppCompatActivity {

    RecyclerView recyclerview;
    FeedbackAdapter feedbackAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<FeedBack> feedbackList;
    TextView AverageRating;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);

        back = findViewById(R.id.back);
        AverageRating = findViewById(R.id.AverageRating);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("ScheduleEvent")
                .child(getIntent().getExtras().getString("refKey"))
                .child("FeedBack");
        feedbackList = new ArrayList<>();
        feedbackAdapter = new FeedbackAdapter(this, feedbackList);
        //feedbackList.add(new FeedBack("Rated: 10", "SOME COMMENT", "DAvid"));

        recyclerview = findViewById(R.id.FeedbackList);
        recyclerview.setHasFixedSize(true);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(feedbackAdapter);
        ArrayList<Integer> IntegerList = new ArrayList<Integer>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FeedBack feedback = dataSnapshot.getValue(FeedBack.class);
                    feedbackList.add(feedback);
                    Toast.makeText(getApplicationContext(), feedback.getNumFeedback(), Toast.LENGTH_SHORT).show();
                    IntegerList.add(Integer.parseInt(feedback.getNumFeedback()));
                }
                feedbackAdapter.notifyDataSetChanged();
                double average = computeAverge(IntegerList);
                AverageRating.setText("The Average Rating is:   " + average);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    private double computeAverge(ArrayList<Integer> integerList) {

        if (integerList.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : integerList) {
            sum += num;
        }
        // Calculate the average
        return (double) sum / integerList.size();
    }
}