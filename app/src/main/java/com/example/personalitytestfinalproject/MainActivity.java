package com.example.personalitytestfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView mQuetions;
    private TextView mChoices;
    private Button mChoiceTwo;
    private Button mChoiceOne;
    private Button mIDontKnowButton;
    private Button mQuitButton;
    private int quetionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChoiceTwo = (Button) findViewById(R.id.choice_two);
        mChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop("Interesting!");
                if (v.getId() == R.id.choice_one){
                    QuestionBank.updateQuestion(1, true);
                }
                else if (v.getId() == R.id.choice_two){
                    QuestionBank.updateQuestion(1, false);
                }
                if (quetionNum == 15) {
                    mQuetions.setText("");
                    //instead of "" put score
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
                }
                else {
                    quetionNum++;
                    mQuetions.setText(QuestionBank.mQuetions[quetionNum]);
                    mChoiceOne.setText(QuestionBank.mChoices[quetionNum][0]);
                    mChoiceTwo.setText(QuestionBank.mChoices[quetionNum][1]);
                }
            }
        });

        mChoiceOne = (Button) findViewById(R.id.choice_one);
        mChoiceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("So you are one of those people!");
                if (v.getId() == R.id.choice_one){
                    QuestionBank.updateQuestion(1, true);
                }
                else if (v.getId() == R.id.choice_two){
                    QuestionBank.updateQuestion(1, false);
                }
                if (quetionNum == 15) {
                    mQuetions.setText("");
                    //instead of "" put score
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
                }
                else {
                    quetionNum++;
                    mQuetions.setText(QuestionBank.mQuetions[quetionNum]);
                    mChoiceOne.setText(QuestionBank.mChoices[quetionNum][0]);
                    mChoiceTwo.setText(QuestionBank.mChoices[quetionNum][1]);
                }
            }
        });
        mIDontKnowButton = (Button) findViewById(R.id.i_dont_know_button);
        mIDontKnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("WHY CANT YOU DECIDE!");
                if (quetionNum == 15) {
                    mQuetions.setText("");
                    //instead of "" put score
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
                }
                else {
                    quetionNum++;
                    mQuetions.setText(QuestionBank.mQuetions[quetionNum]);
                    mChoiceOne.setText(QuestionBank.mChoices[quetionNum][0]);
                    mChoiceTwo.setText(QuestionBank.mChoices[quetionNum][1]);
                }
            }
        });
        mQuitButton = (Button) findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("LAME");
            }
        });
        mQuetions = (TextView)findViewById(R.id.question_text_view);
        mQuetions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    public void makeTop(String toastDisplay){
        Toast toast = Toast.makeText(MainActivity.this, toastDisplay, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }



}