package com.example.android.cvcwordproject.data;

import android.provider.BaseColumns;

/**
 * Created by Sahana on 14-11-2017.
 */
public class QuizContract {

    public QuizContract() {
    }

    public static final class QuizQuestions implements BaseColumns {
        //Define table name and column names as constants.
        public static final String TABLE_NAME_1 = "questions";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION_A = "optiona";
        public static final String COLUMN_OPTION_B = "optionb";
        public static final String COLUMN_OPTION_C = "optionc";
        public static final String COLUMN_OPTION_D = "optiond";


        public static final String TABLE_NAME_2 = "answer";
        public static final String ANSWER_ID = "answer_id";
        public static final String COLUMN_CORRECT = "correct";
        public static final String COLUMN_FK_QUESTION_ID = "fk_question_id";

        public static final int NO_OF_QUESTIONS = 7;
    }
}
