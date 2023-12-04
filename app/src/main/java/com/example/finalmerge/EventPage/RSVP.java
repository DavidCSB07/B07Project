package com.example.finalmerge.EventPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.Feedback.PostFeedback;
import com.example.finalmerge.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RSVP extends AppCompatActivity {

    TextView title, description;

    Button join, feedback, back;

    Boolean check_join_btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_rsvp);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();

        //set field

        check_join_btn = false;
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        join = findViewById(R.id.join_button);
        feedback = findViewById(R.id.feedback_button);
        back = findViewById(R.id.back);
        feedback.setVisibility(View.GONE);

        title.setText(getIntent().getExtras().getString("title"));
        description.setText(getIntent().getExtras().getString("description"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_join_btn == false){
                    join.setText("Joined");
                    feedback.setVisibility(View.VISIBLE);
                    check_join_btn = true;
                }
                else{
                    join.setText("Join");
                    feedback.setVisibility(View.GONE);
                    check_join_btn = false;
                }

            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostFeedback.class);
                intent.putExtra("refKey", getIntent().getExtras().getString("refKey"));
                startActivity(intent);
                finish();
            }
        });

    }
}