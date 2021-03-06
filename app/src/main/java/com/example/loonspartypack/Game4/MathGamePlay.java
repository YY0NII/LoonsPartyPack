//******************************************************
// File: MathGamePlay.java
//
// Purpose: to host the code for the quiz game
//
// Written By: Thomas Willoughby
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

import java.util.Collections;
import java.util.List;

//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;


public class MathGamePlay extends Activity {

    Button buttonA, buttonB, buttonC, buttonD;
    TextView questionText, resultText, countnum;
    MathGameQuestions mq;
    MathQuestions currentQues;
    List<MathQuestions> list;
    int q = 0;
    int num = 8;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_play);



        //Initializing variables
        questionText = (TextView) findViewById(R.id.triviaQuestion);
        countnum = (TextView) findViewById(R.id.countnum);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        //triviaQuizText = (TextView) findViewById(R.id.triviaQuizText);
        resultText = (TextView) findViewById(R.id.resultText);


        countnum.setText("" + q + 1);

        mq = new MathGameQuestions(this);
        mq.getWritableDatabase();


        if (mq.getAllOfTheQuestions().size() == 0) {
            mq.allQuestion();
        }

        list = mq.getAllOfTheQuestions();

        Collections.shuffle(list);

        currentQues = list.get(q);

        updateQueAndOptions();


    }

    public void updateQueAndOptions() {

        //This method will setText for que and options
        questionText.setText(currentQues.getQuestion());
        buttonA.setText(currentQues.getOptA());
        buttonB.setText(currentQues.getOptB());
        buttonC.setText(currentQues.getOptC());
        buttonD.setText(currentQues.getOptD());

        countnum.setText(Integer.toString(q + 1));

    }


    public void buttonA(View view) {
        if (currentQues.getOptA().equals(currentQues.getAnswer()))
            axMthod();
        else
            gameLostPlayAgain();
    }
    //Onclick listener for sec button
    public void buttonB(View view) {
        if (currentQues.getOptB().equals(currentQues.getAnswer())) {
            axMthod();
        } else {
            gameLostPlayAgain();
        }
    }
    //Onclick listener for third button
    public void buttonC(View view) {
        if (currentQues.getOptC().equals(currentQues.getAnswer())) {
            axMthod();
        } else {
            gameLostPlayAgain();
        }
    }
    //Onclick listener for fourth button
    public void buttonD(View view) {
        if (currentQues.getOptD().equals(currentQues.getAnswer())) {
            axMthod();
        } else {
            gameLostPlayAgain();
        }
    }
    private void axMthod(){
        if (q <= num) {
            MediaPlayer correct= MediaPlayer.create(MathGamePlay.this,R.raw.correct);
            correct.start();
            disableButton();
            correctDialog();

        } else {
            gameWon();
        }
    }

    //This method will navigate from current activity to GameWon
    public void gameWon() {
        Intent intent = new Intent(this, MathGameWon.class);
        startActivity(intent);
        finish();
    }

    //This method is called when user ans is wrong
    //this method will navigate user to the activity PlayAgain
    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, MathGamePlayAgain.class);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //This dialog is show to the user after he ans correct
    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog( MathGamePlay.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.mathgame_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();


        Button buttonNext = (Button) dialogCorrect.findViewById(R.id.nextQuestion);


        //OnCLick listener to go next que
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCorrect.dismiss();
                q++;
                currentQues= list.get(q);
                updateQueAndOptions();
                enableButton();
            }
        });
    }



    //This method will disable the buttons
    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    //This method will enable the buttons
    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }

    //****************************************************
    // Method: onBackPressed()
    //
    // Written By: Jonathon Carrera
    //
    // Purpose: To override the default onBackPressed()
    // so that the rest of the application is not locked
    // to portrait mode
    //****************************************************
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}

