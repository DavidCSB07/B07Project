package com.example.finalmerge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B;
    Button submitBtn;

    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        submitBtn = findViewById(R.id.submit_btn);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions :"+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ans_A.setBackgroundColor(Color.WHITE);
        ans_B.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            if(!selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                finishQuiz_fail();
                return;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else{
            //if user hits choices
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }
    }


    void loadNewQuestion(){

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ans_A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz_fail(){
        String passStatus = "Sorry";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Based on your answer, you do not meet the requirements for the restricted program.")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
        loadNewQuestion();
    }
}