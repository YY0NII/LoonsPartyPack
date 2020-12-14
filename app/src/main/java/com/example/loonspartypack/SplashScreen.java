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

    // Slash Screen code is taken directly from My Individual Project 1 (Jonathon Carrera)
    // I didn't know what a splash screen was or how to make one so I did end up using
    // Online resources to help me out the main source I used is here:
    // https://abhiandroid.com/programming/splashscreen

    Handler handler; // This is my first time ever using a handler, Sadly I'm still not 100% sure
    // how it works but in this case we used it to hold the splash screen for 3 seconds

    ImageView lpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        lpp = findViewById(R.id.lpp);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(lpp, "rotation", 0f, 720f);
        rotate.setDuration(3000);
        rotate.start();

        handler = new Handler(); // I don't really know why Handler gets crossed out here but without this line the code crashes

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish(); // without this line the splash screen would pop back up after hitting the back button
            }
        },3000);// The 3000 delays the splashscreen for 3 seconds
    }
}