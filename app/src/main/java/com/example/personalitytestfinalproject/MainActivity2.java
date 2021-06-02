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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mChoiceTwo = (Button) findViewById(R.id.choice_two);
        mChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop("Interesting!");
                if (v.getId() == R.id.choice_one) {
                    QuestionBank.updateQuestion(1, true);
                } else if (v.getId() == R.id.choice_two) {
                    QuestionBank.updateQuestion(1, false);
                }
                if (quetionNum == 15) {
                    //mQuetions.setText("");
                    mQuetions.setText(finalPersonality(QuestionBank.mPersonalityScore[0], QuestionBank.mPersonalityScore[1], QuestionBank.mPersonalityScore[2], QuestionBank.mPersonalityScore[3]));
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
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
                if (v.getId() == R.id.choice_one) {
                    QuestionBank.updateQuestion(1, true);
                } else if (v.getId() == R.id.choice_two) {
                    QuestionBank.updateQuestion(1, false);
                }
                if (quetionNum == 15) {
                    mQuetions.setText(finalPersonality(QuestionBank.mPersonalityScore[0], QuestionBank.mPersonalityScore[1], QuestionBank.mPersonalityScore[2], QuestionBank.mPersonalityScore[3]));
                    //instead of "" put score
                    //mQuetions.setText("");
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
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
                    mQuetions.setText(finalPersonality(QuestionBank.mPersonalityScore[0], QuestionBank.mPersonalityScore[1], QuestionBank.mPersonalityScore[2], QuestionBank.mPersonalityScore[3]));
                    //instead of "" put score
                    //mQuetions.setText("");
                    mChoiceOne.setText("");
                    mChoiceTwo.setText("");
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

    public static String finalPersonality(double answerA[], double answerB[], double answerC[], double answerD[]) {
        double[] percentAB = new double[4];
        int[] percentRounded = new int[4];
        String[] letters = new String[4];
        String[] lettersESTJ = {"E", "S", "T", "J"};
        String[] lettersINFP = {"I", "N", "F", "P"};
        //Find the percent
        if ((double) (answerA[0] / (answerA[0] + answerA[1])) == 50){
            letters[0] = "X";
        }
        else if ((double) (answerA[0] / (answerA[0] + answerA[1])) < 50){
            letters[0] = "E";
        }
        else if ((double) (answerA[0] / (answerA[0] + answerA[1])) > 50){
            letters[0] = "I";
        }
        if ((double) (answerB[0] / (answerB[0] + answerB[1])) == 50){
            letters[1] = "X";
        }
        else if ((double) (answerB[0] / (answerB[0] + answerB[1])) < 50){
            letters[1] = "S";
        }
        else if ((double) (answerB[0] / (answerB[0] + answerB[1])) > 50){
            letters[1] = "N";
        }
        if ((double) (answerC[0] / (answerC[0] + answerC[1])) == 50){
            letters[2] = "X";
        }
        else if ((double) (answerC[0] / (answerC[0] + answerC[1])) < 50){
            letters[2] = "T";
        }
        else if ((double) (answerC[0] / (answerC[0] + answerC[1])) > 50){
            letters[2] = "F";
        }
        if ((double) (answerD[0] / (answerD[0] + answerD[1])) == 50){
            letters[3] = "X";
        }
        else if ((double) (answerD[0] / (answerD[0] + answerD[1])) < 50){
            letters[3] = "J";
        }
        else if ((double) (answerD[0] / (answerD[0] + answerD[1])) > 50){
            letters[3] = "P";
        }
        String str = "";
        for (int i = 0; i < 3; i++){
            str += letters[i];
        }
        return str;
        //
        /*for (int i = 0; i < answerA.length; i++) {
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
        /*
        if (str.equals("ESTJ")) {
            return "1";
        } else if (str.equals("ESTP")) {
            return "2";
        } else if (str.equals("ESFP")) {
            return "3";
        } else if (str.equals("ESFJ")) {
            return "4";
        } else if (str.equals("ENTJ")) {
            return "5";
        } else if (str.equals("ENTP")) {
            return "6";
        } else if (str.equals("ENFP")) {
            return "7";
        } else if (str.equals("ENFJ")) {
            return "8";
        } else if (str.equals("ISTJ")) {
            return "9";
        } else if (str.equals("ISTP")) {
            return "10";
        } else if (str.equals("ISFP")) {
            return "11";
        } else if (str.equals("ISFJ")) {
            return "12";
        } else if (str.equals("INTJ")) {
            return "13";
        } else if (str.equals("INTP")) {
            return "14";
        } else if (str.equals("INFP")) {
            return "15";
        } else if (str.equals("INFJ")) {
            return "16";
        } else if (str.equals("XSTJ")) {
            return "17";
        } else if (str.equals("XSTP")) {
            return "18";
        } else if (str.equals("XSFP")) {
            return "19";
        } else if (str.equals("XSFJ")) {
            return "20";
        } else if (str.equals("XNTJ")) {
            return "21";
        } else if (str.equals("XNTP")) {
            return "22";
        } else if (str.equals("XNFP")) {
            return "23";
        } else if (str.equals("XNFJ")) {
            return "24";
        } else if (str.equals("EXTJ")) {
            return "25";
        } else if (str.equals("EXTP")) {
            return "26";
        } else if (str.equals("EXFP")) {
            return "27";
        } else if (str.equals("EXFJ")) {
            return "28";
        } else if (str.equals("IXTJ")) {
            return "29";
        } else if (str.equals("IXTP")) {
            return "30";
        } else if (str.equals("IXFP")) {
            return "31";
        } else if (str.equals("IXFJ")) {
            return "32";
        } else if (str.equals("ESXJ")) {
            return "33";
        } else if (str.equals("ESXP")) {
            return "34";
        } else if (str.equals("ENXJ")) {
            return "35";
        } else if (str.equals("ENXP")) {
            return "36";
        } else if (str.equals("ISXJ")) {
            return "37";
        } else if (str.equals("ISXP")) {
            return "38";
        } else if (str.equals("INXJ")) {
            return "39";
        } else if (str.equals("INXP")) {
            return "40";
        } else if (str.equals("ESTX")) {
            return "41";
        } else if (str.equals("ESFX")) {
            return "42";
        } else if (str.equals("ENTX")) {
            return "43";
        } else if (str.equals("ENFX")) {
            return "44";
        } else if (str.equals("ISTX")) {
            return "45";
        } else if (str.equals("ISFX")) {
            return "46";
        } else if (str.equals("INTX")) {
            return "47";
        } else if (str.equals("INFX")) {
            return "48";
        } else if (str.equals("XXXJ")) {
            return "49";
        } else if (str.equals("XXXP")) {
            return "50";
        } else if (str.equals("EXXX")) {
            return "51";
        } else if (str.equals("IXXX")) {
            return "52";
        } else if (str.equals("XSXX")) {
            return "53";
        } else if (str.equals("XNXX")) {
            return "54";
        } else if (str.equals("XXTX")) {
            return "55";
        } else if (str.equals("XXFX")) {
            return "56";
        } else if (str.equals("XXTJ")) {
            return "57";
        } else if (str.equals("XXFP")) {
            return "58";
        } else if (str.equals("XXTP")) {
            return "59";
        } else if (str.equals("XXFJ")) {
            return "60";
        } else if (str.equals("EXXJ")) {
            return "61";
        } else if (str.equals("EXXP")) {
            return "62";
        } else if (str.equals("IXXJ")) {
            return "63";
        } else if (str.equals("IXXP")) {
            return "64";
        } else if (str.equals("ESXX")) {
            return "65";
        } else if (str.equals("ENXX")) {
            return "66";
        } else if (str.equals("ISXX")) {
            return "67";
        } else if (str.equals("INXX")) {
            return "68";
        } else if (str.equals("XNXJ")) {
            return "69";
        } else if (str.equals("XSXJ")) {
            return "70";
        } else if (str.equals("XSXP")) {
            return "71";
        } else if (str.equals("XNXP")) {
            return "72";
        } else if (str.equals("EXTX")) {
            return "73";
        } else if (str.equals("IXTX")) {
            return "74";
        } else if (str.equals("EXFX")) {
            return "75";
        } else if (str.equals("IXFX")) {
            return "76";
        } else if (str.equals("XXXX")) {
            return "78";
        } else {
           return "79";
        }
       */
        //return str;
    }
}