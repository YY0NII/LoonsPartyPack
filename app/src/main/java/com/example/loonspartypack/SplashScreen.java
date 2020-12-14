//******************************************************
// File: SplashScreen.java
//
// Purpose: to host the necessary code for the splash screen
// of our app
//
// Written By: Jonathon Carrera & Tom Willoughby
//
// Compiler: Android Studio
//
//******************************************************
package com.example.loonspartypack;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    Handler handler;
    ImageView lpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        lpp = findViewById(R.id.lpp);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(lpp, "rotation", 0f, 720f);
        rotate.setDuration(3000);
        rotate.start();

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}