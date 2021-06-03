package com.example.personalitytestfinalproject;

public class QuestionBank {

    public static String[] mQuetions = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "last quetion"
    };
    public static String[][] mChoices =  {
            {"red","blue"},
            {"strong","tall"},
            {"family","friends"},
            {"good","bad"},
            {"red","blue"},
            {"strong","tall"},
            {"family","friends"},
            {"good","bad"},
            {"red","blue"},
            {"strong","tall"},
            {"family","friends"},
            {"good","bad"},
            {"red","blue"},
            {"strong","tall"},
            {"family","friends"},
            {"good","bad"},
    };

    public static double[][] mPersonalityScore = {{0, 0}, {0, 0}, {0, 0}, {0,0}};

    public static void updateQuestion(double answerA[], double answerB[], int i, boolean bool){
        int remainder = i % 4;
        int index = 0;
        //Finds question catagory
        if (remainder == 1) {
            index = 1;
        } else if (remainder == 2) {
            index = 2;
        } else if (remainder == 3) {
            index = 3;
        }
        if (bool){
            answerA[index]++;
        }
        else if (!bool){
            answerB[index]++;
        }
    }

}
