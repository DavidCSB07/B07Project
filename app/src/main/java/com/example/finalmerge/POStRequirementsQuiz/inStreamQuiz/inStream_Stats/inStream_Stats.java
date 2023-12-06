package com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStream_Stats;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.finalmerge.POStRequirementsQuiz.GeneralQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStreamDiffQuiz.inStream_Differentiation;
import com.example.finalmerge.POStRequirementsQuiz.inStreamQuiz.inStream_Math.inStream_Math_QuestionAnswer;
import com.example.finalmerge.POStRequirementsQuiz.outStreamQuiz.outStream_Stats.outStream_Stats_QuestionAnswer;
import com.example.finalmerge.R;
import com.example.finalmerge.homePage.homePage;

public class inStream_Stats extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B;
    Button submitBtn;
    Button back_btn;

    int totalQuestion = outStream_Stats_QuestionAnswer.question.length;
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

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        back_btn.setOnClickListener(this);

        questionTextView.setText(outStream_Stats_QuestionAnswer.question[0]);
        totalQuestionsTextView.setText("OutStream > Math");

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ans_A.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        ans_B.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            System.out.println("SUBMIT BUTTON DETECTED!");
            if(!selectedAnswer.equals(inStream_Math_QuestionAnswer.correctAnswers[currentQuestionIndex])){
                finishQuiz_fail();
                return;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < inStream_Math_QuestionAnswer.question.length) {
                loadNewQuestion();
            }
            else {
                System.out.println("SUCCESSFUL SUBMISSION!???!");
                finishQuiz_Success();
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
//            clickedButton.setBackgroundColor(Color.BLUE);
//            clickedButton.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
            clickedButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.teal_200)));

        }
    }


    void loadNewQuestion(){

        questionTextView.setText(inStream_Math_QuestionAnswer.question[currentQuestionIndex]);
        ans_A.setText(inStream_Math_QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(inStream_Math_QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz_fail(){
        String passStatus = "Sorry";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Based on your answer, you do not meet the requirements for the restricted program.")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Home", (dialogInterface, i) -> finishQuiz_home())
                .setCancelable(false)
                .show();
    }

    void finishQuiz_Success(){
        String passStatus = "Congratulations";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("You meet the requirements to apply for the restricted program.")
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Home", (dialogInterface, i) -> finishQuiz_home())
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        currentQuestionIndex=0;
//        loadNewQuestion();
        Intent returnPostMenu = new Intent(inStream_Stats.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);

        finish();

    }
    void finishQuiz_home(){
        currentQuestionIndex=0;
        Intent returnHome = new Intent(inStream_Stats.this, homePage.class);
        startActivity((returnHome));
        finish();
    }
    void finishQuiz_back(){
        Intent returnPostMenu = new Intent(inStream_Stats.this, inStream_Differentiation.class);
        startActivity(returnPostMenu);

        finish();
    }
}