package com.example.android.cvcwordproject.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.cvcwordproject.Questions;

import java.sql.RowId;

/**
 * Created by Sahana on 28-11-2017.
 */
public class QuizDbInsertions extends Activity {


    /**
     * Method to add Quiz Questions into Database
     */
    public void insertQuizQuestions(SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "Ram is wearing a _______________");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Bat");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Vet");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Hat");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Mud");

        long RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "Topsy and Tim are going for a ____________");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Kid");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Let");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Well");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Walk");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);


        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "Fox is sleeping on the ____________");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Bed");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Fed");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Bell");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Run");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "Aadya is a very good____________");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Pet");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Hit");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Girl");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Tell");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "A __________ is flying in the air");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Get");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Jet");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Bin");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Pan");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "A  ____________ is made of sticks");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Top");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Hot");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Hut");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Put");

        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_QUESTION, "A fish is in the  ____________");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_A, "Stand");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_B, "Net");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_C, "Bet");
        values.put(QuizContract.QuizQuestions.COLUMN_OPTION_D, "Nest");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_1, null, values);


    }

    public void insertQuizAnswers(SQLiteDatabase db) {
        long RowId;
        ContentValues values = new ContentValues();
        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "C");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "1");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);


        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "D");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "2");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "A");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "3");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "C");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "4");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "B");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "5");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "C");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "6");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

        values.put(QuizContract.QuizQuestions.COLUMN_CORRECT, "B");
        values.put(QuizContract.QuizQuestions.COLUMN_FK_QUESTION_ID, "7");
        RowId = db.insert(QuizContract.QuizQuestions.TABLE_NAME_2, null, values);

    }
}
