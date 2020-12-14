//******************************************************
// File: MainActivity.java
//
// Purpose: to host the code for the menu that allows
// user to chose a game.
//
// Written By: Jonathon Carrera and Samson Fashakin
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loonspartypack.Game1.TicTacToe;
import com.example.loonspartypack.Game2.Game2Activity;
import com.example.loonspartypack.Game2.Rules;
import com.example.loonspartypack.Game3.Game3Activity;

public class MainActivity extends AppCompatActivity {


    private Button game1, game2, game3, game4;
    public static Resources resources;
    public static MainActivity mInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = getResources();
        mInstance = this;

        game1 = findViewById(R.id.Game1);
        game2 = findViewById(R.id.Game2);
        game3 = findViewById(R.id.Game3);
        game4 = findViewById(R.id.Game4);

        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TicTacToe.class));
                finish();
            }
        });
        
        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Rules.class));
                finish();
            }
        });

        game3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Game3Activity.class));
                finish();
            }
        });
    }

    public static MainActivity getInstance() {
        return mInstance;
    }

    public static Resources getRes() {
        return resources;
    }
}

