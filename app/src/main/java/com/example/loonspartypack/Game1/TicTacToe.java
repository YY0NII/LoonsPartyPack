//******************************************************
// File: TicTacToe.java
//
// Purpose: Contains necessary code for the tictactoe
// game
//
// Written By: Jonathon Carrera
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack.Game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

import static java.lang.Boolean.FALSE;

public class TicTacToe extends AppCompatActivity {
    private boolean player1 = false;
    private boolean player2 = false;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button[] buttons = new Button[9];

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);

        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        buttons[3] = b4;
        buttons[4] = b5;
        buttons[5] = b6;
        buttons[6] = b7;
        buttons[7] = b8;
        buttons[8] = b9;

        textView = (TextView) findViewById(R.id.tv1);
    }

    //region Methods

    //****************************************************
    // Method: buttonClicked()
    //
    // Purpose: sets the text of the clicked button to
    // either "X" or "O" depending on which player has
    // clicked
    //****************************************************
    public void buttonClicked(View v) {
        Button theButton = (Button) v;

        if (!player1 && !player2) {
            theButton.setText("X");
            player1 = true;
        } else if (player1 && !player2) {
            theButton.setText("O");
            player2 = true;
        } else if (player1) {
            theButton.setText("X");
            player2 = false;
        }

        theButton.setEnabled(false);

        checkIfOver();
    }

    //****************************************************
    // Method: reset()
    //
    // Purpose: To reset the game so that users may play
    // again
    //****************************************************
    public void reset(View v){
        clearButtonText();
        enableButtons();
        textView.setText(R.string.tictactoe);
    }

    //****************************************************
    // Method: checkIfOver()
    //
    // Purpose: To check if a player has won horizontally,
    // vertically, diagonally, or if all buttons have been
    // pressed and their is no winner.
    //****************************************************
    public void checkIfOver()
    {
        //region Check For Horizontal Win
        if ( !b1.getText().toString().isEmpty() && b1.getText().toString().equals(b2.getText().toString())
                &&  b1.getText().toString().equals(b3.getText().toString()) )
        {
            checkWhoWon(b1);
            disableButtons();
        }
        else if ( !b4.getText().toString().isEmpty() && b4.getText().toString().equals(b5.getText().toString())
                &&  b4.getText().toString().equals(b6.getText().toString()) )
        {
            checkWhoWon(b4);
            disableButtons();
        }
        else if ( !b7.getText().toString().isEmpty() && b7.getText().toString().equals(b8.getText().toString())
                &&  b7.getText().toString().equals(b9.getText().toString()) )
        {
            checkWhoWon(b7);
            disableButtons();
        }
        //endregion

        //region Check For Vertical  Win
        if ( !b1.getText().toString().isEmpty() && b1.getText().toString().equals(b4.getText().toString())
                &&  b1.getText().toString().equals(b7.getText().toString()) )
        {
            checkWhoWon(b1);
            disableButtons();
        }
        else if ( !b2.getText().toString().isEmpty() && b2.getText().toString().equals(b5.getText().toString())
                &&  b2.getText().toString().equals(b8.getText().toString()) )
        {
            checkWhoWon(b2);
            disableButtons();
        }
        else if ( !b3.getText().toString().isEmpty() && b3.getText().toString().equals(b6.getText().toString())
                &&  b3.getText().toString().equals(b9.getText().toString()) )
        {
            checkWhoWon(b3);
            disableButtons();
        }
        //endregion

        //region Check For Diagonal  Win
        if ( !b1.getText().toString().isEmpty() && b1.getText().toString().equals(b5.getText().toString())
                &&  b1.getText().toString().equals(b9.getText().toString()) )
        {
            checkWhoWon(b1);
            disableButtons();
        }
        else if ( !b3.getText().toString().isEmpty() && b3.getText().toString().equals(b5.getText().toString())
                &&  b3.getText().toString().equals(b7.getText().toString()) )
        {
            checkWhoWon(b3);
            disableButtons();
        }
        //endregion

        //region Check For No winner
        if ( !b1.getText().toString().isEmpty() && !b2.getText().toString().isEmpty() && !b3.getText().toString().isEmpty()
                && !b4.getText().toString().isEmpty() && !b5.getText().toString().isEmpty() && !b6.getText().toString().isEmpty()
                && !b7.getText().toString().isEmpty() && !b8.getText().toString().isEmpty() && !b9.getText().toString().isEmpty() )
        {
            Toast.makeText(TicTacToe.this, "Game Over", Toast.LENGTH_LONG).show();
            disableButtons();
        }
        //endregion
    }

    //****************************************************
    // Method: disableButtons()
    //
    // Purpose: Disables all currently enabled buttons
    //****************************************************
    public void disableButtons(){
        for (int i = 0; i < 9; i++){
            if (buttons[i].isEnabled()){
                buttons[i].setEnabled(false);
            }
        }
    }

    public void checkWhoWon(Button button){
        if (button.getText().toString().equals("X")){
            Toast.makeText(TicTacToe.this, "X Wins", Toast.LENGTH_LONG).show();
            textView.setText(R.string.x_wins);
        } else if (button.getText().toString().equals("O")){
            Toast.makeText(TicTacToe.this, "O Wins", Toast.LENGTH_LONG).show();
            textView.setText(R.string.o_wins);
        }
    }

    //****************************************************
    // Method: onBackPressed()
    //
    // Purpose: To override the default onBackPressed()
    // so that the rest of the application is not locked
    // to portrait mode
    //****************************************************
    @Override
    public void onBackPressed() {
        startActivity(new Intent(TicTacToe.this, MainActivity.class));
        finish();
    }

    //****************************************************
    // Method: clearButtonText()
    //
    // Purpose: Clears the text of all 9 game buttons
    //****************************************************
    public void clearButtonText(){
        for (int i = 0; i < 9; i++){
            buttons[i].setText("");
        }
    }

    //****************************************************
    // Method: enableButtons()
    //
    // Purpose: re-enables game buttons
    //****************************************************
    public void enableButtons(){
        for (int i = 0; i < 9; i++){
            if (!buttons[i].isEnabled()){
                buttons[i].setEnabled(true);
            }
        }
    }

    //endregion
}