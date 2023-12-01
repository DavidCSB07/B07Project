package com.example.finalmerge.AnnouncementPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.AnnouncementPage.Holder.AnnouncementViewHolder;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;

public class AnnouncementDetail extends AppCompatActivity {
    TextInputEditText annSubject, annDes;
    TextView annDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_binding_page);

        annSubject = findViewById(R.id.annSubject);
        annDes = findViewById(R.id.annDes);
        annDate = findViewById(R.id.annDate);

        annSubject.setText(getIntent().getStringExtra("annSubject"));
        annDate.setText(getIntent().getStringExtra("annDate"));
        annDes.setText(getIntent().getStringExtra("annDes"));
    }

}
