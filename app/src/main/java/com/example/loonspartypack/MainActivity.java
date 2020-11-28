//******************************************************
// File: MainActivity.java
//
// Purpose: to host the code for the menu that allows
// user to chose a game.
//
// Written By: Jonathon Carrera
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loonspartypack.Game1.TicTacToe;

public class MainActivity extends AppCompatActivity {
    Button game1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game1 = (Button) findViewById(R.id.Game1);
        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TicTacToe.class));
                finish();
            }
        });
    }
}