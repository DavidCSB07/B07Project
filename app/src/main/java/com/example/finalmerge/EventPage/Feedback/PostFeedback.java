package com.example.finalmerge.EventPage.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.Feedback.Model.FeedBack;
import com.example.finalmerge.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostFeedback extends AppCompatActivity {
    TextInputEditText numericFeedback, shortFeedback;
    Button submit, back;

    DatabaseReference feedbackDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_post);

        numericFeedback = findViewById(R.id.numericFeedback);
        shortFeedback = findViewById(R.id.shortFeedback);

        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shortFb = shortFeedback.getText().toString();
                int numericFb = Integer.parseInt(numericFeedback.getText().toString());

                //check if is empty
                if(TextUtils.isEmpty(shortFb)){
                    Toast.makeText(PostFeedback.this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(numericFb < 0 || numericFb > 10 ){
                    Toast.makeText(PostFeedback.this, "Rating has to be between 1-10", Toast.LENGTH_SHORT).show();
                    return;
                }
                    FeedBack feedback = new FeedBack(numericFb, shortFb);
                    addFeedback(feedback);
            }
        });

    }

    private void addFeedback(FeedBack feedback) {
        feedbackDbRef = FirebaseDatabase.getInstance().getReference().child("ScheduleEvent").child(getIntent().getExtras().getString("refKey")).child("FeedBack");
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("ScheduleEvent").child(getIntent().getExtras().getString("refKey")).child("FeedBack").push();
        feedback.setRefKey(myRef.getKey());
        // add post data to firebase database
        feedbackDbRef.push().setValue(feedback).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(PostFeedback.this, "data inserted", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostFeedback.this, "data not inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}