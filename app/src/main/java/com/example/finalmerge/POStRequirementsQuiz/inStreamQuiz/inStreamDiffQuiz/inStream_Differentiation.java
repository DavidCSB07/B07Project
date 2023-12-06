package com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStreamDiffQuiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStream_CS.inStream_CS_diffQuiz.inStreamCSdiffQuiz;
import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStream_Stats.inStream_Stats;
import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStream_Math.inStream_Math;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

public class inStream_Differentiation extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_CS,ans_Math,ans_Stats;
    Button submitBtn;
    Button back_btn;
    Button home_btn;

    int totalQuestion = inStream_Differentiation_QuestionAnswer.question.length;
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
        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        ans_CS.setOnClickListener(this);
        ans_Math.setOnClickListener(this);
        ans_Stats.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        questionTextView.setText("Which stream are you applying for?");
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

        if (clickedButton.getId() == R.id.submit_btn) {
            System.out.println("SUBMIT BUTTON DETECTED!");
            if (selectedAnswer.equals(inStream_Differentiation_QuestionAnswer.choices[currentQuestionIndex][0])) {
                System.out.println("OutStream CS Submit!");
                finishQuiz_to_outStream_CS();
                return;
            } else if (selectedAnswer.equals(inStream_Differentiation_QuestionAnswer.choices[currentQuestionIndex][1])) {
                System.out.println("OutStream Math Submit!");
                finishQuiz_to_outStream_Math();
                return;
            } else if (selectedAnswer.equals(inStream_Differentiation_QuestionAnswer.choices[currentQuestionIndex][2])) {
                System.out.println("OutStream Stats Submit!");
                finishQuiz_to_outStream_Stats();
                return;
            } else {
                System.out.println("No matching condition for selectedAnswer: " + selectedAnswer);
            }
        }else if (clickedButton.getId() == R.id.back_btn) {
            System.out.println("Back BUTTON DETECTED!");
            finishQuiz_back();
            return;
        }else if(clickedButton.getId()==R.id.home_btn){
            System.out.println("Home BUTTON DETECTED!");
            finishQuiz_home();
            return;
        } else {
            //if user hits choices
            System.out.println("NON SUBMIT BUTTON DETECTED!");
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));
        }
    }

    void finishQuiz_to_outStream_CS () {
        Intent intent = new Intent(inStream_Differentiation.this, inStreamCSdiffQuiz.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_outStream_Math () {
        Intent intent = new Intent(inStream_Differentiation.this, inStream_Math.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_outStream_Stats () {
        Intent intent = new Intent(inStream_Differentiation.this, inStream_Stats.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void restartQuiz () {
        currentQuestionIndex = 0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(inStream_Differentiation.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);

        finish();

    }
    void finishQuiz_home(){
        currentQuestionIndex=0;
        Intent returnHome = new Intent(inStream_Differentiation.this, homePage.class);
        startActivity((returnHome));
        finish();
    }
    void finishQuiz_back () {
        Intent returnPostMenu = new Intent(inStream_Differentiation.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);

        finish();
    }
}