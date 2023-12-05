package com.example.finalmerge.POStRequirementsQuiz.Menu;

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
import com.example.finalmerge.POStRequirementsQuiz.Menu.POStMenu_ver2;
import com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorCSQuiz.SpecialistMajorCMS_instream_QuestionAnswer;
import com.example.finalmerge.POStRequirementsQuiz.SpecialistMajorCSQuiz.SpecialistMajorCS_instream;
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
        questionTextView = findViewById(R.id.CMSquestion);
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
            if(!selectedAnswer.equals(POStMenu_QuestionAnswer.correctAnswers[currentQuestionIndex])){
                finishQuiz_to_outStream();
                return;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < POStMenu_QuestionAnswer.question.length) {
                loadNewQuestion();
            }
            else {
                System.out.println("SUCCESSFUL SUBMISSION!???!");
                finishQuiz_to_inStream();
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

        questionTextView.setText(POStMenu_QuestionAnswer.question[currentQuestionIndex]);
        ans_A.setText(POStMenu_QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(POStMenu_QuestionAnswer.choices[currentQuestionIndex][1]);
    }

    void finishQuiz_to_outStream(){
        Intent intent = new Intent(POStMenu_ver2.this, outStreamQuiz.class);

        // Start the new activity
        startActivity(intent);
        finish();
    }

    void finishQuiz_to_inStream(){
        Intent intent = new Intent(POStMenu_ver2.this, inStreamQuiz.class);

        // Start the new activity
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
        currentQuestionIndex=0;
        Intent returnPostMenu = new Intent(POStMenu_ver2.this, POStMenu_ver2.class);
        startActivity(returnPostMenu);
//        Intent returnHome = new Intent(getApplicationContext(), homePage.class);
//        startActivity((returnHome));

        finish();
    }
}