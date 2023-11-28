package com.example.finalmerge.ComplaintsAdmin.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalmerge.ComplaintsAdmin.ViewComplaints;
import com.example.finalmerge.R;

public class LandingPage extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        button=findViewById(R.id.buttonViewFeedback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewFeedback=new Intent(LandingPage.this, ViewComplaints.class);
                startActivity(viewFeedback);
            }
        });
    }
}