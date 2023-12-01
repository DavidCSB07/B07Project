package com.example.finalmerge.RSVP;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.R;

public class EventDetail extends AppCompatActivity {

    TextView title, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_binding_page);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
    }
}