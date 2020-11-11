package com.example.loonspartypack.Game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loonspartypack.R;

public class TicTacToe extends AppCompatActivity {
    private boolean player1 = false;
    private boolean player2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }

    public void buttonClicked(View v) {
        if (!player1 && !player2) {
            Button theButton = (Button) v;
            theButton.setText("X");
            player1 = true;
        } else if (player1 && !player2) {
            Button theButton = (Button) v;
            theButton.setText("O");
            player2 = true;
        } else if (player1) {
            Button theButton = (Button) v;
            theButton.setText("X");
            player2 = false;
        }
    }

    public void reset(View v){
        finish();
        startActivity(new Intent(getIntent()));
    }
}