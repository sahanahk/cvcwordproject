package com.example.android.cvcwordproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.cvcwordproject.data.QuizContract.QuizQuestions;

/**
 * Created by Sahana on 15-11-2017.
 */
public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    //to create database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE_QUESTIONS = "CREATE TABLE " + QuizQuestions.TABLE_NAME_1 + " ("
                + QuizQuestions._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + QuizQuestions.COLUMN_QUESTION + " TEXT NOT NULL,"
                + QuizQuestions.COLUMN_OPTION_A + " TEXT NOT NULL,"
                + QuizQuestions.COLUMN_OPTION_B + " TEXT NOT NULL,"
                + QuizQuestions.COLUMN_OPTION_C + " TEXT NOT NULL,"
                + QuizQuestions.COLUMN_OPTION_D + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_TABLE_QUESTIONS);

        String SQL_CREATE_TABLE_ANSWERS = "CREATE TABLE " + QuizQuestions.TABLE_NAME_2 + " ("
                + QuizQuestions.ANSWER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + QuizQuestions.COLUMN_CORRECT + " TEXT NOT NULL,"
                + QuizQuestions.COLUMN_FK_QUESTION_ID + " INTEGER ,"
                + " FOREIGN KEY (" + QuizQuestions.COLUMN_FK_QUESTION_ID + ") REFERENCES " + QuizQuestions.TABLE_NAME_1 + " (" + QuizQuestions._ID + "));";
        db.execSQL(SQL_CREATE_TABLE_ANSWERS);
        //to add quiz questions to database only once
        QuizDbInsertions mDbInserter = new QuizDbInsertions();
        mDbInserter.insertQuizQuestions(db);
        mDbInserter.insertQuizAnswers(db);
    }

    //to upgrade to newer version of database table.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
