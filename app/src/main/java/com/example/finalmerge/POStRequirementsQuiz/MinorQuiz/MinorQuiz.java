package com.example.finalmerge.POStRequirementsQuiz.MinorQuiz;

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

public class MinorQuiz extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button answer_A, answer_B;
    Button submit_button;

    int score = 0;
    int totalQuestions = MinorQuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_quiz);

        totalQuestionsTextView = findViewById(R.id.totalQuestions);
        questionTextView = findViewById(R.id.questions);
        answer_A = findViewById(R.id.answerA);
        answer_B = findViewById(R.id.answerB);
        submit_button = findViewById(R.id.buttonSubmit);
        Button home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), POStMenu.class);
                startActivity(intent);
                finish();
            }
        });

        answer_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                currentQuestionIndex++;
                loadNewQuestion();
            }
        });
        answer_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex++;
                loadNewQuestion();
            }
        });

        totalQuestionsTextView.setText(getString(R.string.totalQuestions) + totalQuestions);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        Button clickedButton=(Button) view;

        if(clickedButton.getId()==R.id.buttonSubmit){
            if(selectedAnswer.equals(MinorQuestionAnswer.correctAnswers[currentQuestionIndex])){
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

        questionTextView.setText(MinorQuestionAnswer.question[currentQuestionIndex]);
        answer_A.setText(MinorQuestionAnswer.choices[currentQuestionIndex][0]);
        answer_B.setText(MinorQuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz(){
        String passStatus;
        if(score == totalQuestions){
            passStatus = "You meet the POSt application eligibility requirements for the Minor Program in Computer Science";
        }
        else{
            passStatus = "Sorry, you DO NOT meet the POSt eligibility application requirements for the Minor Program in Computer Science";
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