package com.example.finalmerge.POStRequirementsQuiz.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalmerge.MainActivity;
import com.example.finalmerge.POStRequirementsQuiz.MinorQuiz.MinorQuiz;
import com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorMathStatsQuiz.SpecialistMajorMathStatsQuiz;
import com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorOutsideCMSQuiz.SpecialistMajorOutsideCMSQuiz;
import com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorCSQuiz.SpecialistMajorQuiz;
import com.example.finalmerge.R;

public class POStMenu extends AppCompatActivity {

    private Button buttonSpecialistMajorCS;
    private Button buttonSpecialistMajorMathStats;
    private Button buttonSpecialistMajorOutsideCMS;
    private Button buttonMinor;
    private Button buttonHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_menu);

        buttonSpecialistMajorCS=findViewById(R.id.buttonSpecialistMajorCS);
        buttonSpecialistMajorMathStats=findViewById(R.id.buttonSpecialistMajorMathStats);
        buttonSpecialistMajorOutsideCMS=findViewById(R.id.buttonSpecialistMajorOutsideCMS);
        buttonHome=findViewById(R.id.buttonHome);

        buttonMinor=findViewById(R.id.buttonMinor);

        buttonSpecialistMajorCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSpecMajorCSQuiz=new Intent(POStMenu.this, SpecialistMajorQuiz.class);
                startActivity(viewSpecMajorCSQuiz);
            }
        });

        buttonSpecialistMajorMathStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSpecMajorMathStatsQuiz=new Intent(POStMenu.this, SpecialistMajorMathStatsQuiz.class);
                startActivity(viewSpecMajorMathStatsQuiz);
            }
        });

        buttonSpecialistMajorOutsideCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSpecMajorOutsideCMSQuiz=new Intent(POStMenu.this, SpecialistMajorOutsideCMSQuiz.class);
                startActivity(viewSpecMajorOutsideCMSQuiz);
            }
        });

        buttonMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMinorQuiz=new Intent(POStMenu.this, MinorQuiz.class);
                startActivity(viewMinorQuiz);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHome=new Intent(POStMenu.this, MainActivity.class);
                startActivity(returnHome);
            }
        });
    }
}