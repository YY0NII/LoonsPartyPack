package com.example.loonspartypack.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loonspartypack.Game1.TicTacToe;
import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

public class Rules extends AppCompatActivity {

    public Button playBtn, mainMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);

        playBtn = findViewById(R.id.playBtn);
        mainMenuBtn = findViewById(R.id.mainMenuBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rules.this, Game2Activity.class));
                finish();
            }
        });

        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rules.this, MainActivity.class));
                finish();
            }
        });

    }
}