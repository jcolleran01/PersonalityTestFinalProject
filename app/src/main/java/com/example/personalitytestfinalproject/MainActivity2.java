package com.example.personalitytestfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private TextView mQuetions;
    private Button mChoiceTwo;
    private Button mChoiceOne;
    private Button mIDontKnowButton;
    private Button mQuitButton;
    private int quetionNum = 0;
    double[] answerA = new double[4];
    double[] answerB = new double[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mChoiceTwo = (Button) findViewById(R.id.choice_two);
        mChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop("Interesting!");
                QuestionBank.updateQuestion(answerA,answerB, quetionNum, false);
                System.out.println("b");

                if (quetionNum == 15) {
                    mQuetions.setText("Your Super hero is:");
                    mChoiceOne.setText(finalPersonality(answerA, answerB));
                    mChoiceTwo.setText("Have fun fighting crime!");
                } else {
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
                makeTop("So you are one of those people!");
                QuestionBank.updateQuestion(answerA,answerB,quetionNum, true);
                System.out.println("a");

                if (quetionNum == 15) {
                    mQuetions.setText("Your Super hero is:");
                    mChoiceOne.setText(finalPersonality(answerA, answerB));
                    mChoiceTwo.setText("Have fun fighting crime!");
                    mIDontKnowButton.setText("Thank You For Playing");
                } else {
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
                makeTop("WHY CANT YOU DECIDE!");
                if (quetionNum == 15) {
                    mQuetions.setText("Your Super hero is:");
                    mChoiceOne.setText(finalPersonality(answerA, answerB));
                    mChoiceTwo.setText("Have fun fighting crime!");
                    mIDontKnowButton.setText("Thank You For Playing");
                } else {
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
                makeTop("LAME");
                openActivity1();
            }
        });
        mQuetions = (TextView) findViewById(R.id.question_text_view);
        mQuetions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
    public void openActivity1(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void makeTop(String toastDisplay) {
        Toast toast = Toast.makeText(MainActivity2.this, toastDisplay, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }

    public static String finalPersonality(double answerA[], double answerB[]) {
        double[] percentAB = new double[4];
        int[] percentRounded = new int[4];
        String[] letters = new String[4];
        String[] lettersESTJ = {"E", "S", "T", "J"};
        String[] lettersINFP = {"I", "N", "F", "P"};

        for (int i = 0; i < answerA.length; i++) {
            percentAB[i] = (answerB[i] / (answerA[i] + answerB[i])) * 100.0;
            percentRounded[i] = (int) Math.round(percentAB[i]);
            if (percentRounded[i] == 50) {
                letters[i] = "X";
            } else if (percentRounded[i] < 50) {
                letters[i] = lettersESTJ[i];
            } else if (percentRounded[i] > 50) {
                letters[i] = lettersINFP[i];
            }
        }
        String str = "";
        for (int i = 0; i < letters.length; i++){
            str += letters[i];
        }

        if (str.equals("ESTJ")) {
            return "Hulk";
        } else if (str.equals("ESTP")) {
            return "Superman";
        } else if (str.equals("ESFP")) {
            return "Wonder Man";
        } else if (str.equals("ESFJ")) {
            return "Iron Man";
        } else if (str.equals("ENTJ")) {
            return "Star Fire";
        } else if (str.equals("ENTP")) {
            return "Spider man";
        } else if (str.equals("ENFP")) {
            return "Captain America";
        } else if (str.equals("ENFJ")) {
            return "Nick Fury";
        } else if (str.equals("ISTJ")) {
            return "Wanda";
        } else if (str.equals("ISTP")) {
            return "Beast boy";
        } else if (str.equals("ISFP")) {
            return "Batman";
        } else if (str.equals("ISFJ")) {
            return "Star-Lord";
        } else if (str.equals("INTJ")) {
            return "Shazam";
        } else if (str.equals("INTP")) {
            return "Flash";
        } else if (str.equals("INFP")) {
            return "Robin (Teen Titans Go)";
        } else if (str.equals("INFJ")) {
            return "Antman";
        } else if (str.equals("XSTJ")) {
            return "She-Hulk";
        } else if (str.equals("XSTP")) {
            return "Vision";
        } else if (str.equals("XSFP")) {
            return "Captain America";
        } else if (str.equals("XSFJ")) {
            return "Iron man";
        } else if (str.equals("XNTJ")) {
            return "Star Fire";
        } else if (str.equals("XNTP")) {
            return "Warlock";
        } else if (str.equals("XNFP")) {
            return "Flash";
        } else if (str.equals("XNFJ")) {
            return "Rocket Racoon";
        } else if (str.equals("EXTJ")) {
            return "Beast boy";
        } else if (str.equals("EXTP")) {
            return "Raven";
        } else if (str.equals("EXFP")) {
            return "Falcon";
        } else if (str.equals("EXFJ")) {
            return "Hawk eye";
        } else if (str.equals("IXTJ")) {
            return "super boy";
        } else if (str.equals("IXTP")) {
            return "Wanda";
        } else if (str.equals("IXFP")) {
            return "Captain America";
        } else if (str.equals("IXFJ")) {
            return "Robin";
        } else if (str.equals("ESXJ")) {
            return "Cosmic boy";
        } else if (str.equals("ESXP")) {
            return "Iron fist";
        } else if (str.equals("ENXJ")) {
            return "silver surfer";
        } else if (str.equals("ENXP")) {
            return "Deadpool";
        } else if (str.equals("ISXJ")) {
            return "Black Widow";
        } else if (str.equals("ISXP")) {
            return "Thor";
        } else if (str.equals("INXJ")) {
            return "Aqua Man";
        } else if (str.equals("INXP")) {
            return "Martian Manhunter";
        } else if (str.equals("ESTX")) {
            return "Mr. Fantastic";
        } else if (str.equals("ESFX")) {
            return "Robin";
        } else if (str.equals("ENTX")) {
            return "Green arrow";
        } else if (str.equals("ENFX")) {
            return "Bat women";
        } else if (str.equals("ISTX")) {
            return "Superman";
        } else if (str.equals("ISFX")) {
            return "Batgirl";
        } else if (str.equals("INTX")) {
            return "Flash";
        } else if (str.equals("INFX")) {
            return "Antman";
        } else if (str.equals("XXXJ")) {
            return "Tony Stark";
        } else if (str.equals("XXXP")) {
            return "Batman";
        } else if (str.equals("EXXX")) {
            return "Spider man";
        } else if (str.equals("IXXX")) {
            return "StarLord";
        } else if (str.equals("XSXX")) {
            return "Hulk";
        } else if (str.equals("XNXX")) {
            return "Flash";
        } else if (str.equals("XXTX")) {
            return "Raven";
        } else if (str.equals("XXFX")) {
            return "Falcon";
        } else if (str.equals("XXTJ")) {
            return "Dr. Strange";
        } else if (str.equals("XXFP")) {
            return "Batman";
        } else if (str.equals("XXTP")) {
            return "Superman";
        } else if (str.equals("XXFJ")) {
            return "Iron Man";
        } else if (str.equals("EXXJ")) {
            return "Iron Man";
        } else if (str.equals("EXXP")) {
            return "Spider Man";
        } else if (str.equals("IXXJ")) {
            return "Thor";
        } else if (str.equals("IXXP")) {
            return "Aqua Man";
        } else if (str.equals("ESXX")) {
            return "Iron Man";
        } else if (str.equals("ENXX")) {
            return "Captain America";
        } else if (str.equals("ISXX")) {
            return "Cyborg";
        } else if (str.equals("INXX")) {
            return "Flash";
        } else if (str.equals("XNXJ")) {
            return "Flash";
        } else if (str.equals("XSXJ")) {
            return "Iron Man";
        } else if (str.equals("XSXP")) {
            return "Hulk";
        } else if (str.equals("XNXP")) {
            return "Flash";
        } else if (str.equals("EXTX")) {
            return "Dr. Strange";
        } else if (str.equals("IXTX")) {
            return "Spider man";
        } else if (str.equals("EXFX")) {
            return "ant man";
        } else if (str.equals("IXFX")) {
            return "Robin";
        } else if (str.equals("XXXX")) {
            return "EVAN LEE";
        } else {
           return "Anish C";
        }
    }
}