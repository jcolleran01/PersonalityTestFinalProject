package com.example.personalitytestfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mIDontKnowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTop("Interesting!");
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
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
    }

    public void makeTop(String toastDisplay){
        Toast toast = Toast.makeText(MainActivity.this, toastDisplay, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }
}