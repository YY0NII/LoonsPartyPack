//******************************************************
// File: EndGame.java
//
// Purpose: to host the necessary code for the end game
// screen
//
// Written By: James D'Amico
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loonspartypack.Game1.TicTacToe;
import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

import org.w3c.dom.Text;

public class EndGame extends AppCompatActivity {
    private Button backButton;
    private TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        score = (TextView)findViewById(R.id.scoreTextView);
        backButton = (Button)findViewById(R.id.backButton);

        Bundle extras = getIntent().getExtras();
        score.setText("Score: " + extras.getSerializable("score"));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EndGame.this, MainActivity.class));
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