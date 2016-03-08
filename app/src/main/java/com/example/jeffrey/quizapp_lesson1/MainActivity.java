package com.example.jeffrey.quizapp_lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private String[] answers;
    private String[] questions;
    private String[] correctAnswers;
    private ArrayList<String> questionResults;
    int questionNum;
    int answerNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        questionNum =0;
        question = (TextView)findViewById(R.id.question);
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        answers = getResources().getStringArray(R.array.answers);
        questions = getResources().getStringArray(R.array.questions);
        correctAnswers = getResources().getStringArray(R.array.correct_answers);
        questionResults = new ArrayList<>();
        setUpQuestion();
    }

    private void setUpQuestion(){
        question.setText(questions[questionNum]);
        answer1.setText(answers[answerNum++]);
        answer2.setText(answers[answerNum++]);
        answer3.setText(answers[answerNum++]);
        answer4.setText(answers[answerNum++]);
    }

    public void answerClicked(View v) {
        Button clicked = (Button) v;
        if (clicked.getText().equals(correctAnswers[questionNum])) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            questionResults.add(questions[questionNum] + "\n" + "Your Answer: " + clicked.getText() + ": Correct!");
        }
        else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            questionResults.add(questions[questionNum] + "\n" + "Your Answer: " + clicked.getText()+ ": Incorrect!");
        }
        if (questionNum >= questions.length-1) {
            Intent i = new Intent(getApplicationContext(),ResultActivity.class);
            i.putStringArrayListExtra("results",questionResults);
            startActivity(i);
        }
        else {
            questionNum++;
            setUpQuestion();

        }
    }
}
