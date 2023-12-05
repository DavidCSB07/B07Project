package com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.finalmerge.POStRequirementsQuiz.Menu.POStMenu;
import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStreamDiffQuiz.inStream_Differentiation;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStreamDiffQuiz.outStream_Differentiation;
import com.example.finalmerge.R;

public class POStMenu_ver2 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B;
    Button submitBtn;

    int totalQuestion = POStMenu_QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_menu);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        submitBtn = findViewById(R.id.submit_btn);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("POSt Check Quiz");
    }

    @Override
    public void onClick(View view) {

//        ans_A.setBackgroundColor(Color.WHITE);
//        ans_B.setBackgroundColor(Color.WHITE);
        ans_A.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_B.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            System.out.println("SUBMIT BUTTON DETECTED!");
            if(!selectedAnswer.equals(POStMenu_QuestionAnswer.correctAnswers[currentQuestionIndex])){
                System.out.println("OutStream Submit!");
                finishQuiz_to_outStream();
                return;
            }
            else {
                System.out.println("InStream Submit!");
                finishQuiz_to_inStream();
                return;
            }

        }else{
            //if user hits choices
            System.out.println("NON SUBMIT BUTTON DETECTED!");
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));

        }
    }

    void finishQuiz_to_outStream(){
        Intent intent = new Intent(POStMenu_ver2.this, outStream_Differentiation.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_inStream(){
        Intent intent = new Intent(POStMenu_ver2.this, inStream_Differentiation.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(POStMenu_ver2.this, POStMenu_ver2.class);
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
        Intent returnPostMenu = new Intent(POStMenu_ver2.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);
//        Intent returnHome = new Intent(getApplicationContext(), homePage.class);
//        startActivity((returnHome));

        finish();
    }
}