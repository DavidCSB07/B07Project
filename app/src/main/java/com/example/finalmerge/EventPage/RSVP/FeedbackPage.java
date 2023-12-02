package com.example.finalmerge.EventPage.RSVP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.EventPage.EventPage;
import com.example.finalmerge.R;
import com.google.android.material.textfield.TextInputEditText;

public class FeedbackPage extends AppCompatActivity {

    TextView title, date;
    TextInputEditText numericFeedback, shortFeedback;
    Button submit, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_page);

        title = findViewById(R.id.title);
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

    }
}