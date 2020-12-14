package com.example.loonspartypack.Game4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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
    int qid = 0;
    int num = 7;



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


        countnum.setText("" + qid + 1);

        mq = new MathGameQuestions(this);
        mq.getWritableDatabase();


        if (mq.getAllOfTheQuestions().size() == 0) {
            mq.allQuestion();
        }

        list = mq.getAllOfTheQuestions();

        Collections.shuffle(list);

        currentQues = list.get(qid);

        updateQueAndOptions();


    }

    public void updateQueAndOptions() {

        //This method will setText for que and options
        questionText.setText(currentQues.getQuestion());
        buttonA.setText(currentQues.getOptA());
        buttonB.setText(currentQues.getOptB());
        buttonC.setText(currentQues.getOptC());
        buttonD.setText(currentQues.getOptD());

        countnum.setText(Integer.toString(qid + 1));

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
        if (qid <= num) {
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

/*
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }

 */

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
                qid++;
                currentQues= list.get(qid);
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


}

