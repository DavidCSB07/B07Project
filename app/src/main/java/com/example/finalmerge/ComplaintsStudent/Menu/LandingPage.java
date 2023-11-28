package com.example.finalmerge.ComplaintsStudent.Menu;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.ComplaintsStudent.ComplaintsForm;
import com.example.finalmerge.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        button = findViewById(R.id.buttonSubmitFeedback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LandingPage.this, ComplaintsForm.class);
                startActivity(intent);
            }
        });
    }
}