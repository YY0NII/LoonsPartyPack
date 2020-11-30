package com.example.loonspartypack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loonspartypack.Game2.Game2Activity;

public class MainActivity extends AppCompatActivity {

    private Button game1, game2, game3, game4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game1 = findViewById(R.id.Game1);
        game2 = findViewById(R.id.Game2);
        game3 = findViewById(R.id.Game3);
        game4 = findViewById(R.id.Game4);

        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Game2Activity.class));
                finish();
                }
            });
        }
    }