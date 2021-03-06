//******************************************************
// File: MathGameDisplay.java
//
// Purpose: to host the code for initial game4 activity
//
// Written By: Thomas Willoughby
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

public class MathGameDisplay extends Activity {

    Button play, home;
    TextView wrongAnsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_display);
        //Initialize
        play = (Button) findViewById(R.id.play);
        home = (Button) findViewById(R.id.home);
        wrongAnsText = (TextView)findViewById(R.id.wrongAns);

        //play button onclick listener
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGameDisplay.this, MathGamePlay.class);
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGameDisplay.this, MainActivity.class);
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
