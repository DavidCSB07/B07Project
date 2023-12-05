package com.example.finalmerge.Feedback.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.EventPage.RSVP;
import com.example.finalmerge.Feedback.FeedbackPage;
import com.example.finalmerge.R;

public class feedback_ui extends AppCompatActivity {

    Button viewFeedback, rsvp, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_feedback);


        viewFeedback = findViewById(R.id.ViewFeedback);
        rsvp = findViewById(R.id.RSVP);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventPage.class);
                startActivity(intent);
                finish();
            }
        });

        viewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FeedbackPage.class);
                intent.putExtra("refKey", getIntent().getExtras().getString("refKey"));
                startActivity(intent);
                finish();
            }
        });

        rsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RSVP.class);
                intent.putExtra("title", getIntent().getExtras().getString("title"));
                intent.putExtra("description", getIntent().getExtras().getString("description"));
                intent.putExtra("refKey", getIntent().getExtras().getString("refKey"));

                startActivity(intent);
                finish();
            }
        });
    }
}