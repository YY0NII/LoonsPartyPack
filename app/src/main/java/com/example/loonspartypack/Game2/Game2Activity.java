package com.example.loonspartypack.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loonspartypack.R;

import java.util.ArrayList;
import java.util.List;

public class Game2Activity extends AppCompatActivity {

    //player 1's tile buttons
    Button player1_1Btn, player1_2Btn, player1_3Btn, player1_4Btn, player1_5Btn, player1_6Btn, player1_7Btn, player1_8Btn, player1_9Btn;
    //player 2's tile buttons
    Button player2_1Btn, player2_2Btn, player2_3Btn, player2_4Btn, player2_5Btn, player2_6Btn, player2_7Btn, player2_8Btn, player2_9Btn;

    //the dice roll buttons
    Button player1_roll1Btn, player2_roll1Btn, player1_roll2Btn, player2_roll2Btn;

    List <Button> player1Buttons;
    List<Button> player2Buttons;

    //the image views that display the dice pngs
    ImageView dice1View, dice2View;

    //TextViews for both players' points and the status message
    TextView player1PointsView, player2PointsView;
    TextView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        //assigning all the button objects for player 1's tiles
        player1_1Btn = findViewById(R.id.b_player1_1);
        player1_2Btn = findViewById(R.id.b_player1_2);
        player1_3Btn = findViewById(R.id.b_player1_3);
        player1_4Btn = findViewById(R.id.b_player1_4);
        player1_5Btn = findViewById(R.id.b_player1_5);
        player1_6Btn = findViewById(R.id.b_player1_6);
        player1_7Btn = findViewById(R.id.b_player1_7);
        player1_8Btn = findViewById(R.id.b_player1_8);
        player1_9Btn = findViewById(R.id.b_player1_9);
        
        //
        player1_1Btn.setTag("1");
        player1_2Btn.setTag("2");
        player1_3Btn.setTag("3");
        player1_4Btn.setTag("4");
        player1_5Btn.setTag("5");
        player1_6Btn.setTag("6");
        player1_7Btn.setTag("7");
        player1_8Btn.setTag("8");
        player1_9Btn.setTag("9");

        //
        player1Buttons = new ArrayList<>();
        player1Buttons.add(player1_1Btn);
        player1Buttons.add(player1_2Btn);
        player1Buttons.add(player1_3Btn);
        player1Buttons.add(player1_4Btn);
        player1Buttons.add(player1_5Btn);
        player1Buttons.add(player1_6Btn);
        player1Buttons.add(player1_7Btn);
        player1Buttons.add(player1_8Btn);
        player1Buttons.add(player1_9Btn);
        

        //doing the same for player 2's tiles
        player2_1Btn = findViewById(R.id.b_player2_1);
        player2_2Btn = findViewById(R.id.b_player2_2);
        player2_3Btn = findViewById(R.id.b_player2_3);
        player2_4Btn = findViewById(R.id.b_player2_4);
        player2_5Btn = findViewById(R.id.b_player2_5);
        player2_6Btn = findViewById(R.id.b_player2_6);
        player2_7Btn = findViewById(R.id.b_player2_7);
        player2_8Btn = findViewById(R.id.b_player2_8);
        player2_9Btn = findViewById(R.id.b_player2_9);

        //
        player2_1Btn.setTag("1");
        player2_2Btn.setTag("2");
        player2_3Btn.setTag("3");
        player2_4Btn.setTag("4");
        player2_5Btn.setTag("5");
        player2_6Btn.setTag("6");
        player2_7Btn.setTag("7");
        player2_8Btn.setTag("8");
        player2_9Btn.setTag("9");

        //
        player2Buttons = new ArrayList<>();
        player2Buttons.add(player2_1Btn);
        player2Buttons.add(player2_2Btn);
        player2Buttons.add(player2_3Btn);
        player2Buttons.add(player2_4Btn);
        player2Buttons.add(player2_5Btn);
        player2Buttons.add(player2_6Btn);
        player2Buttons.add(player2_7Btn);
        player2Buttons.add(player2_8Btn);
        player2Buttons.add(player2_9Btn);

        player1_roll1Btn = findViewById(R.id.b_player1_roll1);
        player1_roll2Btn = findViewById(R.id.b_player1_roll2);

        player2_roll1Btn = findViewById(R.id.b_player2_roll1);
        player2_roll1Btn = findViewById(R.id.b_player2_roll1);

        //assigning the image views
        dice1View = findViewById(R.id.dice1IV);
        dice2View = findViewById(R.id.dice2IV);
        statusView = findViewById(R.id.statusTV);

        //assigning the text views
        player1PointsView = findViewById(R.id.player1PointsTV);
        player2PointsView = findViewById(R.id.player2PointsTV);
        statusView = findViewById(R.id.statusTV);

        //disable player 1 buttons
        for(Button button: player1Buttons){
            button.setEnabled(false);
        }

        //disable player 2 buttons
        for(Button button: player2Buttons){
            button.setEnabled(false);
        }

    }
}