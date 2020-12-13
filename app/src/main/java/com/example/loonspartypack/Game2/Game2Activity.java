package com.example.loonspartypack.Game2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loonspartypack.R;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2Activity extends AppCompatActivity {
    //Game Menu buttons
    Button rules, reset;

    View screen;

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

    int player1Points = 1+2+3+4+5+6+7+8+9;
    int player2Points = 1+2+3+4+5+6+7+8+9;
    int dice1, dice2, diceSum; //dice value and the sum of both dice

    List<Integer> combinations; //all available combinations of digits for the rolled dice

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
        player2_roll2Btn = findViewById(R.id.b_player2_roll2);

        //assigning the image views
        dice1View = findViewById(R.id.dice1IV);
        dice2View = findViewById(R.id.dice2IV);
        statusView = findViewById(R.id.statusTV);

        //assigning the text views
        player1PointsView = findViewById(R.id.player1PointsTV);
        player2PointsView = findViewById(R.id.player2PointsTV);
        statusView = findViewById(R.id.statusTV);

        combinations = new ArrayList<>();

        //disable player 1 buttons
        for (Button button : player1Buttons) {
            button.setEnabled(false);
        }

        //disable player 2 buttons
        for (Button button : player2Buttons) {
            button.setEnabled(false);
        }

        //disable all roll buttons besides player 1's roll 2 button
        player1_roll1Btn.setEnabled(false);
        player2_roll1Btn.setEnabled(false);
        player2_roll2Btn.setEnabled(false);

        //long click listener for the view
        screen = findViewById(R.id.screen);
        //screen.setOnLongClickListener();
        


        //add click listeners for Player 1's buttons
        for (Button button : player1Buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //make tile invis
                    v.setVisibility(View.INVISIBLE);

                    //disable all tiles
                    for(Button button: player1Buttons){
                        button.setEnabled(false);
                    }

                    //subtract tile value from points
                    diceSum = diceSum - Integer.parseInt(v.getTag().toString());
                    player1Points = player1Points - Integer.parseInt(v.getTag().toString());

                    //calculate remaining tiles
                    calculateTiles(diceSum, player1Buttons);

                    //check if turn is done
                    if(diceSum == 0){
                        dice1View.setVisibility(View.GONE);
                        dice2View.setVisibility(View.GONE);

                        //enable one or both dice based on the rules
                        if(player1_7Btn.getVisibility() == View.VISIBLE
                                || player1_8Btn.getVisibility() == View.VISIBLE
                                || player1_9Btn.getVisibility() == View.VISIBLE){
                            player1_roll1Btn.setEnabled(false);
                            player1_roll2Btn.setEnabled(true);
                        }
                        else{
                            player1_roll1Btn.setEnabled(true);
                            player1_roll2Btn.setEnabled(true);
                        }

                        //disable tiles
                        for(Button button: player1Buttons){
                            button.setEnabled(false);
                        }
                    } else{
                        checkPlayer1End();
                    }

                }
            });
        }

        //add click listeners for Player 2's buttons
        for (Button button : player2Buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //make tile invis
                    v.setVisibility(View.INVISIBLE);

                    //disable all tiles
                    for(Button button: player2Buttons){
                        button.setEnabled(false);
                    }

                    //subtract tile value from points
                    diceSum = diceSum - Integer.parseInt(v.getTag().toString());
                    player2Points = player2Points - Integer.parseInt(v.getTag().toString());

                    //calculate remaining tiles
                    calculateTiles(diceSum, player1Buttons);

                    //check if turn is done
                    if(diceSum == 0){
                        dice1View.setVisibility(View.GONE);
                        dice2View.setVisibility(View.GONE);

                        //enable one or both dice based on the rules
                        if(player2_7Btn.getVisibility() == View.VISIBLE
                                || player2_8Btn.getVisibility() == View.VISIBLE
                                || player2_9Btn.getVisibility() == View.VISIBLE){
                            player2_roll1Btn.setEnabled(false);
                            player2_roll2Btn.setEnabled(true);
                        }
                        else{
                            player2_roll1Btn.setEnabled(true);
                            player2_roll2Btn.setEnabled(true);
                        }

                        //disable tiles
                        for(Button button: player2Buttons){
                            button.setEnabled(false);
                        }
                    } else{
                        checkPlayer2End();
                    }

                }
            });
        }

        //add player 1 roll button listeners
        player1_roll1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1_roll1Btn.setEnabled(false);
                player1_roll2Btn.setEnabled(false);

                //show dice
                Random random = new Random();
                dice1 = random.nextInt(6) + 1;
                diceSum = dice1;
                dice1View.setVisibility(View.VISIBLE);
                setDiceImages(dice1, dice1View);

                //calculate the tiles
                calculateTiles(diceSum, player1Buttons);

                //check if this player won
                checkPlayer1End();

            }
        });

        player1_roll2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1_roll1Btn.setEnabled(false);
                player1_roll2Btn.setEnabled(false);

                //show dice
                Random random = new Random();
                dice1 = random.nextInt(6) + 1;
                dice2 = random.nextInt(6) + 1;
                diceSum = dice1 + dice2;
                dice1View.setVisibility(View.VISIBLE);
                dice2View.setVisibility(View.VISIBLE);
                setDiceImages(dice1, dice1View);
                setDiceImages(dice2, dice2View);

                //calculate the tiles
                calculateTiles(diceSum, player1Buttons);

                //check if this player won
                checkPlayer1End();


            }
        });

        //add player 2 roll button listeners
        player2_roll1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2_roll1Btn.setEnabled(false);
                player2_roll2Btn.setEnabled(false);

                //show dice
                Random random = new Random();
                dice1 = random.nextInt(6) + 1;
                diceSum = dice1;
                dice1View.setVisibility(View.VISIBLE);
                setDiceImages(dice1, dice1View);

                //calculate the tiles
                calculateTiles(diceSum, player2Buttons);

                //check if this player won
                checkPlayer2End();

            }
        });

        player2_roll2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player2_roll1Btn.setEnabled(false);
                player2_roll2Btn.setEnabled(false);

                //show dice
                Random random = new Random();
                dice1 = random.nextInt(6) + 1;
                dice2 = random.nextInt(6) + 1;
                diceSum = dice1 + dice2;
                dice1View.setVisibility(View.VISIBLE);
                dice2View.setVisibility(View.VISIBLE);
                setDiceImages(dice1, dice1View);
                setDiceImages(dice2, dice2View);

                //calculate the tiles
                calculateTiles(diceSum, player2Buttons);

                //check if this player won
                checkPlayer2End();
            }
        });
    }

        //set dice image
        private void setDiceImages(int number, ImageView image){
            switch(number){
                case 1:
                    image.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    image.setImageResource(R.drawable.dice2);
                    break;
                case 3:
                    image.setImageResource(R.drawable.dice3);
                    break;
                case 4:
                    image.setImageResource(R.drawable.dice4);
                    break;
                case 5:
                    image.setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    image.setImageResource(R.drawable.dice6);
                    break;
            }
        }

        //show available numbers for the rolled dice
        private void showDigits(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial){
            int s=0;
            for(int x:partial){
                s +=x;
            }
            if(s == target){
                for(int num:partial){
                    if(!combinations.contains(num)){
                        combinations.add(num);
                    }
                }
            }
            if(s >= target){
                return;
            }

            for (int i = 0; i < numbers.size(); i++){
                ArrayList<Integer> remaining = new ArrayList<>();
                int n = numbers.get(i);
                for(int j = i+1; j < numbers.size(); j++){
                    remaining.add(j);
                }
                ArrayList<Integer> partial_rec = new ArrayList<>(partial);
                partial_rec.add(n);
                showDigits(remaining, target, partial_rec);
            }
        }

        private void showNumbers(ArrayList<Integer> numbers, int target){
        combinations.clear();
        showDigits(numbers, target, new ArrayList<Integer>());
        }

        private void calculateTiles(int number, List<Button> buttons){
            //save available tiles
            ArrayList<Integer> numbers = new ArrayList<>();
            for(Button button:buttons){
                if(button.getVisibility() == View.VISIBLE){
                    numbers.add(Integer.parseInt(button.getTag().toString()));
                }
            }

            //calculate
            showNumbers(numbers, number);

            //enable available tiles
            for(int num:combinations){
                buttons.get(num-1).setEnabled(true);
            }
        }

        //check if player 1's turn is over
        private void checkPlayer1End(){
        //check is there are available tiles
        boolean playerTurn = true;
        for(Button button:player1Buttons){
            if(button.isEnabled()){
                playerTurn = false;
            }
        }

        //if no tiles are available it's the other player's turn
        if(playerTurn) {
            statusView.setText("" + player1Points);
            statusView.setText("Player 2 roll the dice!");

            player2_roll2Btn.setEnabled(true);
        }

        //check if player1 wins
            boolean checkWin= true;
        for(Button button:player1Buttons){
            if(button.getVisibility() == View.VISIBLE){
                checkWin = false;
            }
        }
        
        if(checkWin){
            statusView.setText("Player 1 wins!");
        }

        }

    //check if player 2's turn is over
    private void checkPlayer2End() {
        //check is there are available tiles
        boolean playerTurn = true;
        for (Button button : player2Buttons) {
            if (button.isEnabled()) {
                playerTurn = false;
            }
        }

        //if no tiles are available it's the other player's turn
        if (playerTurn) {
            statusView.setText("" + player2Points);
            if(player1Points < player2Points){
                statusView.setText("Player 1 wins!");
            }
            else if(player2Points < player1Points){
                statusView.setText("Player 2 wins!");
            }
            else{
                statusView.setText("Draw!");
            }
        }

        //check if player2 wins
        boolean checkWin = true;
        for (Button button : player2Buttons) {
            if (button.getVisibility() == View.VISIBLE) {
                checkWin = false;
            }
        }


        if (checkWin) {
            statusView.setText("Player 2 wins!");
        }

    }

    }
