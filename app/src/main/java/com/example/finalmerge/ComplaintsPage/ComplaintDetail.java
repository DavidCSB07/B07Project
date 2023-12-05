package com.example.finalmerge.ComplaintsPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.R;

public class ComplaintDetail extends AppCompatActivity {
    TextView contentSubject, contentEmail, contentComplaint;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints_binding_page);

        contentSubject = findViewById(R.id.contentSubject);
        contentComplaint = findViewById(R.id.contentComplaint);
        contentEmail = findViewById(R.id.contentEmail);
        back = findViewById(R.id.back_button);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            contentSubject.setText(getIntent().getExtras().getString("contentSubject"));
            contentComplaint.setText(getIntent().getExtras().getString("contentComplaint"));
            contentEmail.setText(getIntent().getExtras().getString("contentEmail"));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComplaintPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
