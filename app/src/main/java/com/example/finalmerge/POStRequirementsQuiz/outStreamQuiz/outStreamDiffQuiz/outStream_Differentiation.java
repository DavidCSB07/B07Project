package com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStreamDiffQuiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_QuestionAnswer;
import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_CS.outStream_CS_diffQuiz.outStreamCSdiffQuiz;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_CS.outStream_CS_diffQuiz.outStreamCSdiffQuiz_QuestionAnswer;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_Math.outStream_Math;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_Stats.outStream_Stats;
import com.example.finalmerge.R;

public class outStream_Differentiation extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_CS,ans_Math,ans_Stats;
    Button submitBtn;

    int totalQuestion = outStream_Differentiation_QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_differentiation);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.stream_diff_question);
        ans_CS = findViewById(R.id.ans_CS);
        ans_Math = findViewById(R.id.ans_Math);
        ans_Stats = findViewById(R.id.ans_Stats);
        submitBtn = findViewById(R.id.submit_btn);

        ans_CS.setOnClickListener(this);
        ans_Math.setOnClickListener(this);
        ans_Stats.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("OutStream");
    }

    @Override
    public void onClick(View view) {

//        ans_A.setBackgroundColor(Color.WHITE);
//        ans_B.setBackgroundColor(Color.WHITE);
        ans_CS.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_Math.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_Stats.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            System.out.println("SUBMIT BUTTON DETECTED!");
            if(selectedAnswer.equals(outStream_Differentiation_QuestionAnswer.choices[0][0])){
                System.out.println("OutStream CS Submit!");
                finishQuiz_to_outStream_CS();
                return;
            }
            if(selectedAnswer.equals(outStream_Differentiation_QuestionAnswer.choices[0][1])){
                System.out.println("OutStream Math Submit!");
                finishQuiz_to_outStream_Math();
                return;
            }
            if(selectedAnswer.equals(outStream_Differentiation_QuestionAnswer.choices[0][2])){
                System.out.println("OutStream Stats Submit!");
                finishQuiz_to_outStream_Stats();
                return;
            }

        }else{
            //if user hits choices
            System.out.println("NON SUBMIT BUTTON DETECTED!");
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));

        }
    }

    void finishQuiz_to_outStream_CS(){
        Intent intent = new Intent(outStream_Differentiation.this, outStreamCSdiffQuiz.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_outStream_Math(){
        Intent intent = new Intent(outStream_Differentiation.this, outStream_Math.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_outStream_Stats(){
        Intent intent = new Intent(outStream_Differentiation.this, outStream_Stats.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(outStream_Differentiation.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);

        finish();

    }
    void homePage(){
        ////// foo place holder function
        ////// foo place holder function
        ////// foo place holder function
        ////// change to Home Page
        ////// foo place holder function
        ////// foo place holder function
        ////// foo place holder function
        ////// change to Home Page
        currentQuestionIndex=0;
        Intent returnPostMenu = new Intent(outStream_Differentiation.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);
//        Intent returnHome = new Intent(getApplicationContext(), homePage.class);
//        startActivity((returnHome));

        finish();
    }
}