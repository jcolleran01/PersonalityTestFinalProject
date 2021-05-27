package com.example.personalitytestfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button mChoiceTwo;
    private Button mChoiceOne;
    private Button mIDontKnowButton;
    private Button mQuitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChoiceTwo = (Button) findViewById(R.id.choice_two);
        mChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop("Interesting!");
            }
        });

        mChoiceOne = (Button) findViewById(R.id.choice_one);
        mChoiceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("So you are one of those people!");
            }
        });
        mIDontKnowButton = (Button) findViewById(R.id.i_dont_know_button);
        mIDontKnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("WHY CANT YOU DECIDE!");
            }
        });
        mQuitButton = (Button) findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop ("LAME");
            }
        });
    }

    public void makeTop(String toastDisplay){
        Toast toast = Toast.makeText(MainActivity.this, toastDisplay, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }
}