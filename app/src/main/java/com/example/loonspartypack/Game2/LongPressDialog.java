package com.example.loonspartypack.Game2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.loonspartypack.MainActivity;

public class LongPressDialog extends AppCompatDialogFragment {

    public Button menuPlayBtn, quitBtn, rulesBtn;



    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Menu").setPositiveButton("Play", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getContext(), Game2Activity.class));
            }
        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        builder.setNeutralButton("Rules", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getContext(), Rules.class));
            }
        });
        return builder.create();
    }
}
