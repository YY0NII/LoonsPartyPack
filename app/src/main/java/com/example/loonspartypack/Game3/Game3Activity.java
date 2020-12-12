package com.example.loonspartypack.Game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loonspartypack.MainActivity;
import com.example.loonspartypack.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game3Activity extends AppCompatActivity {

    private ImageView currentView = null;
    private TextView turnTextView = null;
    private int countPair = 0;
    final int[] drawable = new int[]{R.drawable.ic_android_character, R.drawable.ic_controller, R.drawable.ic_snow_flake, R.drawable.ic_football, R.drawable.ic_bike, R.drawable.ic_sun, R.drawable.ic_fork_knife, R.drawable.ic_baseline_plumbing_24};

    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;
    int turns = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        RandomizeArray(pos);

        final TextView turnTextView = (TextView)findViewById(R.id.turnTextView);
        turnTextView.setText("Turn:" + String.valueOf(turns));
        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("COUNTPAIR", String.valueOf(countPair));

                if(currentPos < 0){
                    currentPos = i;
                    currentView = (ImageView) view;
                    ((ImageView)view).setImageResource(drawable[pos[i]]);
                } else {
                    if(currentPos == i){
                        ((ImageView)view).setImageResource(R.drawable.ic_pick);
                    } else if(pos[currentPos] != pos[i]){
                        currentView.setImageResource(R.drawable.ic_pick);
                        //Toast.makeText(getApplicationContext(), "No Match", Toast.LENGTH_SHORT).show();
                        turns++;
                        turnTextView.setText("Turn:" + String.valueOf(turns));
                    } else {
                        ((ImageView)view).setImageResource(drawable[pos[i]]);
                        countPair++;
                        if(countPair == 8){
                            Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();

                            Intent i1 = new Intent(getApplicationContext(), EndGame.class);
                            i1.putExtra("score", turns);

                            startActivity(i1);
                        }
                    }

                    currentPos = -1;
                }
            }
        });
    }

    public static int[] RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }
}