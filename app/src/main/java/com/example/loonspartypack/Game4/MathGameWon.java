package com.example.loonspartypack.Game4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

public class MathGameWon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathgame_won);
    }

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(MathGameWon.this, MathGamePlay.class);
        startActivity(intent);
        finish();
    }
    public void goHome(View view) {
        Intent intent = new Intent(MathGameWon.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}