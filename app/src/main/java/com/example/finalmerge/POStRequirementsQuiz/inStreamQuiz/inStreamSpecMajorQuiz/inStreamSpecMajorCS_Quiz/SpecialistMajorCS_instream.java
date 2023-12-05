package com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStreamSpecMajorQuiz.inStreamSpecMajorCS_Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.finalmerge.POStRequirementsQuiz.Menu.POStMenu;
import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.R;

public class SpecialistMajorCS_instream extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B;
    Button submitBtn;

    int totalQuestion = SpecialistMajorCMS_instream_QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist_major_cs_instream);

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

//        ans_A.setBackgroundColor(Color.WHITE);
//        ans_B.setBackgroundColor(Color.WHITE);
        ans_A.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_B.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            System.out.println("SUBMIT BUTTON DETECTED!");
            if(!selectedAnswer.equals(SpecialistMajorCMS_instream_QuestionAnswer.correctAnswers[currentQuestionIndex])){
                finishQuiz_fail();
                return;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < SpecialistMajorCMS_instream_QuestionAnswer.question.length) {
                loadNewQuestion();
            }
            else {
                System.out.println("SUCCESSFUL SUBMISSION!???!");
                finishQuiz_Success();
            }

        }else{
            //if user hits choices
            System.out.println("NON SUBMIT BUTTON DETECTED!");
            selectedAnswer = clickedButton.getText().toString();
//            clickedButton.setBackgroundColor(Color.BLUE);
//            clickedButton.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));

        }
    }


    void loadNewQuestion(){

        questionTextView.setText(SpecialistMajorCMS_instream_QuestionAnswer.question[currentQuestionIndex]);
        ans_A.setText(SpecialistMajorCMS_instream_QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(SpecialistMajorCMS_instream_QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz_fail(){
        String passStatus = "Sorry";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Based on your answer, you do not meet the requirements for the restricted program.")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Home", (dialogInterface, i) -> homePage())
                .setCancelable(false)
                .show();
    }

    void finishQuiz_Success(){
        String passStatus = "Congratulations";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Based on your answer, you meet the requirements for the restricted program.")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Home", (dialogInterface, i) -> homePage())
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(SpecialistMajorCS_instream.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);

        finish();

    }
    void homePage(){

        ////// foo place holder function
        currentQuestionIndex=0;
        Intent returnPostMenu = new Intent(SpecialistMajorCS_instream.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);
//        Intent returnHome = new Intent(getApplicationContext(), homePage.class);
//        startActivity((returnHome));

        finish();
    }
}