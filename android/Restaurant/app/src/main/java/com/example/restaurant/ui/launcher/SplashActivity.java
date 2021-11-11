package com.example.restaurant.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.R;
import com.example.restaurant.ui.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        performSplash();
    }

    //wait 1.5 seconds and open app
    private void performSplash() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            //launch splash activity and
            //decide what activity to open
            //login or main
            //TODO: create deciding method on which activity to open
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.foreground_activity_slide_in, R.anim.background_activity_slide_out);

            finish();
        }, 1500);
    }
}