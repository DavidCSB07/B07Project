package com.example.finalmerge.EventPage.RSVP;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.R;

public class RSVP extends AppCompatActivity {

    TextView title, description;

    Button join, feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);

        //set field

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        join = findViewById(R.id.join_button);

        title.setText(getIntent().getExtras().getString("title"));
        description.setText(getIntent().getExtras().getString("description"));

    }
}