package com.example.telegramkiller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.telegramkiller.activities.SignInActivity;
import com.example.telegramkiller.activities.SignUpActivity;

import moxy.MvpAppCompatActivity;

public class SplashScreen extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Button bin = findViewById(R.id.bin);
        Button bup = findViewById(R.id.bup);
        bin.setOnClickListener(v -> {
            Intent i = new Intent(SplashScreen.this, SignInActivity.class);
            startActivity(i);

        });
        bup.setOnClickListener(v -> {
            Intent i =  new Intent(SplashScreen.this, SignUpActivity.class);
            startActivity(i);
        });
    }
}