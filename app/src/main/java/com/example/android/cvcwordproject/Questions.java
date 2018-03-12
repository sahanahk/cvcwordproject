package com.example.android.cvcwordproject;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.android.cvcwordproject.data.QuizContract;
import com.example.android.cvcwordproject.data.QuizContract.QuizQuestions;
import com.example.android.cvcwordproject.data.QuizDbHelper;
import com.example.android.cvcwordproject.data.QuizDbInsertions;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Sahana on 26-09-2017.
 */
public class Questions extends AppCompatActivity {

    int questionCount = 1;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        this.setTitle("Level 1");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        displayQuestions(questionCount);
        final ImageView next = (ImageView) findViewById(R.id.next);
        Button done = (Button) findViewById(R.id.check_answer);
        done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                boolean correct = false;
                String answer = checkOptionSelected(V);
                //  Toast.makeText(getApplicationContext(),"This works  "+answer,Toast.LENGTH_SHORT).show();
                if (answer.equals("NONE")) {
                    displayQuestions(questionCount);
                } else
                    correct = checkanswer(questionCount, answer);

                if (correct) {
                    if (questionCount < QuizQuestions.NO_OF_QUESTIONS) {
                        next.setVisibility(View.VISIBLE);
                    } else {
                        Intent intent = new Intent(Questions.this, EndofQuiz.class);
                        startActivity(intent);
                    }

                } else {
                    displayQuestions(questionCount);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next.setVisibility(View.INVISIBLE);
                if (questionCount <= QuizQuestions.NO_OF_QUESTIONS) {
                    questionCount++;
                    displayQuestions(questionCount);
                }


            }
        });


    }

    /**
     * To check for RadioButton selection
     */
    public String checkOptionSelected(View view) {
        String answer;
        RadioButton RadioButton_ans1 = (RadioButton) findViewById(R.id.RadioButton_ans1);
        boolean answer_A = RadioButton_ans1.isChecked();
        RadioButton RadioButton_ans2 = (RadioButton) findViewById(R.id.RadioButton_ans2);
        boolean answer_B = RadioButton_ans2.isChecked();
        RadioButton RadioButton_ans3 = (RadioButton) findViewById(R.id.RadioButton_ans3);
        boolean answer_C = RadioButton_ans3.isChecked();
        RadioButton RadioButton_ans4 = (RadioButton) findViewById(R.id.RadioButton_ans4);
        boolean answer_D = RadioButton_ans4.isChecked();

        // Check which RadioButton was clicked

        if (answer_A)
            answer = "A";
        else if (answer_B)
            answer = "B";
        else if (answer_C)
            answer = "C";
        else if (answer_D)
            answer = "D";
        else {
            Toast.makeText(getApplicationContext(), "Please select the answer", Toast.LENGTH_SHORT).show();
            answer = "NONE";
        }
        return answer;

    }


    /**
     * To check if the answer is correct from the database
     */
    private boolean checkanswer(int questionCount, String answer) {
        boolean correct;
        QuizDbHelper mDbHelper = new QuizDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projections = {QuizQuestions.COLUMN_CORRECT, QuizQuestions.COLUMN_FK_QUESTION_ID};
        String selection = QuizQuestions.COLUMN_FK_QUESTION_ID + " =?";
        String[] selectionArgs = new String[]{
                Integer.toString(questionCount)};
        Cursor c = db.query(QuizQuestions.TABLE_NAME_2, projections, selection, selectionArgs, null, null, null, null);
        try {
            int columnCorrectIndex = c.getColumnIndex(QuizQuestions.COLUMN_CORRECT);
            c.moveToFirst();
            String correct_answerColumn = c.getString(columnCorrectIndex);
            if (correct_answerColumn.equalsIgnoreCase(answer)) {
                getCustomtoast();
                // (Toast.makeText(getApplicationContext(),"Answer "+correct_answerColumn+" is correct.Well done.",Toast.LENGTH_SHORT)).show();
                correct = true;
            } else {
                (Toast.makeText(getApplicationContext(), "Answer " + answer + " is wrong", Toast.LENGTH_SHORT)).show();
                correct = false;
                RadioGroup options = (RadioGroup) findViewById(R.id.radiogroup_options);
                options.setEnabled(false);
            }
        } finally {
            c.close();
        }
        return correct;
    }


    /**
     * Populate the activity withe the question from database
     */
    private void displayQuestions(int questionCount) {


        QuizDbHelper mDbHelper = new QuizDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        TextView quizQuestion = (TextView) findViewById(R.id.quiz_question);
        RadioButton radioButton_ans1 = (RadioButton) findViewById(R.id.RadioButton_ans1);
        RadioButton radioButton_ans2 = (RadioButton) findViewById(R.id.RadioButton_ans2);
        RadioButton radioButton_ans3 = (RadioButton) findViewById(R.id.RadioButton_ans3);
        RadioButton radioButton_ans4 = (RadioButton) findViewById(R.id.RadioButton_ans4);
        String[] projections = {QuizQuestions.COLUMN_QUESTION,
                QuizQuestions.COLUMN_OPTION_A,
                QuizQuestions.COLUMN_OPTION_B,
                QuizQuestions.COLUMN_OPTION_C,
                QuizQuestions.COLUMN_OPTION_D};
        String selection = QuizQuestions._ID + " =?";
        String[] selectionArgs = new String[]{
                Integer.toString(questionCount)};
        Cursor cursor = db.query(QuizQuestions.TABLE_NAME_1, projections, selection, selectionArgs, null, null, null);

        try {
            //Display the first row of the database as quiz question
            cursor.moveToFirst();
            //Figure out the Column Index no.
            int columnQuizIndex = cursor.getColumnIndex(QuizQuestions.COLUMN_QUESTION);
            int columnOptionAIndex = cursor.getColumnIndex(QuizQuestions.COLUMN_OPTION_A);
            int columnOptionBIndex = cursor.getColumnIndex(QuizQuestions.COLUMN_OPTION_B);
            int columnOptionCIndex = cursor.getColumnIndex(QuizQuestions.COLUMN_OPTION_C);
            int columnOptionDIndex = cursor.getColumnIndex(QuizQuestions.COLUMN_OPTION_D);

            //Retrieve the data stored in  columns
            String quiz_question = cursor.getString(columnQuizIndex);
            String option_a = cursor.getString(columnOptionAIndex);
            String option_b = cursor.getString(columnOptionBIndex);
            String option_c = cursor.getString(columnOptionCIndex);
            String option_d = cursor.getString(columnOptionDIndex);

            //to uncheck radio button
            radioButton_ans1.setChecked(false);
            radioButton_ans2.setChecked(false);
            radioButton_ans3.setChecked(false);
            radioButton_ans4.setChecked(false);

            quizQuestion.setText(quiz_question);
            radioButton_ans1.setText(option_a);
            radioButton_ans2.setText(option_b);
            radioButton_ans3.setText(option_c);
            radioButton_ans4.setText(option_d);

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }


    }

    /*
    Custom toast message
     */
    public void getCustomtoast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Well Done.That's correct");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}




