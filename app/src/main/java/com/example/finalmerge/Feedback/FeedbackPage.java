package com.example.finalmerge.Feedback;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.R;

public class FeedbackPage extends AppCompatActivity {

    TextView rating;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_review);
    }
}