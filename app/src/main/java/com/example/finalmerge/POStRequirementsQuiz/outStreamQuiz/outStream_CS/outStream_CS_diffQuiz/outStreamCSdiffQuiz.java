package com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_CS.outStream_CS_diffQuiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStreamDiffQuiz.outStream_Differentiation;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_CS.outStream_CS_minor.outStreamCSminorQuiz;
import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_CS.outStream_CS_SpecMajor.outStreamCSspecMajorQuiz;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

public class outStreamCSdiffQuiz extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B;
    Button submitBtn;
    Button back_btn;
    Button home_btn;
    int totalQuestion = outStreamCSdiffQuiz_QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_menu_back_btn);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        submitBtn = findViewById(R.id.submit_btn);
        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        questionTextView.setText(outStreamCSdiffQuiz_QuestionAnswer.question[0]);
        totalQuestionsTextView.setText("OutStream > CS");

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ans_A.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_B.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            System.out.println("SUBMIT BUTTON DETECTED!");
            if(selectedAnswer.equals(outStreamCSdiffQuiz_QuestionAnswer.choices[currentQuestionIndex][0])){
                finishQuiz_to_CS_minor();
                return;
            }
            if(selectedAnswer.equals(outStreamCSdiffQuiz_QuestionAnswer.choices[currentQuestionIndex][1])){
                finishQuiz_to_CS_SpecMajor();
                return;
            }
        }else if(clickedButton.getId()==R.id.back_btn){
            System.out.println("Back BUTTON DETECTED!");
            finishQuiz_back();
            return;
        }else if(clickedButton.getId()==R.id.home_btn){
            System.out.println("Home BUTTON DETECTED!");
            finishQuiz_home();
            return;
        }else{
            //if user hits choices
            System.out.println("NON SUBMIT BUTTON DETECTED!");
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));

        }
    }


    void loadNewQuestion(){

        questionTextView.setText(outStreamCSdiffQuiz_QuestionAnswer.question[currentQuestionIndex]);
        ans_A.setText(outStreamCSdiffQuiz_QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(outStreamCSdiffQuiz_QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz_to_CS_minor(){
        Intent intent = new Intent(outStreamCSdiffQuiz.this, outStreamCSminorQuiz.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_CS_SpecMajor(){
        Intent intent = new Intent(outStreamCSdiffQuiz.this, outStreamCSspecMajorQuiz.class);

//         Start the new activity
        startActivity(intent);
        finish();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(outStreamCSdiffQuiz.this, outStreamCSspecMajorQuiz.class);
        startActivity(returnPostMenu);

        finish();

    }
    void finishQuiz_home(){
        currentQuestionIndex=0;
        Intent returnHome = new Intent(outStreamCSdiffQuiz.this, homePage.class);
        startActivity((returnHome));
        finish();
    }
    void finishQuiz_back(){
        Intent returnPostMenu = new Intent(outStreamCSdiffQuiz.this, outStream_Differentiation.class);
        startActivity(returnPostMenu);

        finish();
    }
}