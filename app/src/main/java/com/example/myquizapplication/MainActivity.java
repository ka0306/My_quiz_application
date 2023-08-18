package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.question_anser.MyClass;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView totalquestiontextview;
    TextView questiontextview;
    Button ans_a, ans_b, ans_c, ans_d;
    Button submitbtn;

    int score = 0;
    int totalquestion = MyClass.question.length;
    int corretquestionindex = 0;
    String selectedanswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalquestiontextview = findViewById(R.id.Total_question);
        questiontextview = findViewById(R.id.question);
        ans_a = findViewById(R.id.ans_a);
        ans_b = findViewById(R.id.ans_b);
        ans_c = findViewById(R.id.ans_c);
        ans_d = findViewById(R.id.ans_d);
        submitbtn = findViewById(R.id.submit_btn);

        ans_a.setOnClickListener(this);
        ans_b.setOnClickListener(this);
        ans_c.setOnClickListener(this);
        ans_d.setOnClickListener(this);
        submitbtn.setOnClickListener(this);

        totalquestiontextview.setText("total question:" + totalquestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {
        ans_a.setBackgroundColor(Color.WHITE);
        ans_b.setBackgroundColor(Color.WHITE);
        ans_c.setBackgroundColor(Color.WHITE);
        ans_d.setBackgroundColor(Color.WHITE);

//        Object View;
        Button clickedButton = (Button)findViewById();
        if (clickedButton.getId() == R.id.submit_btn) {
            corretquestionindex++;
            loadNewQuestion();
            if (selectedanswer.equals(MyClass.correctanswer[corretquestionindex])) {
            }
            score++;
        } else {
            selectedanswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }

    void loadNewQuestion() {
        if (corretquestionindex == totalquestion) {
            finishquiz();
            return;
        }
        questiontextview.setText(MyClass.question[corretquestionindex]);
        ans_a.setText(MyClass.choice[corretquestionindex][0]);
        ans_b.setText(MyClass.choice[corretquestionindex][1]);
        ans_c.setText(MyClass.choice[corretquestionindex][2]);
        ans_d.setText(MyClass.choice[corretquestionindex][3]);

    }

    void finishquiz() {
        String passstatus = "";
        if (score > totalquestion * 0.60) {
        passstatus="passed";
        }else{

        }
    }
}


