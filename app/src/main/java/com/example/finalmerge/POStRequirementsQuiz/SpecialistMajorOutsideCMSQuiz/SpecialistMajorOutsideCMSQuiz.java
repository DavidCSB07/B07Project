package com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorOutsideCMSQuiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalmerge.POStRequirementsQuiz.Menu.POStMenu;
import com.example.finalmerge.R;


public class SpecialistMajorOutsideCMSQuiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button answerYes, answerNo;
    Button buttonSubmit;

    int score = 0;
    int totalQuestions = SpecialistMajorOutsideCMSQuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_quiz);

        totalQuestionsTextView = findViewById(R.id.totalQuestions);
        questionTextView = findViewById(R.id.questions);
        answerYes = findViewById(R.id.answerA);
        answerNo = findViewById(R.id.answerB);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        totalQuestionsTextView.setText(getString(R.string.totalQuestions) + totalQuestions);

        loadNewQuestion();

        Button home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), POStMenu.class);
                startActivity(intent);
                finish();
            }
        });

        answerYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                currentQuestionIndex++;
                loadNewQuestion();
            }
        });
        answerNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex++;
                loadNewQuestion();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Button clickedButton=(Button) view;

        if(clickedButton.getId()==R.id.buttonSubmit){
            if(selectedAnswer.equals(SpecialistMajorOutsideCMSQuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }

            currentQuestionIndex++;
            loadNewQuestion();
        }
        else{
            selectedAnswer=clickedButton.getText().toString();
            view.setBackgroundColor(Color.GRAY);
        }

    }

    void loadNewQuestion() {

        if(currentQuestionIndex == totalQuestions){
            finishQuiz();
            return;
        }

        questionTextView.setText(SpecialistMajorOutsideCMSQuestionAnswer.question[currentQuestionIndex]);
        answerYes.setText(SpecialistMajorOutsideCMSQuestionAnswer.choices[currentQuestionIndex][0]);
        answerNo.setText(SpecialistMajorOutsideCMSQuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz(){
        String passStatus;
        if(score == totalQuestions){
            passStatus = "You meet the POSt application eligibility requirements for the Specialist and Major Program in Computer Science";
        }
        else{
            passStatus = "Sorry, you DO NOT meet the POSt application eligibility requirements for the Specialist and Major Program in Computer Science";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

        }

    void restartQuiz(){
        score =  0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}