//******************************************************
// File: MathGameQuestions.java
//
// Purpose: to host the code for the Qquestions that get
// shown
//
// Written By: Thomas Willoughby
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


class MathGameQuestions extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "MathQuiz.db";
    private static final int DB_VERSION = 3;
    private static final String TABLE_NAME = "TQ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA +
            " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    MathGameQuestions(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }



    void allQuestion() {
        ArrayList<MathQuestions> arraylist = new ArrayList<>();

        arraylist.add(new MathQuestions("5 + 36", "41", "33", "25", "74", "41"));

        arraylist.add(new MathQuestions("45 - 13", "23", "32", "33", "44", "32"));

        arraylist.add(new MathQuestions("5 x 25", "145", "135", "105", "125", "125"));

        arraylist.add(new MathQuestions("4 + 329", "333", "334", "332", "404", "333"));

        arraylist.add(new MathQuestions("13 x 14?", "192", "172", "174", "182", "182"));

        arraylist.add(new MathQuestions("Who is the greatest professor in the world?", "Moaath Alrajab", "Not Moaath", "Bobbeh", "No One", "Moaath Alrajab"));

        arraylist.add(new MathQuestions("35 / 7?", "5", "6", "7", "8", "5"));

        arraylist.add(new MathQuestions("20 + 139?", "502", "159", "149", "302", "159"));

        arraylist.add(new MathQuestions("30 x 41?", "401", "1330", "1230", "1430", "1230"));

        arraylist.add(new MathQuestions("25 x 6?", "105", "135", "125", "150", "150"));

        arraylist.add(new MathQuestions("35 + 74?", "107", "119", "109", "117", "109"));

        arraylist.add(new MathQuestions("3 + 4x = 15", "x = 2", "x = 5", "x = 3", "x = 4", "x = 3"));

        arraylist.add(new MathQuestions("5 - 2x = -3", "x = 4", "x = 5", "x = 3", "x = 6", "x = 4"));

        arraylist.add(new MathQuestions("101 - 74", "17", "37", "47", "27", "27"));

        arraylist.add(new MathQuestions("7x + 5 = 26", "x = 3", "x = 4", "x = 5", "x = 6", "x = 3"));


        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<MathQuestions> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (MathQuestions question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<MathQuestions> getAllOfTheQuestions() {

        List<MathQuestions> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            MathQuestions question = new MathQuestions();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
