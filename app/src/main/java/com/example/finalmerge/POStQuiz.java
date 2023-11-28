package com.example.finalmerge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;


public class POStQuiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button answer_A, answer_B;
    Button submit_button;

    int score = 0;
    int totalQuestions = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_quiz);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.questions);
        answer_A = findViewById(R.id.answer_A);
        answer_B = findViewById(R.id.answer_B);
        submit_button = findViewById(R.id.submit_button);

        answer_A.setOnClickListener(this);
        answer_B.setOnClickListener(this);
        submit_button.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions: " + totalQuestions);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        Button clickedButton=(Button) view;

        if(clickedButton.getId()==R.id.submit_button){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
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

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        answer_A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        answer_B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score == totalQuestions){
            passStatus = "You meet the POSt requirements for the specialist and major program in Computer Science";
        }
        else{
            passStatus = "Sorry, you DO NOT meet the POSt requirements for the specialist and major program in Computer Science";
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