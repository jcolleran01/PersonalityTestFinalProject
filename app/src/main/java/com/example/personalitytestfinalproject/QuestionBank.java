package com.example.personalitytestfinalproject;

public class QuestionBank {

    public static String[] mQuetions = {
            "Who would you rather save from falling off a bridge?",
            "How would you transport a pile of rocks 100 meters?",
            "Would you attend hogwarts if you could?",
            "Which role would you take in a play?",
            "Are you willing to risk your life to save someone?",
            "If your candy is stuck in the vending machine, what would you do?",
            "Would you rather be",
            "Where would you want to live more",
            "Who would you rather be?",
            "What would you rather be?",
            "Would you rather",
            "Would you tell people if you won the lottery",
            "Would you take the day off as a hero?",
            "Which would you rather be?",
            "Do you believe in magic?",
            "Do you think you look better or worse with your covid mask on?"
    };
    public static String[][] mChoices =  {
            {"20 strangers","1 family member"},
            {"Slowly all in one trip","Quickly in a couple small trips "},
            {"Yes","No"},
            {"An actor","Stage crew"},

            {"Yes","No"},
            {"Punch it","Ask an employee"},
            {"Great at one thing","Above average at everything"},
            {"The busy city","A quite village"},

            {"The teacher","Student"},
            {"A body builder","Athlete"},
            {"Have natural weapons","Make your own"},
            {"Of course","No way"},

            {"Of course not, Crime never sleeps","Yes, I need my rest"},
            {"A horse","An Elephant"},
            {"Yes","No"},
            {"Worse","Better"},
    };


    public static void updateQuestion(double answerA[], double answerB[], int i, boolean bool){
        int remainder = i % 4;
        int index = 0;
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
