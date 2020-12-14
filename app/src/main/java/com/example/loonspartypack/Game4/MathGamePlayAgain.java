//******************************************************
// File: MathGamePlayAgain.java
//
// Purpose: to host the code for the play again screen
//
// Written By: Thomas Willoughby
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game4;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;


public class MathGamePlayAgain extends Activity {

    Button playAgain, home;
    TextView wrongAnsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_playagain);
        //Initialize
        playAgain = (Button) findViewById(R.id.playAgainButton);
        wrongAnsText = (TextView)findViewById(R.id.wrongAns);
        home = (Button)findViewById(R.id.home);

        MediaPlayer wrong= MediaPlayer.create(MathGamePlayAgain.this,R.raw.wrong);
        wrong.start();

        //play again button onclick listener
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGamePlayAgain.this, MathGamePlay.class);
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGamePlayAgain.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


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
